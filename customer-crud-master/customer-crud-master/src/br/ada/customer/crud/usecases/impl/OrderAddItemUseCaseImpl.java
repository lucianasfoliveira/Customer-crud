package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.integration.email.SendEmail;
import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderItem;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.model.Product;
import br.ada.customer.crud.usecases.INotifierOrderUseCase;
import br.ada.customer.crud.usecases.IOrderAddItemUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.List;

public class OrderAddItemUseCaseImpl implements IOrderAddItemUseCase {

    private final OrderRepository orderRepository;

    public OrderAddItemUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderItem addItem(Order order, Product product, BigDecimal price, Integer amount) {
        if (order.getStatus() != OrderStatus.OPEN) {
            throw new IllegalStateException("O pedido não pode ser alterado.");
        }

        OrderItem orderItem = new OrderItem();
        List<OrderItem> orderItemList = order.getItems();
        orderItem.setProduct(product);
        orderItem.setSaleValue(price);
        orderItem.setAmount(amount);
        orderItemList.add(orderItem);
        order.setItems(orderItemList);

        orderRepository.update(order);
        return orderItem;
    }

    public static class OrderEmailNotifierImpl implements INotifierOrderUseCase {
        public OrderEmailNotifierImpl(SendEmail sendEmail) {
        }

        @Override
        public void pendingPayment(Order order) {

        }

        @Override
        public void payOrder(Order order) {

        }

        @Override
        public void shipping(Order order) {

        }

        @Override
        public void notify(Order order) {

        }
    }
}
