package com.anz.apps.engineering.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anz.apps.engineering.model.UserAccount;
import com.anz.apps.engineering.service.UserAccountService;

@RestController
public class AccountController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	UserAccountService userAccountService;
	
	/**
	 * Service to get all the account details of all the users
	 * @return
	 */
	@GetMapping(value= "/accounts/all", produces= "application/vnd.jcg.api.v1+json")
    public List<UserAccount> getAll() {
        log.info("Getting all the account details of all the different users");
        return userAccountService.getAllUserAndTheirAccDetails();
    }
	
	
	/**
	 * Service to get the account details of the user name passed in the url
	 * @param userName
	 * @return
	 */
	@GetMapping(value= "/accounts/userName/{userName}", produces= "application/vnd.jcg.api.v1+json")
    public List<UserAccount> getAccDetailsByUserName(@PathVariable("userName") String userName) {
        log.info("Getting all the account details for the given user name : " + userName);
        return userAccountService.getAccDetailsByUserName(userName);
    }
	
	/**
	 * Service to get the account details of the acc num passed in the url
	 * @param accNumber
	 * @return
	 */
	@GetMapping(value= "/accounts/accNumber/{accNumber}", produces= "application/vnd.jcg.api.v1+json")
    public List<UserAccount> getAccDetailsByAccNumber(@PathVariable("accNumber") String accNumber) {
        log.info("Getting all the account details for the given acc number : " + accNumber);
        return userAccountService.getAccDetailsByAccNumber(accNumber);
    }
	
}
