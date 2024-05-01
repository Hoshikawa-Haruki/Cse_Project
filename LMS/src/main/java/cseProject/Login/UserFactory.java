/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login;

/**
 *
 * @author 이승환
 */

public class UserFactory {
    public static User createUser(String userID, String userPW, String userName, boolean isManager) {
        return new User(userID, userPW, userName, isManager);
    }
}
