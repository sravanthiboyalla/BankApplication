package com.example.BankingWithSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankingWithSecurity.dao.AccountDao;
import com.example.BankingWithSecurity.model.Account;



@Service
public class AccountService {
	@Autowired
	AccountDao accountDao;

	public Account getAccounsByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return accountDao.findByAccountNumber(accountNumber);
	}

}
