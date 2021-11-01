package org.acme.main;

import org.acme.app.query.GetCustomers;
import org.acme.app.query.impl.GetCustomersQuery;
import org.acme.domain.customer.CustomerGateway;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.function.Supplier;

public class UseCasesWiring {
    @Inject
    private UserTransaction transaction;

    @Produces
    @Singleton
    public GetCustomers getCustomers(CustomerGateway customerGateway) {
        return () -> withinTransaction(() -> new GetCustomersQuery(customerGateway).getCustomers());
    }

    private <T> T withinTransaction(Supplier<T> fn) {
        try {
            transaction.begin();
            T t = fn.get();
            transaction.commit();
            return t;
        } catch (Exception ex) {
            try {
                transaction.rollback();
            } catch (SystemException e) {
                throw new RuntimeException("Error rolling back transaction", ex);
            }
            throw new RuntimeException(ex);
        }
    }
}
