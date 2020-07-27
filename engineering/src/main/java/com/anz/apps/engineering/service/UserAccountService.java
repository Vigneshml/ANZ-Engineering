package com.anz.apps.engineering.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.apps.engineering.model.UserAccount;
import com.anz.apps.engineering.repository.UserAccountRepository;

@Service
public class UserAccountService {
	 @Autowired
	 UserAccountRepository userAccountRepository;
	 
	public List<UserAccount> getAllUserAndTheirAccDetails() {
		final List<UserAccount> userAndThierAccDetails = new ArrayList<>();
		userAccountRepository.findAll().forEach(accDetails -> userAndThierAccDetails.add(accDetails));
		return userAndThierAccDetails;
	}
	
	public List<UserAccount> getAccDetailsByUserName(String userName) {
		final List<UserAccount> userAndThierAccDetails = new ArrayList<>();
		userAccountRepository.findByUserName(userName).forEach(accDetails -> userAndThierAccDetails.add(accDetails));
		return userAndThierAccDetails;
	}
	
	public List<UserAccount> getAccDetailsByAccNumber(String accNumber) {
		final List<UserAccount> userAndThierAccDetails = new ArrayList<>();
		userAccountRepository.findAllByAccNumber(accNumber).forEach(accDetails -> userAndThierAccDetails.add(accDetails));
		return userAndThierAccDetails;
	}

}
