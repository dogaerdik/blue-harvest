package com.blueharvest.account.repository;

import com.blueharvest.account.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    long countById(Long id);
}
