package com.autogroup.AutoService.repository;

import com.autogroup.AutoService.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByLogin(String login);
}
