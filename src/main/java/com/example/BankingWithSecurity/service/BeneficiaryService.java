package com.example.BankingWithSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankingWithSecurity.dao.AccountDao;
import com.example.BankingWithSecurity.dao.BeneficiaryDao;
import com.example.BankingWithSecurity.exceptions.AccountNotFoundException;
import com.example.BankingWithSecurity.model.Account;
import com.example.BankingWithSecurity.model.Beneficiary;



@Service
public class BeneficiaryService {

	@Autowired
	AccountDao accountDao;
	@Autowired
	BeneficiaryDao beneficiaryDao;
	
	public String addBeneficiary(Beneficiary beneficiary) {
		Account account=new Account();
		account.setAmount(10000);
		account.setAccountNumber(beneficiary.getBeneficiaryAccountNumber());
		account.setName(beneficiary.getName());
		accountDao.save(account);
		Optional<Account> acc=Optional.of(accountDao.findByAccountNumber(beneficiary.getOwnerAccountNumber()));
		if(acc.isPresent())
		{
			beneficiaryDao.save(beneficiary);
			return "beneficiary details added successfully";
					
		}
		else
		{
			throw new AccountNotFoundException("Account Number not found");
		}
	}

}
