package org.acme;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@UseCase
public class GetCustomersImpl implements GetCustomers {
    private CustomerGateway customerGateway;

    @Inject
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
