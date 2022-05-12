package gr.aueb.cf.oop.project2.model;

import java.io.PrintStream;

public class OveraftAccount {
    private Account account;
    private double balance;
    private String ssn;


    public OveraftAccount() {}

    public OveraftAccount(Account account) {
        this.account = account;
        this.balance = account.getBalance();
        this.ssn = account.getSsn();
    }


    private boolean isSsnValid (String ssn) {
        if (ssn == null) return false;
        if (this.ssn == null) return false;

        return this.ssn.equals(ssn);

    }


    public void withdrawOveraft(double amount) {
        if (!isSsnValid(ssn)) return;

        if (amount <= balance) {
            balance -= amount;
        } else {
            printCreditMessage(System.out, "Insufficient balance: Taking Credit");
            balance -= amount;
        }
    }

    private void printCreditMessage(PrintStream ps, String message) {
        if ((ps == null) || (message == null)) return;
        ps.println(message);
    }

}
