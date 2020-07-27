package com.anz.apps.engineering.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anz.apps.engineering.model.AccountTransaction;

public interface AccountTransactionRepository extends CrudRepository<AccountTransaction, Integer>{

	
	List<AccountTransaction> findAllByAccNumber(String accNumber);
	
}
