package org.acme;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerGatewayImpl implements CustomerGateway {
	@Override
	public List<Customer> getAllCustomers() {
		return CustomerJpa.<CustomerJpa>listAll().stream()
				.map(c -> new Customer(c.getName()))
				.collect(Collectors.toList());
	}
}
