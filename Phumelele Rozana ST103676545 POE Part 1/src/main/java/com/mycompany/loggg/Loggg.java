package com.mycompany.loggg;
import java.util.Scanner;

public class Loggg {

    private final String username;
    private final String password;
    private final String cellNumber;

    // Constructor now asks for input directly
    public Loggg(Scanner sc) {
        System.out.print("Enter a username: ");
        this.username = sc.nextLine();

        System.out.print("Enter a password: ");
        this.password = sc.nextLine();

        System.out.print("Enter your South African cell number: ");
        this.cellNumber = sc.nextLine();
    }

    // Username validation (boolean)
    public boolean checkUsername() {
        return username.contains("_") && username.length() <= 5;
    }

    // Password validation (boolean)
    public boolean checkPassword() {
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if (password.length() >= 8) {
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    hasUpper = true;
                } else if (Character.isDigit(c)) {
                    hasDigit = true;
                } else if (!Character.isLetterOrDigit(c)) {
                    hasSpecial = true;
                }
            }
        }

        return password.length() >= 8 && hasUpper && hasDigit && hasSpecial;
    }

    // Cellphone number validation (boolean)
    public boolean checkCellNumber() {
        return cellNumber.matches("0\\d{9}"); // starts with 0 and has 10 digits
    }

    // Login feature (check username + password match)
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Registration happens automatically in constructor
        Loggg user = new Loggg(sc);

        // Validate inputs (using booleans with messages here)
        if (user.checkUsername()) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        if (user.checkPassword()) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        }

        if (user.checkCellNumber()) {
            System.out.println("Cell number successfully captured.");
        } else {
            System.out.println("Cell number incorrectly formatted or does not contain international code.");
        }

        System.out.println("--------------------");

        // Login attempt
        System.out.println("=== Login ===");
        System.out.print("Enter username: ");
        String loginUsername = sc.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = sc.nextLine();

        if (user.loginUser(loginUsername, loginPassword)) {
            System.out.println("Welcome " + loginUsername + ", it's great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }

        sc.close();
    }
}
