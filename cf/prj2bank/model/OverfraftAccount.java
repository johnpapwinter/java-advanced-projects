package cf.prj2bank.model;

import java.io.PrintStream;

public class OverfraftAccount {
    private Account account;
    private double balance;
    private String ssn;


    public OverfraftAccount() {}

    public OverfraftAccount(Account account) {
        this.account = account;
        this.balance = account.getBalance();
        this.ssn = account.getSsn();
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setBalance(double balance) {
        this.balance = account.getBalance();
    }

    public Account getAccount() {
        return account;
    }

    public double getBalance() {
        return balance;
    }


    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = account.getSsn();
    }


    private boolean isSsnValid (String ssn) {
        if (ssn == null) return false;
        if (this.ssn == null) return false;

        return this.ssn.equals(ssn);

    }


    /**
     * takes the balance of a class Account instance and withdraws a specified amount
     * if the amount if greater than the previous balance, the account holder is charged with credit
     * it then sends the new balance back to the instance
     * @param amount
     */
    public void withdrawOverfraft(double amount) {
        if (!isSsnValid(ssn)) return;

        if (amount <= balance) {
            balance -= amount;
            account.setBalance(balance);
        } else {
            printCreditMessage(System.out, "Insufficient balance: Taking Credit");
            balance -= amount;
            account.setBalance(balance);
            printAmountOfCredit(balance);
        }
    }

    private void printCreditMessage(PrintStream ps, String message) {
        if ((ps == null) || (message == null)) return;
        ps.println(message);
    }

    private void printAmountOfCredit(double balance) {
        System.out.printf("The account was charged %.2f euros", balance);
        System.out.println();
    }

}
