/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login;

/**
 *
 * @author 이승환
 */
public class User {

    private String userID;
    private String userPW;
    private String userName;
    private boolean isManager;

    public User(String userID, String userPW, String userName, boolean isManager) {
        this.userID = userID;
        this.userPW = userPW;
        this.userName = userName;
        this.isManager = isManager;
    }

    public User(String userID, String userPW) {
        this(userID, userPW, "", false);
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPW() {
        return userPW;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isIsManager() {
        return isManager;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserPW(String userPW) {
        this.userPW = userPW;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }

}
