package org.acme.app.query.impl

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import org.acme.app.command.CreateCustomerCommand
import org.acme.domain.customer.Customer
import org.acme.domain.customer.CustomerGateway
import java.util.*

@ApplicationScoped
@Transactional
class CreateCustomerCommandImpl @Inject constructor(private val customerGateway: CustomerGateway):
    CreateCustomerCommand {
    override fun create(request: CreateCustomerCommand.Request): CreateCustomerCommand.Response {
        val customer = Customer(UUID.randomUUID().toString(), request.name)
        customerGateway.create(customer)
        return CreateCustomerCommand.Response(customer.id)
    }
}