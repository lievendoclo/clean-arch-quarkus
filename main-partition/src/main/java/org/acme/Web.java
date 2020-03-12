package org.acme;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

public class Web {
	@Produces
	@Singleton
	public CustomerResource customerResource(GetCustomers getCustomers) {
		return new CustomerResource(getCustomers);
	}
}
