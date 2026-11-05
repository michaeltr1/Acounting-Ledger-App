package com.pluralsight;
import static com.pluralsight.Main.read;
import static com.pluralsight.Main.transactions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

//Creating Reports Page for Specific Searches
public class ReportsPage {
    public static void reportsPage() {
        String reportSearchChoice = "";

        while (!reportSearchChoice.equals("X")) {
            System.out.println("---Reports Page---");
            System.out.println("Enter 1: Month");
            System.out.println("Enter 2: Previous Month");
            System.out.println("Enter 3: Year to Date");
            System.out.println("Enter 4: Previous Year");
            System.out.println("Enter 5: Search Vendors");
            System.out.println("Enter X: Leave Reports Page");
            System.out.println("Enter Input: ");
            reportSearchChoice = read.nextLine();

            switch (reportSearchChoice) {
                case "1" -> monthtoDate();
                case "2" -> previousMonth();
                case "3" -> yearToDate();
                case "4" -> previousYear();
                case "5" -> vendor();
                case "X" -> System.out.println("Back to Ledger");
                default -> System.out.println("Bad Input Re-Enter Information");


            }
        }
    }

    //print entries for month & year
    private static void monthtoDate() {
        ArrayList<Transactions> currentTransactions = transactions();
        //loads csv
        Collections.reverse(currentTransactions);
        //todays date
        LocalDate today = LocalDate.now();
        //going through list
        for (Transactions t : currentTransactions) {
            if (t.getDate().getMonthValue() == today.getMonthValue()) {
                if (t.getDate().getYear() == today.getYear()) {
                    System.out.println(t);
                }
            }
        }
    }

    private static void previousMonth() {
        //load transaction list below
        ArrayList<Transactions> currentTransactions = transactions();
        Collections.reverse(currentTransactions);
        LocalDate monthLast = LocalDate.now().minusMonths(1);
        for (Transactions t : currentTransactions) {
            if (t.getDate().getMonthValue() == monthLast.getMonthValue()) {
                if (t.getDate().getYear() == monthLast.getYear()) {
                    System.out.println(t);

                }
            }
        }
    }




    private static void yearToDate () {
        ArrayList<Transactions> currentTransactions = transactions();
        Collections.reverse(currentTransactions);
        LocalDate currentDate = LocalDate.now();
        for (Transactions t : currentTransactions) {
            if (t.getDate().getYear() == currentDate.getYear()) {
                System.out.println(t);
            }
        }
    }

    private static void previousYear () {
        ArrayList<Transactions> currentTransactions = transactions();
        Collections.reverse(currentTransactions);
        int prevYear = LocalDate.now().getYear() - 1;
        for (Transactions t : currentTransactions) {
            if (t.getDate().getYear() == prevYear) {
                System.out.println(t);
            }
        }
    }

    private static void vendor() {
        System.out.println("Enter vendor: ");
        String vendorInput = read.nextLine();
        ArrayList<Transactions> currentTransactions = transactions();
        Collections.reverse(currentTransactions);
        for (Transactions t: currentTransactions) {
        if (t.getVendor().equalsIgnoreCase(vendorInput)) {
            System.out.println(t);

                }
            }
        }
    }




