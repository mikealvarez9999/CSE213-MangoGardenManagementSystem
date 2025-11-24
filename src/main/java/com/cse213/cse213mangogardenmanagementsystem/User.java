package com.cse213.cse213mangogardenmanagementsystem;

import java.util.Objects;

public class User {
    // CRITICAL FIX: Removed 'static'. These must be instance fields.
    protected String userName;
    protected String userPwd;
    protected String name;
    protected String phoneNo;

    // Fixed constructor to actually save the provided credentials
    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public boolean login(String inputUsername, String inputPassword){
        // Now checks the instance fields, which are initialized in the constructor
        return Objects.equals(this.userName, inputUsername) && Objects.equals(this.userPwd, inputPassword);

    }
    public void logout() {
        System.out.println(this.userName + " logged out.");
    }

    public void updateProfileInfo(String newUsername, String newPassword) {
        this.userName = newUsername;
        this.userPwd = newPassword;
        System.out.println("Profile updated for " + this.userName);
    }

    // Getters
    public String getUsername() { return userName; }
    public String getPassword() { return userPwd; }
}