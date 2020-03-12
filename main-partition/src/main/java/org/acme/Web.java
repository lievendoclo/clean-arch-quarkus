package org.acme;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

class Web {
	@Produces
	@Singleton
	CustomerResource customerResource(GetCustomers getCustomers) {
		return new CustomerResource(getCustomers);
	}
}
