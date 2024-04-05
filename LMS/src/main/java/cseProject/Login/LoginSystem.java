/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login;

import java.util.ArrayList;
import cseProject.SystemHelper;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public class LoginSystem {

    private User loginUser;
    private ArrayList<User> userDB;
    private SystemHelper helper;

    public void init() {
        loginUser = null; // 처음에는 아무도 로그인 안함
        userDB = new ArrayList<>(); // 유저 정보를 담을 객체배열
        helper = new SystemHelper(); // 시스템 헬퍼 호출
    }
    
    public void make_ID(String ID, String PW) throws IOException {
        User newUser = new User(ID, PW);
        String newID = helper.getUserInput();
        String newPW = helper.getUserInput();
        String newName = helper.getUserInput();

        newUser.setUserID(newID);
        newUser.setUserPW(newPW);
        newUser.setUserName(newName);
        userDB.add(newUser);
        
        System.out.println("회원가입이 완료되었습니다.");
    }

    public void try_Login() throws IOException {
        System.out.println("로그인을 시도 합니다.");

        do {
            System.out.println("ID : ");
            String ID = helper.getUserInput();
            System.out.println("PW : ");
            String PW = helper.getUserInput();

            for (User check_user : userDB) {
                if (check_user.getUserID().equals(ID) && check_user.getUserPW().equals(PW)) {
                    loginUser = check_user; // 로그인 성공 시 현재 로그인한 사용자 설정
                    System.out.println("로그인 성공.");
                    System.out.println("안녕하세요 " + loginUser.getUserName() + "님");
                    break;
                }
            }
            
            if (loginUser == null) {
                System.out.println("로그인 정보를 찾을 수 없습니다.");
            }
            
        } while (loginUser == null);
    }
    
    public User runLoginSystem() throws IOException{
        init();
        try_Login();
        return loginUser;
    }
}
