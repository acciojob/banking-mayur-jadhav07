package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance < 5000) throw new Exception("Insufficient Balance");
        this.tradeLicenseId = tradeLicenseId;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        // Check if no two consecutive characters are the same
        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                throw new Exception("Valid License can not be");
            }
        }

        // Check if the characters can be rearranged to create any valid license Id
        char[] licenseIdArray = tradeLicenseId.toCharArray();
        Arrays.sort(licenseIdArray);
        for (int i = 0; i < licenseIdArray.length - 1; i++) {
            if (licenseIdArray[i] == licenseIdArray[i + 1]) {
                throw new Exception("Valid License can not be generated");
            }
        }
    }

}
