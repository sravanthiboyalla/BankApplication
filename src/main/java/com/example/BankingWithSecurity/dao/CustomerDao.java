package com.example.BankingWithSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankingWithSecurity.model.Customer;



public interface CustomerDao extends JpaRepository<Customer,Long>{

	public Customer findByEmail(String email);

	public Customer findByPassport(String passport);

}
