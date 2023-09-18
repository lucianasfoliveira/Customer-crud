package br.ada.customer.crud.usecases;

import br.ada.customer.crud.model.Order;

public interface INotifierOrderUseCase extends IPayNotifierUseCase {
    void pendingPayment(Order order);

    void payOrder(Order order);

    void shipping(Order order);
}

