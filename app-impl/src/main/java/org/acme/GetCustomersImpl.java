package org.acme;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class GetCustomersImpl implements GetCustomers {
    @Override
    public List<Response> getCustomer() {
        return Arrays.asList(
                new GetCustomers.Response("Joe"),
                new GetCustomers.Response("Jim")
        );
    }
}
