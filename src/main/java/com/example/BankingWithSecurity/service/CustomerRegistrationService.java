package com.example.BankingWithSecurity.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.BankingWithSecurity.dao.AccountDao;
import com.example.BankingWithSecurity.dao.CustomerDao;
import com.example.BankingWithSecurity.dto.AccountDto;
import com.example.BankingWithSecurity.exceptions.EmailException;
import com.example.BankingWithSecurity.exceptions.PassportException;
import com.example.BankingWithSecurity.model.Account;
import com.example.BankingWithSecurity.model.Customer;


@Service
public class CustomerRegistrationService {
	@Autowired
	CustomerDao customerDao;
	@Autowired
	AccountDao accountDao;
	

	public AccountDto addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("1");
		//Optional<Customer> email=Optional.of(customerDao.findByEmail(customer.getEmail()));
		Customer email=customerDao.findByEmail(customer.getEmail());
		if(!(email==null))
		{
			throw new EmailException("Email already exists.");
		}
		Customer passport=customerDao.findByPassport(customer.getPassport());
		System.out.println("3");
		//Optional<Customer> passport=Optional.of(customerDao.findByPassport(customer.getPassport()));
		System.out.println("2");
		if(passport!=null)
		{
			throw new PassportException("passport already exists.");
		}
		Customer c=customerDao.save(customer);
		String accNumber="";
		String sample=Long.toString(c.getCustomerId());
		int length=sample.length();
		for(int i=length;i<=6;i++)
		{
				sample='0'+sample;	
		}
		accNumber="UBN"+sample;
		Account a=new Account();
		a.setAccountNumber(accNumber);
		a.setAmount(10000);
		a.setCustomerId(c.getCustomerId());
		a.setName(c.getName());
		accountDao.save(a);
		AccountDto accDto=new AccountDto();
		accDto.setAccountNumber(accNumber);
		accDto.setAmount(10000);
		return accDto;
		
		
	}


	public Customer findOne(String email) {
		// TODO Auto-generated method stub
		return customerDao.findByEmail(email);
	}


	/*
	 * @Override public UserDetails loadUserByUsername(String email) throws
	 * UsernameNotFoundException { // TODO Auto-generated method stub Customer
	 * customer = customerDao.findByEmail(email); BCryptPasswordEncoder
	 * passwordEncoder = new BCryptPasswordEncoder(); if(customer == null) { throw
	 * new UsernameNotFoundException("Invalid email or passport."); } return new
	 * org.springframework.security.core.userdetails.User(customer.getEmail(),
	 * passwordEncoder .encode(customer.getPassport()), getAuthority()); }
	 * 
	 * private List<SimpleGrantedAuthority> getAuthority() { return
	 * Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")); }
	 */
	

}
