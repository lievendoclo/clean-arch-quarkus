package org.acme;

import javax.enterprise.inject.Produces;

class Persistence {
	@Produces
	CustomerGateway customerGateway(CustomerRepository customerRepository) {
		return new CustomerGatewayImpl(customerRepository);
	}

	@Produces
	CustomerRepository customerRepository() {
		return new CustomerRepository();
	}
}
