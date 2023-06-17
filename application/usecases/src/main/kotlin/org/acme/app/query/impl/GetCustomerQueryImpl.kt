package org.acme.app.query.impl

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import org.acme.app.command.CreateCustomerCommand
import org.acme.app.query.GetCustomerQuery
import org.acme.app.query.GetCustomersQuery
import org.acme.domain.customer.CustomerGateway
import java.util.stream.Collectors

@ApplicationScoped
@Transactional
class GetCustomerQueryImpl @Inject constructor(private val customerGateway: CustomerGateway) : GetCustomerQuery {
    override fun <T> customer(request: GetCustomerQuery.Request, presenter: (GetCustomerQuery.Response) -> T): T {
        return presenter(with(customerGateway.customerById(request.id)) {
            GetCustomerQuery.Response(id, name)
        })
    }
}
