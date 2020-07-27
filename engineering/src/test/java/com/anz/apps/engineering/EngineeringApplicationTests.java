package com.anz.apps.engineering;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.anz.apps.engineering.model.UserAccount;
import com.anz.apps.engineering.repository.UserAccountRepository;
import com.anz.apps.engineering.service.UserAccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EngineeringApplicationTests {

	@Autowired
	UserAccountService userAccountService;

	@MockBean
	UserAccountRepository userAccountRepository;

	@Test
	public void test_getAllUserAndTheirAccDetails_greenPath() {

		when(userAccountRepository.findAll()).thenReturn(Stream
				.of(new UserAccount(111, "ACCNUM123", "Vignesh", "SA", "Savings", new Date("2020-02-05"), "USD", 84755))
				.collect(Collectors.toList()));
		assertEquals(1, userAccountService.getAllUserAndTheirAccDetails().size());
	}

}
