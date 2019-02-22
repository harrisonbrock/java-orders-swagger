package com.harrisonbrock.sales.repositories;

import com.harrisonbrock.sales.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
