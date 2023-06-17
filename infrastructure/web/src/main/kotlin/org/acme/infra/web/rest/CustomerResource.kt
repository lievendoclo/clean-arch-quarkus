package org.acme.infra.web.rest

import jakarta.ws.rs.*
import jakarta.ws.rs.core.Context
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.UriInfo
import org.acme.app.command.CreateCustomerCommand
import org.acme.app.query.GetCustomerQuery
import org.acme.app.query.GetCustomersQuery
import org.acme.infra.web.model.JsonCustomer


@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
class CustomerResource(
    private val getCustomers: GetCustomersQuery,
    private val getCustomer: GetCustomerQuery,
    private val createCustomerCommand: CreateCustomerCommand,
)
{
    @GET
    fun list(): List<JsonCustomer> {
        return getCustomers.customers {
            it.map { c -> JsonCustomer(c.id, c.name) }
        }

    }

    @GET
    @Path("{id}")
    fun get(@PathParam("id") id: String): JsonCustomer {
        return getCustomer.customer(GetCustomerQuery.Request(id)) {
            JsonCustomer(it.id, it.name)
        }
    }

    @POST
    fun create(payload: CreateCustomerPayload, @Context uriInfo: UriInfo): Response {
        val id = createCustomerCommand.create(CreateCustomerCommand.Request(payload.name)).id
        val uriBuilder = uriInfo.absolutePathBuilder
        uriBuilder.path(id)
        return Response.created(uriBuilder.build()).build()

    }

    data class CreateCustomerPayload(val name: String)
}
