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

    public static void ledgerPage() {
        String ledgerPage;



            }


            }



        }
    }
