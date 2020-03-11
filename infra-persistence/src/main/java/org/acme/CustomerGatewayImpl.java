package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CustomerGatewayImpl implements CustomerGateway {
	private CustomerRepository customerRepository;

	@Inject
	public CustomerGatewayImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll().stream()
				.map(c -> new Customer(c.getName()))
				.collect(Collectors.toList());
	}
}
