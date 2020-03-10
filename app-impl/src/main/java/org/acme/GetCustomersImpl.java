package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GetCustomersImpl implements GetCustomers {
    private CustomerGateway customerGateway;

    @Inject
    public GetCustomersImpl(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public List<Response> getCustomer() {
        return customerGateway.getAllCustomers().stream()
                .map(customer -> new GetCustomers.Response(customer.getName()))
                .collect(Collectors.toList());
    }
}
