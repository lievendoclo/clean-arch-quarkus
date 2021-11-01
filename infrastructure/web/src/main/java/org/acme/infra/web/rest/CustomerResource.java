package org.acme.infra.web.rest;

import org.acme.app.query.GetCustomers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
        return getCustomers.getCustomers().stream()
                .map(response -> new JsonCustomer(response.getName()))
                .collect(Collectors.toList());
    }

    public static class JsonCustomer {
        private String name;

        public JsonCustomer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
