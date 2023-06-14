package org.acme.infra.persistence.customer

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity(name = "Customer")
@Table(name = "customer")
class CustomerJPAModel {
    @Id
    lateinit var id: String
    lateinit var name: String
}
