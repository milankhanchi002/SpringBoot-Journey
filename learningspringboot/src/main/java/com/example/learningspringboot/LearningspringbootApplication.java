package com.example.learningspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningspringbootApplication implements CommandLineRunner { //CommandLineRunner wait krta h niche val spring ka pura code chlne ka

	public static void main(String[] args) {

		SpringApplication.run(LearningspringbootApplication.class, args);

	}


//	private Razorpay payment;
//	public LearningspringbootApplication(Razorpay payment) {  //constructor dependency injection loosly coupled hoti h aur jo obj new razorpay() krke bnti h vo tightly coupled hoti h
//		this.payment=payment;
//	}
	@Autowired
	private Paymentvia payment; // ye bhi bean mtlb obj bna deta h apne aap na isme new Razorpay() krne ki jarurat || na isme constructor se dependency inject krne ki jaryrat

	@Override
	public void run(String... args) throws Exception {
	String paymentservice=payment.pay();

	}
}
