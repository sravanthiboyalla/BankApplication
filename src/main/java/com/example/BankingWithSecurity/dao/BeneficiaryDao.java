package com.example.BankingWithSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankingWithSecurity.model.Beneficiary;


public interface BeneficiaryDao extends JpaRepository<Beneficiary,Long> {

	public Beneficiary findByOwnerAccountNumber(String fromAccountNumber);

}
