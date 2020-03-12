package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.inject.Singleton;

@Singleton
public class CustomerRepository implements PanacheRepository<CustomerJpa> {
}
