package com.ubs.opsit.interviews.luhn;


public interface CreditCardNumberValidator {
	
	public boolean validate(String number) throws CreditCardNumberValidationException;

}
