package org.acme.domain.customer

interface CustomerGateway {
	fun create(customer: Customer)
	fun allCustomers(): List<Customer>
	fun customerById(id: String): Customer
}
