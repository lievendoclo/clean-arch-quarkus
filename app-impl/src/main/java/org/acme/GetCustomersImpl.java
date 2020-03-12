package org.acme;

import java.util.List;
import java.util.stream.Collectors;

public class GetCustomersImpl implements GetCustomers {
    private CustomerGateway customerGateway;

    public GetCustomersImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public List<Response> getCustomers() {
        return customerGateway.getAllCustomers().stream()
                .map(customer -> new GetCustomers.Response(customer.getName()))
                .collect(Collectors.toList());
    }
}
