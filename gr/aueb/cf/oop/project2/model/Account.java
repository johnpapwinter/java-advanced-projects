package gr.aueb.cf.oop.project2.model;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Ορίζει μια κλάση Account με Business Logic
 */
public class Account {

    private long id;
    private String iban;
    private String lastname;
    private String ssn;
    private double balance;

    public Account() {}

    public Account(long id, String iban, String lastname, String ssn, double balance) {
        this.id = id;
        this.iban = iban;
        this.lastname = lastname;
        this.ssn = ssn;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Business Logic

    /**
     * Deposits an amount to this account
     * @param amount the amount of money to be deposited
     */
    public boolean deposit(double amount) throws FileNotFoundException {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            printErrorMessage(System.out, "Error: Insufficient amount");
            printErrorMessage(new PrintStream(new FileOutputStream("log.txt", true)), "Insufficient amount");
            return false;
        }
    }


    /**
     * Withdraws a certain amount of money from the account
     * @param amount the amount of money to be withdrawn
     */
    public void withdraw(double amount) throws FileNotFoundException {
        if (!isSsnValid(ssn)) return;

        if (amount <= balance) {
            balance -= amount;
        } else {
            printErrorMessage(System.out, "Error: Insufficient balance");
            printErrorMessage(new PrintStream(new FileOutputStream("log.txt", true)), "Insufficient Balance");
        }
    }


    private boolean isSsnValid (String ssn) {
        if (ssn == null) return false;
        if (this.ssn == null) return false;

        return this.ssn.equals(ssn);

    }

    private void printErrorMessage(PrintStream ps, String message) {
        if ((ps == null) || (message == null)) return;
        ps.println(message);
    }


    /**
     * gets the balance's amount of money
     * @return balance of an account
     */
    public double getAccountBalance() {
        return getBalance();
    }

    /**
     * gets the state of the account instance
     * @return the account state transformed to String
     */
    public String getAccountState() {
        return "id: " + id + "\t" + "iban: " + iban + "\t" + "Lastname: " + lastname
                + "\t" + "ssn: " + ssn + "\t" + "balance: " + balance;
    }


    /**
     * prints the account state
     */
    public void printAccountState() {
        System.out.println("id: " + id + "\t" + "iban: " + iban + "\t" + "Lastname: " + lastname
                + "\t" + "ssn: " + ssn + "\t" + "balance: " + balance);
    }

}
