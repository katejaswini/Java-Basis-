package BankAccount;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Account {
    long accNo;
    String name;
    double balance;
    public Account(long accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }
    void display() {
        System.out.println("----------------------------");
        System.out.println("Acc No   : " + accNo);
        System.out.println("Name     : " + name);
        System.out.println("Balance  : " + balance);
        System.out.println("----------------------------");
    }
}
public class ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Long, Account> accMap = new TreeMap<>(); // sorted by accNo
        int choice;
        do {
            System.out.println("\n==== BANK ACCOUNTS (TreeMap) ====");
            System.out.println("1. Open Account (CREATE)");
            System.out.println("2. View All Accounts (READ)");
            System.out.println("3. Deposit (UPDATE)");
            System.out.println("4. Close Account (DELETE)");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Account No : ");
                    long accNo = sc.nextLong();
                    System.out.print("Enter Name       : ");
                    String name = sc.next();
                    System.out.print("Enter Opening Bal: ");
                    double bal = sc.nextDouble();
                    if (accMap.containsKey(accNo)) {
                        System.out.println("Account already exists.");
                    } else {
                        accMap.put(accNo, new Account(accNo, name, bal));
                        System.out.println("Account Opened.");
                    }
                    break;
                case 2:
                    if (accMap.isEmpty()) {
                        System.out.println("No accounts found.");
                    } else {
                        for (Account a : accMap.values()) {
                            a.display();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Account No for deposit: ");
                    long dacc = sc.nextLong();
                    Account a = accMap.get(dacc);
                    if (a != null) {
                        System.out.print("Enter Amount to deposit: ");
                        double amt = sc.nextDouble();
                        a.balance += amt;
                        System.out.println("Balance Updated. New Balance = " + a.balance);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No to close: ");
                    long cacc = sc.nextLong();
                    if (accMap.remove(cacc) != null) {
                        System.out.println("Account closed.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}