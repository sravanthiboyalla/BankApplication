package com.example.BankingWithSecurity.dao;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.BankingWithSecurity.model.Transaction;


public interface TransactionDao extends JpaRepository<Transaction,Long>{

	@Query(nativeQuery=true,value="select * from transaction where date between :fromDate and :toDate")
	public List<Transaction> getTransactions(Date fromDate, Date toDate);

}
