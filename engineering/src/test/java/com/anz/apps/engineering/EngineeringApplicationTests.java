package com.anz.apps.engineering;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.anz.apps.engineering.model.AccountTransaction;
import com.anz.apps.engineering.model.UserAccount;
import com.anz.apps.engineering.repository.AccountTransactionRepository;
import com.anz.apps.engineering.repository.UserAccountRepository;
import com.anz.apps.engineering.service.AccountTransactionService;
import com.anz.apps.engineering.service.UserAccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EngineeringApplicationTests {

	@Autowired
	UserAccountService userAccountService;

	@MockBean
	UserAccountRepository userAccountRepository;

	@Autowired
	AccountTransactionService accountTransactionService;

	@MockBean
	AccountTransactionRepository accountTransactionRepository;

	@Test
	public void test_getAllUserAndTheirAccDetails_greenPath_singleRecordScenario() {
		when(userAccountRepository.findAll())
				.thenReturn(Stream.of(new UserAccount(12, "Vignesh", "ACCNUM123", "SA", "Savings", null, "USD", 84755))
						.collect(Collectors.toList()));
		List<UserAccount> userAccountDetails = userAccountService.getAllUserAndTheirAccDetails();
		assertEquals(1, userAccountDetails.size());
		assertEquals("Vignesh", userAccountDetails.get(0).getUserName());
		assertEquals("SA", userAccountDetails.get(0).getAccName());
	}

	@Test
	public void test_getAllUserAndTheirAccDetails_greenPath_multiRecordScenario() {
		when(userAccountRepository.findAll()).thenReturn(Stream
				.of(new UserAccount(12, "Vignesh", "ACCNUM123", "SA", "Savings", new Date(2020, 05, 06), "USD", 90000),
						new UserAccount(13, "Victor", "ACCNUM123", "Current Account", "Savings", new Date(2020, 05, 06),
								"USD", 80000))
				.collect(Collectors.toList()));
		List<UserAccount> userAccountDetails = userAccountService.getAllUserAndTheirAccDetails();
		assertEquals(2, userAccountDetails.size());
		assertEquals("Vignesh", userAccountDetails.get(0).getUserName());
		assertEquals("SA", userAccountDetails.get(0).getAccName());
		assertEquals(90000, userAccountDetails.get(0).getBalance(), 0);
		assertEquals("Victor", userAccountDetails.get(1).getUserName());
		assertEquals("Current Account", userAccountDetails.get(1).getAccName());
		assertEquals(80000, userAccountDetails.get(1).getBalance(), 0);
	}

	@Test
	public void test_getAccDetailsByUserName_greenPath_singleRecordsScenario() {
		when(userAccountRepository.findByUserName("Vignesh"))
				.thenReturn(Stream.of(new UserAccount(12, "Vignesh", "ACCNUM123", "SA", "Savings", null, "USD", 84755))
						.collect(Collectors.toList()));
		List<UserAccount> userAccountDetailsByUserName = userAccountService.getAccDetailsByUserName("Vignesh");
		assertEquals(1, userAccountDetailsByUserName.size());
		assertEquals("Vignesh", userAccountDetailsByUserName.get(0).getUserName());
		assertEquals("SA", userAccountDetailsByUserName.get(0).getAccName());
	}

	@Test
	public void test_getAccDetailsByUserName_greenPath_multipleRecordsScenario() {
		when(userAccountRepository.findByUserName("Vignesh")).thenReturn(Stream
				.of(new UserAccount(12, "Vignesh", "ACCNUM123", "SA", "Savings", new Date(2020, 05, 06), "USD", 90000),
						new UserAccount(13, "Victor", "ACCNUM123", "Current Account", "Savings", new Date(2020, 05, 06),
								"USD", 80000))
				.collect(Collectors.toList()));
		List<UserAccount> userAccountDetailsByUserName = userAccountService.getAccDetailsByUserName("Vignesh");
		assertEquals(2, userAccountDetailsByUserName.size());
		assertEquals("Vignesh", userAccountDetailsByUserName.get(0).getUserName());
		assertEquals("SA", userAccountDetailsByUserName.get(0).getAccName());
		assertEquals(90000, userAccountDetailsByUserName.get(0).getBalance(), 0);
		assertEquals("Victor", userAccountDetailsByUserName.get(1).getUserName());
		assertEquals("Current Account", userAccountDetailsByUserName.get(1).getAccName());
		assertEquals(80000, userAccountDetailsByUserName.get(1).getBalance(), 0);
	}

	@Test
	public void test_getAllTransactions_greenPath_singleRecord() {
		when(accountTransactionRepository.findAll()).thenReturn(Stream.of(
				new AccountTransaction(111, "ACC1234", "SA123", new Date(2020, 05, 06), "INR", 80000.00, "Savings", ""))
				.collect(Collectors.toList()));
		List<AccountTransaction> allTransactions = accountTransactionService.getAllTransactions();
		assertEquals(1, allTransactions.size());
		assertEquals("SA123", allTransactions.get(0).getAccName());
		assertEquals("ACC1234", allTransactions.get(0).getAccNumber());
		assertEquals("INR", allTransactions.get(0).getCurrency());
		assertEquals("Savings", allTransactions.get(0).getTransactionType());

	}

}
