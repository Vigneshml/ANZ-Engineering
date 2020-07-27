package com.anz.apps.engineering.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.apps.engineering.model.AccountTransaction;
import com.anz.apps.engineering.repository.AccountTransactionRepository;

@Service
public class AccountTransactionService {
	
	 @Autowired
	 AccountTransactionRepository accountTransactionRepository;
	 
	public List<AccountTransaction> getAllTransactions() {
		final List<AccountTransaction> allTransaction = new ArrayList<>();
		accountTransactionRepository.findAll().forEach(transaction -> allTransaction.add(transaction));
		return allTransaction;
	}
	
	public List<AccountTransaction> getTransactionsByAccNumber(String AccNumber) {
		final List<AccountTransaction> transactionsByAccNumber = new ArrayList<>();
		accountTransactionRepository.findAllByAccNumber(AccNumber).forEach(transaction -> transactionsByAccNumber.add(transaction));
		return transactionsByAccNumber;
	}

}
