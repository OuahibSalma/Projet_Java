/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.salma.OuahibSalmaProject;
import Bank.Account;
import Bank.AuthFrame;
import Bank.Bank ; 
import java.io.FileNotFoundException;
import java.util.List;


/**
 *
 * @author Original Shop
 */
public class OuahibSalmaProject {
    public static void main(String[] args) throws FileNotFoundException {
       Bank bank = Bank.getInstance();
        bank.setName("SimBank");
        bank.makeSimulation();
        System.out.println(bank);
        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AuthFrame(bank).setVisible(true);
//            }
//        });
        bank.save(Bank.FILENAME);
        System.out.println("We saved data successfully!");
        System.out.println("\nNow,we're gonna load.\n");
        List<Account> accountsLoaded = bank.load(Bank.FILENAME);
        accountsLoaded.forEach(
            (c) -> System.out.println(c. bankStatement())
        );
        System.out.println("Data loaded succesfully!\n");

    }
}
