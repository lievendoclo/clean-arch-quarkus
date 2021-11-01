package org.acme.infra.web.graphql;

import org.acme.infra.web.model.JsonCustomer;
import org.acme.app.query.GetCustomers;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Description;
import java.util.stream.Collectors;
import java.util.List;


@GraphQLApi
public class CustomerGraphQLQuery {

    private GetCustomers getCustomers;

    public CustomerGraphQLQuery(GetCustomers getCustomers) {
        this.getCustomers = getCustomers;
    }

    @Query("customers")
    @Description("Get all customers")
    public List<JsonCustomer> getAllFilms() {
        return getCustomers.getCustomers().stream()
        .map(response -> new JsonCustomer(response.getName()))
        .collect(Collectors.toList());
    }
}
