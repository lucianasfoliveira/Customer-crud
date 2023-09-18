package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.IOrderChangeAmountUseCase;
import br.ada.customer.crud.usecases.IOrderRemoveItemUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

import java.math.BigDecimal;

public class OrderChangeAmountUseCaseImpl implements IOrderChangeAmountUseCase, IOrderRemoveItemUseCase {

    private final OrderRepository orderRepository;

    public OrderChangeAmountUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderItem changeAmount(Order order, Product product, Integer amount) {

        if (order.getStatus() != OrderStatus.OPEN) {
            throw new IllegalStateException("O pedido não pode ser alterado.");
        }

        OrderItem itemToChangeAmount = null;
        for (OrderItem item : order.getItems()) {
            if (item.getProduct().equals(product)) {
                itemToChangeAmount = item;
                break;
            }
        }

        if (itemToChangeAmount != null) {


            itemToChangeAmount.setAmount(amount);
            orderRepository.update(order);
        } else {
            throw new IllegalArgumentException("O produto não foi encontrado no pedido.");
        };
        return itemToChangeAmount;
    }

    @Override
    public void removeItem(Order order, Product product) {

    }

}