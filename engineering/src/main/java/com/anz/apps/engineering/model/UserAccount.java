package com.anz.apps.engineering.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * in-memory data base used for this application. make a change in the application.properties when the table and relationship is finalized.
 * @author Vignesh
 *
 */
@Entity
public class UserAccount {

	@Id
	@GeneratedValue
	private int id;

	private String userName;

	private String accNumber;
	private String accName;
	private String accType;
	@Temporal(TemporalType.DATE)
	private Date balDate;
	private String currency;
	private double balance;

	// Default constructor.
	public UserAccount() {
	}

	public UserAccount(int id, String userName, String accNumber, String accName, String accType, Date balDate,
			String currency, double balance) {
		this.id = id;
		this.userName = userName;
		this.accNumber = accNumber;
		this.accName = accName;
		this.accType = accType;
		this.balDate = balDate;
		this.currency = currency;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public Date getBalDate() {
		return balDate;
	}

	public void setBalDate(Date balDate) {
		this.balDate = balDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
