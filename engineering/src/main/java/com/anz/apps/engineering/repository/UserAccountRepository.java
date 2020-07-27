package com.anz.apps.engineering.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anz.apps.engineering.model.UserAccount;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Integer> {

	List<UserAccount> findByUserName(String userName);
	List<UserAccount> findAllByAccNumber(String accNumber);

}
