package com.cse213.cse213mangogardenmanagementsystem;

import java.util.Objects;

public class User {
    protected static String userName;
    protected static String userPwd;
    protected static String name;
    protected static String phoneNo;

    public boolean login(String inputUsername, String inputPassword){
        return Objects.equals(this.userName, inputUsername) && Objects.equals(this.userPwd, inputPassword);

    };
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
