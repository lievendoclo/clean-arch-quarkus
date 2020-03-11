package org.acme;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class UseCases {
	@Produces
	@ApplicationScoped
	public GetCustomers getCustomers(CustomerGateway customerGateway) {
		return new GetCustomersImpl(customerGateway);
	}
}
