package com.example.BankingWithSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BankingWithSecurity.model.Account;


public interface AccountDao extends JpaRepository<Account,Long>{

	public Account findByAccountNumber(String accountNumber);

}
