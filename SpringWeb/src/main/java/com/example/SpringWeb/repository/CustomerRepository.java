package com.example.SpringWeb.repository;


import com.example.SpringWeb.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
