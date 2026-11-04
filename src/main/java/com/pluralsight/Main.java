package com.pluralsight;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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
                //This is add deposits
                case "D" -> addDeposit();
                //This is make payments
                case "P" -> addPayment();

                case "L" -> ledgerPage();

                case "X" -> System.out.println("Exit Application Selected");

                default -> System.out.println("Invalid Input. Re-Enter Correct Variable");
            }
        }
    }


    //Ledger page choice
    public static void ledgerPage() {
        String ledgerPageChoice = "";
        while (!ledgerPageChoice.equalsIgnoreCase("H")) {
            System.out.println("---Ledger Page---");

            System.out.println("Enter A: Display all Entries");
            System.out.println("Enter D: Display Only Deposits into Account");
            System.out.println("Enter P: Display Payments/Negative Entries");
            System.out.println("Enter R: Display Pre-Define Reports/Custom Search");
            System.out.println("Enter H: Back to Home Menu");
            System.out.println("Enter Your Choice: ");
            ledgerPageChoice = read.nextLine();

            switch (ledgerPageChoice) {
                case "A" -> {
                    ArrayList<Transactions> all = readTransactions();
                    Collections.reverse(all);
                    for (Transactions t : all) {
                        System.out.println(t);
                    }
                }
                case "D" -> {
                    ArrayList<Transactions> all = readTransactions();
                    Collections.reverse(all);
                    for (Transactions t : all) {
                        if (t.getAmount() > 0) {
                            System.out.println(t);
                        }
                    }
                }
                case "P" -> {
                    ArrayList<Transactions> all = readTransactions();
                    Collections.reverse(all);
                    for (Transactions t : all) {
                        if (t.getAmount() < 0) {
                            System.out.println(t);
                        }
                    }
                }
                case "R" -> reportsPage();
                case "H" -> System.out.println("Back to Home Screen");

            }

        }
    }

    // Reading our CSV
    public static ArrayList<Transactions> readTransactions() {
        ArrayList<Transactions> readTransactions = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader reader = new BufferedReader(fileReader);

            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] partsOfFile = line.split("\\|");

                LocalDate date = LocalDate.parse(partsOfFile[0]);
                LocalTime time = LocalTime.parse(partsOfFile[1]);
                String description = partsOfFile[2];
                String vendor = partsOfFile[3];
                double amount = Double.parseDouble(partsOfFile[4]);

                readTransactions.add(new Transactions(date, time, description, vendor, amount));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error Reading Files");
        }
        return readTransactions;
    }

        // Line 36/38 Add Transactions for userHomeChoice
        public static void addDeposit(){
        //To Format Date,Time,Description,Vendor,Amount in homepage for deposits
        //Computer knows date so no input
        LocalDate date = LocalDate.now();
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Enter Description");
        String description = read.nextLine();

        System.out.println("Enter Vendor");
        String vendor = read.nextLine();

        //Format for $ Amount
        System.out.println("Enter Amount of Deposit: ");
        // pasrseDouble into the Variable amount
        double transactionAmount = Double.parseDouble(read.nextLine());

        transactionAmount = Math.abs(transactionAmount);

        //Line 38 Add Transaction for userHomeChoice
        //For Payments exactly same just adding negative
        }

public static void addPayment() {
    //To Format Date,Time,Description,Vendor,Amount in homepage for deposits
    //Computer knows date so no input
    LocalDate date = LocalDate.now();
    String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    System.out.println("Enter Description");
    String description = read.nextLine();

    System.out.println("Enter Vendor");
    String vendor = read.nextLine();

    //Format for $ Amount
    System.out.println("Enter Amount of Payment: ");
    // pasrseDouble into the Variable amount
    double transactionAmount = Double.parseDouble(read.nextLine());

    transactionAmount = -Math.abs(transactionAmount);
}
}
















