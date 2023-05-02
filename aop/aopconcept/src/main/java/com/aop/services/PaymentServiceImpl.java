package com.aop.services;

public class PaymentServiceImpl implements PaymentService {

	public void makePayment() {
		
		//Payment code
		
		System.out.println("Amount Debited...");
		
		//
		//
		//
		
		System.out.println("Amount Credited...");

	}
	
	public void sendPayment(int amount) {
		
		//Payment code
		
		System.out.println(amount+" Amount Debited...");
		
		//
		//
		//
		
		System.out.println(amount+" Amount Credited...");

	}

}
