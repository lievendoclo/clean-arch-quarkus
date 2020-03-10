package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private GetCustomers getCustomers;

    public CustomerResource(GetCustomers getCustomers) {
        this.getCustomers = getCustomers;
    }

    @GET
    public List<JsonCustomer> list() {
        return getCustomers.getCustomer().stream()
                .map(response -> new JsonCustomer(response.getName()))
                .collect(Collectors.toList());
    }
}