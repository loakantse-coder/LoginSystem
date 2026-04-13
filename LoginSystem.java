/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginsystem;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class LoginSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Login loginLogic = new Login();

        
        System.out.println("       REGISTRATION AND LOGIN SYSTEM          ");
       

        System.out.println("\n--- REGISTER ---");

        System.out.print("First Name: ");
        loginLogic.setFirstName(input.nextLine());

        System.out.print("Last Name: ");
        loginLogic.setLastName(input.nextLine());

        System.out.print("Username: ");
        loginLogic.setUsername(input.nextLine());

        System.out.print("Password: ");
        loginLogic.setPassword(input.nextLine());

        System.out.print("Cell Phone Number(+27): ");
        loginLogic.setCellPhoneNumber(input.nextLine());

        String regStatus = loginLogic.registerUser();
        System.out.println("\nRegistration Status: " + regStatus);

        if (regStatus.equals("Username and Password successfully captured.")) {
            System.out.println("\n--- LOGIN ---");

            System.out.print("Enter Username: ");
            String enteredUsername = input.nextLine();

            System.out.print("Enter Password: ");
            String enteredPassword = input.nextLine();

            String loginStatus = loginLogic.returnLoginStatus(enteredUsername, enteredPassword);
            System.out.println("\n" + loginStatus);

        } else {
            System.out.println("\nPlease fix the errors above and try again.");
        }

      
        input.close();
    }
}
