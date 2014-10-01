package com.ubs.opsit.interviews.luhn;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ValidatorTests {


    CreditCardNumberValidator valTestObj;

    // VISA IIN - 4
    String validVisaCreditCardNumber;
    String inValidVisaCreditCardNumber;
    String visaCCNumberValidFormat;
    String visaCCNumberWithHyphen;
    String visaCCNumberWithPeriod;
    String visaCCNumberWithSpaces;
    String  visaCCNumberWithAlphaChars;

    // Master Card IIN - 51
    String validMCCreditCardNumber51;
    String inValidMCCreditCardNumber51;
    String mcCCNumberValidFormat51;
    String mcCCNumberWithHyphen51;
    String mcCCNumberWithPeriod51;
    String mcCCNumberWithSpaces51;
    String mcCCNumberWithAlphaChars51;
    // Master Card IIN - 55
    String validMCCreditCardNumber55;
    String inValidMCCreditCardNumber55;
    String mcCCNumberValidFormat55;
    String mcCCNumberWithHyphen55;
    String mcCCNumberWithPeriod55;
    String mcCCNumberWithSpaces55;
    String mcCCNumberWithAlphaChars55;

    // American Express IIN - 37
    String validAECreditCardNumber37;
    String inValidAECreditCardNumber37;
    String aeCCNumberValidFormat37;
    String aeCCNumberWithHyphen37;
    String aeCCNumberWithPeriod37;
    String aeCCNumberWithSpaces37;
    String aeCCNumberWithAlphaChars37;

    @Before
    public void setUp(){
        valTestObj = new CreditCardNumberValidatorImpl();
        // VISA IIN - 4
        validVisaCreditCardNumber = "4012888888881881";
        inValidVisaCreditCardNumber = "4012888888881882";
        visaCCNumberValidFormat = "4012888888881881";
        visaCCNumberWithHyphen = "4012-8888-8888-1881";
        visaCCNumberWithPeriod = "4012.8888.8888.1881";
        visaCCNumberWithSpaces = "4012 8888 8888 1881";
        visaCCNumberWithAlphaChars = "401a8888b8881d81";
        // Master Card IIN - 51
        validMCCreditCardNumber51 = "5105105105105100";
        inValidMCCreditCardNumber51 = "5105105105105102";
        mcCCNumberValidFormat51 = "5105105105105100";
        mcCCNumberWithHyphen51 = "5105-1051-0510-5100";
        mcCCNumberWithPeriod51 = "5105.1051.0510.5100";
        mcCCNumberWithSpaces51 = "5105 1051 0510 5100";
        mcCCNumberWithAlphaChars51 = "a10105b051c510d";
        // Master Card IIN - 55
        validMCCreditCardNumber55 = "5555555555554444";
        inValidMCCreditCardNumber55 = "5555555555554446";
        mcCCNumberValidFormat55 = "5555555555554444";
        mcCCNumberWithHyphen55 = "5555-5555-5555-4444";
        mcCCNumberWithPeriod55 = "5555.5555.5555.4444";
        mcCCNumberWithSpaces55 = "5555 5555 5555 4444";
        mcCCNumberWithAlphaChars55 = "555a555b555c444d";
        // American Express IIN - 37
        validAECreditCardNumber37 = "371449635398431";
        inValidAECreditCardNumber37 = "371449635398432";
        aeCCNumberValidFormat37 = "378282246310005";
        aeCCNumberWithHyphen37 = "3782-822463-10005";
        aeCCNumberWithPeriod37 = "3782.822463.10005";
        aeCCNumberWithSpaces37 = "3782 822463 10005";
        aeCCNumberWithAlphaChars37 = "378x82h46d10005";
    }


    /*
        Test for object instantiation of target class.
    */
    @Test
    public void testCreditCardValidatorObj(){
        Assert.assertNotNull(valTestObj);
    }

    /*
        Test for existence of data being passed to validate method.
    */
    @Test
    public void testCreditCardNumberInputParam() throws CreditCardNumberValidationException {
        Assert.assertFalse(valTestObj.validate("0123456789"));
    }

    /*
        Test for special characters being passed to the validate method, such as -'s , .'s , ' '(spaces) , and characters.
        Using the Visa Credit Card format for this test with the following qualifiers
        1. IIN - 4
        2. Length - 16
    */
    @Test
    public void testVisaCreditCardNumberValidFormat() throws CreditCardNumberValidationException {
        Assert.assertTrue(valTestObj.validate(visaCCNumberValidFormat));
        Assert.assertFalse(valTestObj.validate(visaCCNumberWithHyphen));
        Assert.assertFalse(valTestObj.validate(visaCCNumberWithPeriod));
        Assert.assertFalse(valTestObj.validate(visaCCNumberWithSpaces));
        Assert.assertFalse(valTestObj.validate(visaCCNumberWithAlphaChars));
    }

    /*
        Test for special characters being passed to the validate method, such as -'s , .'s , ' '(spaces) , and characters.
        Using the Master Card format for this test with the following qualifiers
        1. IIN - 51 & 55 (only). No other IIN's tested.
        2. Length - 16
    */
    @Test
    public void testMCCreditCardNumberValidFormat() throws CreditCardNumberValidationException {
        // IIN - 51
        Assert.assertTrue(valTestObj.validate(mcCCNumberValidFormat51));
        Assert.assertFalse(valTestObj.validate(mcCCNumberWithHyphen51));
        Assert.assertFalse(valTestObj.validate(mcCCNumberWithPeriod51));
        Assert.assertFalse(valTestObj.validate(mcCCNumberWithSpaces51));
        Assert.assertFalse(valTestObj.validate(mcCCNumberWithAlphaChars51));
        // IIN - 55
        Assert.assertTrue(valTestObj.validate(mcCCNumberValidFormat55));
        Assert.assertFalse(valTestObj.validate(mcCCNumberWithHyphen55));
        Assert.assertFalse(valTestObj.validate(mcCCNumberWithPeriod55));
        Assert.assertFalse(valTestObj.validate(mcCCNumberWithSpaces55));
        Assert.assertFalse(valTestObj.validate(mcCCNumberWithAlphaChars55));
    }

    /*
        Test for special characters being passed to the validate method, such as -'s , .'s , ' '(spaces) , and characters.
        Using the American Express format for this test with the following qualifiers
        1. IIN - 37.
        2. Length - 15
    */
    @Test
    public void testAECreditCardNumberValidFormat() throws CreditCardNumberValidationException {
        // IIN - 37
        Assert.assertTrue(valTestObj.validate(aeCCNumberValidFormat37));
        Assert.assertFalse(valTestObj.validate(aeCCNumberWithHyphen37));
        Assert.assertFalse(valTestObj.validate(aeCCNumberWithPeriod37));
        Assert.assertFalse(valTestObj.validate(aeCCNumberWithSpaces37));
        Assert.assertFalse(valTestObj.validate(aeCCNumberWithAlphaChars37));
    }

    /*
        Test the following cards with a valid credit card number and a valid format.
        1. Visa
        2. MasterCard
        3. American Express
    */
    @Test
    public void testValidCreditCardNumber() throws CreditCardNumberValidationException {
        // VISA IIN - 4
        Assert.assertTrue(valTestObj.validate(validVisaCreditCardNumber));
        // Master Card IIN - 51
        Assert.assertTrue(valTestObj.validate(validMCCreditCardNumber51));
        // Master Card IIN - 55
        Assert.assertTrue(valTestObj.validate(validMCCreditCardNumber55));
        // American Express IIN - 37
        Assert.assertTrue(valTestObj.validate(validAECreditCardNumber37));

    }

    /*
        Test the following cards with an in-valid credit card number but with a valid format.
        1. Visa
        2. MasterCard
        3. American Express
    */
    @Test
    public void testInvalidCreditCardNumber() throws CreditCardNumberValidationException {
        // VISA IIN - 4
        Assert.assertFalse(valTestObj.validate(inValidVisaCreditCardNumber));
        // Master Card IIN - 51
        Assert.assertFalse(valTestObj.validate(inValidMCCreditCardNumber51));
        // Master Card IIN - 55
        Assert.assertFalse(valTestObj.validate(inValidMCCreditCardNumber55));
        // American Express IIN - 37
        Assert.assertFalse(valTestObj.validate(inValidAECreditCardNumber37));

    }

    @Ignore
    @Test(expected = CreditCardNumberValidationException.class)
    public void testInvalidCreditCardNumberException() {
        // VISA IIN - 4
        try {
            valTestObj.validate(inValidVisaCreditCardNumber);
        } catch (CreditCardNumberValidationException e) {
            e.printStackTrace();
        }
    }




}
