package org.acme.app.query.impl

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import org.acme.app.query.GetCustomersQuery
import org.acme.domain.customer.CustomerGateway
import java.util.stream.Collectors

@ApplicationScoped
@Transactional
class GetCustomersQueryImpl @Inject constructor(private val customerGateway: CustomerGateway) : GetCustomersQuery {
    override fun customers(): List<GetCustomersQuery.Response> {
        return customerGateway.allCustomers()
            .map { GetCustomersQuery.Response(it.id, it.name) }
    }
}
