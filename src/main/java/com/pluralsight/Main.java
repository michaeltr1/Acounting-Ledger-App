package com.pluralsight;
import java.util.Scanner;


public class Main {
    public static Scanner read = new Scanner(System.in);
    public static void main(String[] args) {

        //Home Screen User Choice Screen
        String userChoiceHome = "";
        while (!userChoiceHome.equalsIgnoreCase("X")) {

            System.out.println("---Accounting Ledger Application---");

            System.out.println("Enter D: Add Deposit");

            System.out.println("Enter P: Make Payment (Debit)");

            System.out.println("Enter L: Display Ledger Screen");

            System.out.println("Enter X: Exit Application");

            System.out.print("Enter Option: ");
            userChoiceHome = read.nextLine();

            switch (userChoiceHome) {
                case "D" -> System.out.println("Deposit Selected");

                case "P" -> System.out.println(" Payment Menu Selected");

                case "L" -> System.out.println("Display Ledger Selected");

                case "X" -> System.out.println("Exit Application Selected");

                default -> System.out.println("Invalid Input. Re-Enter Correct Variable");
            }
        }
    }
    //Ledger page choice
    public static void ledgerPage() {
        String ledgerPageChoice = "";
        while(ledgerPage(){
            System.out.println("Ledger Page Chosen");

            System.out.println("Enter A: Display all Entries");
            System.out.println("Enter D: Display Only Deposits into Account");
            System.out.println("Enter P: Display Payments/Negative Entries");
            System.out.println("Enter R: Display Pre-Define Reports/Custom Search");
            System.out.println("Enter H: Back to Home Menu");
            System.out.println("Enter Your Choice: ");
            ledgerPageChoice = read.nextLine();

            switch(ledgerPageChoice) {
                case "A" -> System.out.println("Displaying all Entries");
                case "D" -> System.out.println("Displaying Deposits into Accounts");
                case "P" -> System.out.println("Displaying Payments/Negative Entries");
                case "R" -> System.out.println("Displaying Custom Search and Pre Defined Reports");
                case "H" -> System.out.println("Back to Home Screen");

            }

        }



            }


            }




