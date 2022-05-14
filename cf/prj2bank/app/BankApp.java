package cf.prj2bank.app;


import cf.prj2bank.model.Account;
import cf.prj2bank.model.JointAccount;
import cf.prj2bank.model.OverfraftAccount;

import java.io.FileNotFoundException;
import java.lang.reflect.AccessibleObject;


public class BankApp {
    public static void main(String[] args) throws FileNotFoundException {
        Account donald = new Account(1, "GR76 800 800 1000", "Duck", "Donald", "1000", 10);
        Account scrooge = new Account(2, "UK10 550 550 2000", "McDuck", "Scrooge", "2000", 5000);


        //Donald tries to deposit 2 euros to his account
        donald.deposit(1);
        donald.printAccountState();

        //Scrooge tries to deposit 10.000 euros to his account
        scrooge.deposit(10000);
        scrooge.printAccountState();

        OverfraftAccount donaldCredit = new OverfraftAccount(donald);
        donaldCredit.withdrawOverfraft(100);
        donald.printAccountState();

        JointAccount bothDucks = new JointAccount(3, "GR76 400 400 3000", "McDuck", "Scrooge", "Duck", "Donald", "2000",
                "1000", 0);
        bothDucks.deposit(500);
        bothDucks.printAccountState();

        bothDucks.withdraw(200);
        bothDucks.printAccountState();




    }
}
