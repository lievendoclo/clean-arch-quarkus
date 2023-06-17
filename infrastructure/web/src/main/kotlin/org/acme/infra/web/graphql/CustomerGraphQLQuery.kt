package org.acme.infra.web.graphql

import org.acme.app.command.CreateCustomerCommand
import org.acme.app.query.GetCustomerQuery
import org.acme.app.query.GetCustomersQuery
import org.acme.infra.web.model.JsonCustomer
import org.eclipse.microprofile.graphql.Description
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation
import org.eclipse.microprofile.graphql.Query
import java.util.stream.Collectors

@GraphQLApi
class CustomerGraphQLQuery(
    private val getCustomers: GetCustomersQuery,
    private val getCustomer: GetCustomerQuery,
    private val createCustomerCommand: CreateCustomerCommand,
) {

    @Description("Get all customers")
    @Query("customers")
    fun allCustomers(): List<JsonCustomer> {
        return getCustomers.customers {
            it.map { c -> JsonCustomer(c.id, c.name) }
        }
    }

    @Description("Create a customer")
    @Mutation("createCustomer")
    fun createCustomer(name: String): JsonCustomer {
        val id = createCustomerCommand.create(CreateCustomerCommand.Request(name)).id
        return getCustomer.customer(GetCustomerQuery.Request(id)) {
            JsonCustomer(it.id, it.name)
        }
    }
}
