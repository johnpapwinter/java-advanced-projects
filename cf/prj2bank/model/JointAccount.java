package cf.prj2bank.model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class JointAccount {
    private long id;
    private String iban;
    private String lastname1;
    private String firstname1;
    private String lastname2;
    private String firstname2;
    private String ssn1;
    private String ssn2;
    private double balance;

    public JointAccount() {}

    public JointAccount(long id, String iban, String lastname1, String firstname1,
                        String lastname2, String firstname2, String ssn1, String ssn2, double balance) {
        this.id = id;
        this.iban = iban;
        this.lastname1 = lastname1;
        this.firstname1 = firstname1;
        this.lastname2 = lastname2;
        this.firstname2 = firstname2;
        this.ssn1 = ssn1;
        this.ssn2 = ssn2;
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

    public String getLastname1() {
        return lastname1;
    }

    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    public String getFirstname1() {
        return firstname1;
    }

    public void setFirstname1(String firstname1) {
        this.firstname1 = firstname1;
    }

    public String getLastname2() {
        return lastname2;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public String getFirstname2() {
        return firstname2;
    }

    public void setFirstname2(String firstname2) {
        this.firstname2 = firstname2;
    }

    public String getSsn1() {
        return ssn1;
    }

    public void setSsn1(String ssn1) {
        this.ssn1 = ssn1;
    }

    public String getSsn2() {
        return ssn2;
    }

    public void setSsn2(String ssn2) {
        this.ssn2 = ssn2;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


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
        if (!isSsnValid(ssn1, ssn2)) return;

        if (amount <= balance) {
            balance -= amount;
        } else {
            printErrorMessage(System.out, "Error: Insufficient balance");
            printErrorMessage(new PrintStream(new FileOutputStream("log.txt", true)), "Insufficient Balance");
        }
    }


    private boolean isSsnValid (String ssn1, String ssn2) {
        if ((ssn1 == null) || (ssn2 == null)) return false;
        if ((this.ssn1 == null) || (this.ssn2 == null)) return false;

        return (this.ssn1.equals(ssn1)) || (this.ssn2.equals(ssn2));

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
        return "id: " + id + "\t" + "iban: " + iban + "\t" + "Lastname 1: " + lastname1
                + "\t" + "Firstname 1: " + firstname1 + "\t" + "Lastname 2: " + lastname2 + "\t" +
                "Firstname 2: " + firstname2 + "\t" + "ssn1: " + ssn1 + "\t" + "ssn2: " + ssn2 + "\t" +
                "balance: " + balance;
    }


    /**
     * prints the account state
     */
    public void printAccountState() {
        System.out.println("id: " + id + "\t" + "iban: " + iban + "\t" + "Lastname 1: " + lastname1
                + "\t" + "Firstname 1: " + firstname1 + "\t" + "Lastname 2: " + lastname2 + "\t" +
                "Firstname 2: " + firstname2 + "\t" + "ssn1: " + ssn1 + "\t" + "ssn2: " + ssn2 + "\t" +
                "balance: " + balance);
    }



}