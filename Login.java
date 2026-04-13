/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginsystem;

/**
 *
 * @author Student
 */
import java.util.regex.Pattern;

public class Login {

    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    public Login(String firstName, String lastName, String username,
                 String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public Login() {}

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getCellPhoneNumber() { return cellPhoneNumber; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setCellPhoneNumber(String cellPhoneNumber) { this.cellPhoneNumber = cellPhoneNumber; }

    public boolean checkUserName() {
        if (username == null) {
            return false;
        } else if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPasswordComplexity() {
        if (password == null) {
            return false;
        } else if (password.length() < 8) {
            return false;
        } else if (!password.matches(".*[A-Z].*")) {
            return false;
        } else if (!password.matches(".*[0-9].*")) {
            return false;
        } else if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkCellPhoneNumber() {
        if (cellPhoneNumber == null) {
            return false;
        //Regex.Pattern to validate the international code (+27)
        } else if (Pattern.matches("^\\+27[0-9]{9}$", cellPhoneNumber)) {
            return true;
        } else {
            return false;
        }
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username "
                 + "contains an underscore and is no more than five characters in length.";
        } else if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password "
                 + "contains at least eight characters, a capital letter, a number, "
                 + "and a special character.";
        } else if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain "
                 + "international code.";
        } else {
            return "Username and Password successfully captured.";
        }
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (enteredUsername == null || enteredPassword == null) {
            return false;
        } else if (this.username != null && this.password != null &&
                   this.username.equals(enteredUsername) && 
                   this.password.equals(enteredPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName
                 + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
