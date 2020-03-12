package org.acme;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.transaction.Transactional;

class UseCases {
	@Produces
	@Singleton
	@Transactional
	GetCustomers getCustomers(CustomerGateway customerGateway) {
		return new GetCustomersImpl(customerGateway);
	}
}
