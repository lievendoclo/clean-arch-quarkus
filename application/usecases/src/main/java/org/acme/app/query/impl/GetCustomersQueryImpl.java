package org.acme.app.query.impl;

import org.acme.app.query.GetCustomersQuery;
import org.acme.domain.customer.CustomerGateway;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@Transactional
public class GetCustomersQueryImpl implements GetCustomersQuery {
    private CustomerGateway customerGateway;

    public GetCustomersQueryImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public List<Response> getCustomers() {
        return customerGateway.getAllCustomers().stream()
                .map(customer -> new GetCustomersQuery.Response(customer.getName()))
                .collect(Collectors.toList());
    }
}
