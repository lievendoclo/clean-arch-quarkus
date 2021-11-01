package org.acme.infra.persistence.customer;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

import io.agroal.api.AgroalDataSource;
import org.acme.domain.customer.Customer;
import org.acme.domain.customer.CustomerGateway;
import org.jdbi.v3.core.Jdbi;

@Singleton
public class CustomerGatewayImpl implements CustomerGateway {
	@Inject
	private AgroalDataSource dataSource;

	@Override
	public List<Customer> getAllCustomers() {
		Jdbi jdbi = Jdbi.create(dataSource);
		String sql = "SELECT id, name FROM customer";
		return jdbi.withHandle(handle ->
			handle.createQuery(sql)
					.map((rs, ctx) -> new Customer(rs.getString("name")))
					.list()
		);
	}
}
