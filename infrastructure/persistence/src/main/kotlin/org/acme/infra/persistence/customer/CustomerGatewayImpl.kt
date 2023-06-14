package org.acme.infra.persistence.customer

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.acme.domain.customer.Customer
import org.acme.domain.customer.CustomerGateway
import java.util.stream.Collectors

@ApplicationScoped
@Transactional
class CustomerGatewayImpl @Inject constructor(private val entityManager: EntityManager) : CustomerGateway {
    override fun create(customer: Customer) {
        val jpa = CustomerJPAModel().let {
            it.id = customer.id
            it.name = customer.name
            it
        }
        entityManager.persist(jpa)
    }

    override fun allCustomers(): List<Customer> {
        val list = entityManager.createQuery("SELECT p FROM Customer p", CustomerJPAModel::class.java)
            .resultList
        return list.stream().map { Customer(it.id, it.name) }
            .collect(Collectors.toList())
    }

    override fun customerById(id: String): Customer {
        val r = entityManager.createQuery("SELECT p FROM Customer p WHERE p.id = :id", CustomerJPAModel::class.java)
            .setParameter("id", id)
            .singleResult
        return with(r) { Customer(this.id, this.name) }
    }
}
