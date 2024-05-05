/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login;

import java.util.ArrayList;

/**
 *
 * @author 이승환
 */
public class User_Manager {

    private static User_Manager instance; // 싱글턴
    private ArrayList<User_Info> userDB = new ArrayList<>(); // 유저DB
    private User_Info loginUser; // 현재 로그인 유저

    private User_Manager() {
        // Private 생성자
    }

    public static User_Manager getInstance() {
        if (instance == null) {
            instance = new User_Manager();
        }
        return instance;
    }

    public void add_userDB() {
        //팩토리 메서드를 통해 사용자 객체 생성
        User_Info newUser = User_Factory.createUser(newID, newPW, newName, newisManager);
        userDB.add(newUser);
    }

    public User_Info getLoginUser() {
        return loginUser;
    }

    public ArrayList<User_Info> getUserDB() {
        return userDB;
    }
}
