package org.acme.app.query.impl;

import org.acme.app.query.GetCustomers;
import org.acme.domain.customer.CustomerGateway;

import java.util.List;
import java.util.stream.Collectors;

public class GetCustomersQuery implements GetCustomers {
    private CustomerGateway customerGateway;

    public GetCustomersQuery(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public List<Response> getCustomers() {
        return customerGateway.getAllCustomers().stream()
                .map(customer -> new GetCustomers.Response(customer.getName()))
                .collect(Collectors.toList());
    }
}
