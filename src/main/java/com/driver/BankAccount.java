package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
//        if (digits <= 0 || sum < 0 || sum > digits * 9) {
//            throw new Exception("Invalid input parameters");
//        }
//
//        StringBuilder accountNumberBuilder = new StringBuilder();
//
//        // Generate account number directly
//        for (int i = 0; i < digits - 1; i++) {
//            int maxPossibleDigit = Math.min(9, sum - (digits - 1 - i));
//            int generatedDigit = Math.max(0, maxPossibleDigit);
//            accountNumberBuilder.append(generatedDigit);
//            sum -= generatedDigit;
//        }
//
//        if (sum < 0) {
//            throw new Exception("Account Number can not be generated");
//        }
//
//        accountNumberBuilder.append(sum); // Last digit is whatever is left to reach the target sum
//
//        return accountNumberBuilder.toString();
        String ans = "";
        while(digits>0){
            if(sum >= 9){
                sum = sum - 9;
                digits--;
                ans += String.valueOf(9);
            }
            else{
                int x = sum;
                sum = sum-x;
                digits--;
                ans+= String.valueOf(x);
            }
        }

        if(sum != 0){
            throw new Exception("Account Number can not be generated");
        }

        return ans;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if((balance - amount) < minBalance){
            throw new Exception("Insufficient Balance");
        }
        this.balance -= amount;
    }

}