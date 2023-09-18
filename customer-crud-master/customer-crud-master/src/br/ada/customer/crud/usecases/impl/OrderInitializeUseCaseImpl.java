package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.IOrderInitializeUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class OrderInitializeUseCaseImpl implements IOrderInitializeUseCase  {

    private OrderRepository orderRepository;

    private OrderStatus orderStatus;

    public OrderInitializeUseCaseImpl (OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void orderInitialize() {
        Order order = new Order();
        orderRepository.save(order);
        order.setStatus(OrderStatus.OPEN);
    }
}
