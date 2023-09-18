package br.ada.customer.crud.factory;

import br.ada.customer.crud.integration.database.MemoryDatabase;
import br.ada.customer.crud.integration.email.SendEmail;
import br.ada.customer.crud.integration.memoryrepository.OrderEntityMerge;
import br.ada.customer.crud.integration.memoryrepository.OrderMemoryRepositoryImpl;
import br.ada.customer.crud.usecases.*;
import br.ada.customer.crud.usecases.impl.*;
import br.ada.customer.crud.usecases.repository.OrderRepository;

public class OrderFactory {

    public static ICreateOrderUseCase createUseCase() {
        return new CreateOrderUseCaseImpl(
                createRepository(),
                CustomerFactory.createRepository()
        );
    }

    public static IOrderAddItemUseCase orderAddItemUseCase() {
        return new OrderAddItemUseCaseImpl(createRepository());
    }

    public static IOrderChangeAmountUseCase orderChangeAmountUseCase() {
        return new OrderChangeAmountUseCaseImpl(createRepository());
    }

    public static IOrderRemoveItemUseCase orderRemoveItemUseCase() {
        return new OrderRemoveItemUseCaseImpl(createRepository());
    }

    public static IOrderPlaceUseCase placeOrderUseCase() {
        return new OrderPlaceUseCaseImpl(
                createRepository(),
                OrderFactory.createNotifierOrderSendEmail()
        );
    }

    public static INotifierOrderUseCase createNotifierOrderSendEmail() {
        return new OrderAddItemUseCaseImpl.OrderEmailNotifierImpl(new SendEmail());
    }



    public static OrderRepository createRepository() {
        return new OrderMemoryRepositoryImpl(
                MemoryDatabase.getInstance(),
                new OrderEntityMerge(MemoryDatabase.getInstance())
        );
    }


    public static IOrderShippingUseCase shippingUseCase() {

        return new OrderShippingUseCaseImpl(
                createRepository(),
                OrderFactory.createNotifierOrderSendEmail()

        );
    }

    public static IOrderPayUseCase payOrderUseCase() {
        return new OrderPayUseCaseImpl(
                createRepository(),
                OrderFactory.createNotifierOrderSendEmail()
        );
    }

}

