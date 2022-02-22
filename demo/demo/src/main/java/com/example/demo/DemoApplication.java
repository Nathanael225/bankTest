package com.example.demo;

import com.example.demo.container.MyAccount;
import com.example.demo.container.MyState;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

import static com.example.demo.container.Amount.amountOf;
import static com.example.demo.utils.CustomDate.date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(DemoApplication.class, args);

		MyAccount myAccount = new MyAccount(new MyState());
		// L'utilisateur crédite son compte
		myAccount.depositMoney(amountOf(1000), date("10/01/2022"));
		myAccount.depositMoney(amountOf(2000), date("12/01/2022"));

		// L'utilisateur débite son compte
		myAccount.withDrawalMoney(amountOf(1000), date("14/01/2012"));
		myAccount.withDrawalMoney(amountOf(3000), date("16/01/2012"));

		// Affichage de l'historique des transactions.
		myAccount.printHistory(System.out);
	}

}
