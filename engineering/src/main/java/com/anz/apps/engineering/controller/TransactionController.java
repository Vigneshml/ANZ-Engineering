package com.anz.apps.engineering.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anz.apps.engineering.model.AccountTransaction;
import com.anz.apps.engineering.service.AccountTransactionService;

@RestController("/transaction")
public class TransactionController {
	
private final Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	AccountTransactionService accountTransactionService;
	
	/**
	 * Service to get all the transactions irrespective of the account number
	 * @return
	 */
	@GetMapping(value= "/all", produces= "application/vnd.jcg.api.v1+json")
    public List<AccountTransaction> getAll() {
        log.info("Getting all the transaction");
        return accountTransactionService.getAllTransactions();
    }
	
	/**
	 * service to get the transactions for the given acc number passed in the url
	 * @param accNumber
	 * @return
	 */
	@GetMapping(value= "/accNumber/{accNumber}", produces= "application/vnd.jcg.api.v1+json")
    public List<AccountTransaction> getTransactionByAccNumber(@PathVariable("accNumber")  String accNumber) {
        log.info("Getting all the transaction fro the given acc number - "+ accNumber);
        return accountTransactionService.getTransactionsByAccNumber(accNumber);
    }

}
