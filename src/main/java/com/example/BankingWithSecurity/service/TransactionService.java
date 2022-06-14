package com.example.BankingWithSecurity.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankingWithSecurity.dao.AccountDao;
import com.example.BankingWithSecurity.dao.BeneficiaryDao;
import com.example.BankingWithSecurity.dao.TransactionDao;
import com.example.BankingWithSecurity.exceptions.AccountNotFoundException;
import com.example.BankingWithSecurity.exceptions.BeneficiaryAccountNotFoundException;
import com.example.BankingWithSecurity.exceptions.InsufficientBalanceException;
import com.example.BankingWithSecurity.model.Account;
import com.example.BankingWithSecurity.model.Beneficiary;
import com.example.BankingWithSecurity.model.Transaction;


@Service
public class TransactionService {
	@Autowired
	TransactionDao transactionDao;
	@Autowired
	BeneficiaryDao beneficiaryDao;	
	@Autowired
	AccountDao accountDao;
	public String createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		Optional<Beneficiary> acc=Optional.of(beneficiaryDao.findByOwnerAccountNumber(transaction.getFromAccountNumber()));
		//Optional<Account> acc1=Optional.of(accountDao.findByAccountNumber(transaction.getToAccountNumber()));

		 if(acc.isPresent())
		 {
			 Beneficiary acc2=beneficiaryDao.findByOwnerAccountNumber(transaction.getFromAccountNumber());
			 System.out.println("yes");
			 System.out.println(acc2.getBeneficiaryAccountNumber());
			 System.out.println(transaction.getToAccountNumber());
				 Account acc3=accountDao.findByAccountNumber(transaction.getFromAccountNumber());
				 Account acc4=accountDao.findByAccountNumber(transaction.getToAccountNumber());
				 if(acc3.getAmount()>transaction.getAmount())
				 {
					 acc3.setAmount(acc3.getAmount()-transaction.getAmount());
					 accountDao.save(acc3);
					 acc4.setAmount(acc4.getAmount()+transaction.getAmount());
					 accountDao.save(acc4);
					 transactionDao.save(transaction);
					 return "Transaction details added successfully";
				 }
				 else
				 {
					 throw new InsufficientBalanceException("Insufficient Balance");
				 }
			 
			 
		 }
		 else
		 {
			 throw new AccountNotFoundException("Account Number not found in the Beneficiary");
		 }
		
	}
	public List<Transaction> getTransactions(Date fromDate,Date toDate) {
		System.out.println(fromDate+" "+toDate);
		// TODO Auto-generated method stub
		return transactionDao.getTransactions(fromDate,toDate) ;
	}

}
