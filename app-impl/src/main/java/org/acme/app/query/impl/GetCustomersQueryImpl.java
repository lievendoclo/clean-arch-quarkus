package org.acme.app.query.impl;

import org.acme.app.query.GetCustomersQuery;
import org.acme.domain.customer.CustomerGateway;
import org.acme.app.UseCase;

import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
public class GetCustomersQueryImpl implements GetCustomersQuery {
    private CustomerGateway customerGateway;

    @Inject
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
