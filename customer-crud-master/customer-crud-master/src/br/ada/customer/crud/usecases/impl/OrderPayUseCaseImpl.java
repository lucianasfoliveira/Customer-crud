package br.ada.customer.crud.usecases.impl;

import br.ada.customer.crud.model.Order;
import br.ada.customer.crud.model.OrderStatus;
import br.ada.customer.crud.usecases.INotifierOrderUseCase;
import br.ada.customer.crud.usecases.IOrderPayUseCase;
import br.ada.customer.crud.usecases.IPayNotifierUseCase;
import br.ada.customer.crud.usecases.repository.OrderRepository;

import static br.ada.customer.crud.model.OrderStatus.PENDING_PAYMENT;

public class OrderPayUseCaseImpl implements IOrderPayUseCase {

    private OrderRepository orderRepository;
    private INotifierOrderUseCase notifierUseCase;

    public OrderPayUseCaseImpl(OrderRepository orderRepository, INotifierOrderUseCase notifierUseCase) {
        this.orderRepository = orderRepository;
        this.notifierUseCase = notifierUseCase;
    }

    @Override
    public void pay(Order order) {
        if (order.getStatus() == OrderStatus.PENDING_PAYMENT) {
            order.setStatus(OrderStatus.PAID);
            orderRepository.update(order);
            notifierUseCase.notify(order);
        } else {
            throw new RuntimeException("O pagamento tem que estar com o status: PENDING_PAYMENT!");
        }
    }
}