package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IOrderRemoveItemUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class OrderRemoveItemUseCaseImpl implements IOrderRemoveItemUseCase {
    private final OrderRepository orderRepository;

    public OrderRemoveItemUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void removeItem(Order order, Product product) {
        if (order.getStatus() != OrderStatus.OPEN) {
            throw new IllegalStateException("O pedido não pode ser alterado.");
        }
        OrderItem itemToRemove = null;
        for (OrderItem item : order.getItems()) {
            if (item.getProduct().equals(product)) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            order.getItems().remove(itemToRemove);
            orderRepository.update(order);
        } else {
            throw new IllegalArgumentException("O produto não foi encontrado no pedido.");
        }
    }
}