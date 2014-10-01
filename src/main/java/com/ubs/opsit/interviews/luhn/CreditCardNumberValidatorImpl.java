package com.ubs.opsit.interviews.luhn;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardNumberValidatorImpl implements CreditCardNumberValidator {

	public boolean validate(String number) throws CreditCardNumberValidationException {


        int a = 0; // odd position of digits
        int b = 0; // even position of digits
        int x = 0; // check digit
        String invertedCardNumber = new StringBuffer(number).reverse().toString(); // holds the reversed credit card number to be checked


        if(number == null || number.isEmpty())
            return false;

        // Regex - Looks for match not within brackets. So if a credit card number without any special characters is found,
        // the regex finds a match other than a card number that is digits only. ie...4012888888881881 and returns false.
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(number);
        boolean containsSpecialCharacter = m.find();


        if(!containsSpecialCharacter){
            for(int i = 0; i < invertedCardNumber.length(); i++){
                int digit = Character.digit(invertedCardNumber.charAt(i), 10);
                // this takes the odd position numbers of the card number and sums them since the numbers remain the
                // same and not multiplied by 2.
                if(i % 2 == 0){
                    a += digit;
                }
                // if numbers are not odd..drops in here and sums the even positioned numbers that have been doubled or multiplied by 2.
                else{
                    b += digit * 2;
                    if(digit >= 5){
                        b -= 9;
                    }
                }
            }
            if((a + b) % 10 != 0){
               //throw new CreditCardNumberValidationException("Invalid credit card number");
                return false;
            }
            return true;
        }else if(containsSpecialCharacter)
            //throw new CreditCardNumberValidationException("Invalid credit card format");
            return false;


        return false;

	}

}
