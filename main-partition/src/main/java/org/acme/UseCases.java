package org.acme;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.transaction.Transactional;

public class UseCases {
	@Produces
	@Singleton
	@Transactional
	public GetCustomers getCustomers(CustomerGateway customerGateway) {
		return new GetCustomersImpl(customerGateway);
	}
}
