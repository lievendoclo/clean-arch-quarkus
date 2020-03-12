package org.acme;

import javax.enterprise.inject.Produces;

public class Persistence {
	@Produces
	public CustomerGateway customerGateway(CustomerRepository customerRepository) {
		return new CustomerGatewayImpl(customerRepository);
	}

	@Produces
	public CustomerRepository customerRepository() {
		return new CustomerRepository();
	}
}
