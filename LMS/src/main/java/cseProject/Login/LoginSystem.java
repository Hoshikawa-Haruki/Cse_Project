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

    public void make_ID() throws IOException {
        System.out.println("생성 할 ID를 입력하세요");
        String newID;
        do {
            newID = helper.getUserInput();
            if (newID.length() < 4) {
                System.out.println("ID는 4자리 이상 입력해주세요.");
                System.out.println("다시 입력해주세요.");
            }
        } while (newID.length() < 4);

        System.out.println("생성 할 PW를 입력하세요");
        String newPW;
        do {
            newPW = helper.getUserInput();
            if (newPW.length() < 4) {
                System.out.println("PW는 4자리 이상 입력해주세요.");
                System.out.println("다시 입력해주세요.");
            }
        } while (newPW.length() < 4);

        System.out.println("이름을 입력하세요");
        String newName = helper.getUserInput();

        User newUser = new User(newID, newPW, newName);
        userDB.add(newUser);
        System.out.println("회원가입이 완료되었습니다.");
    }

    public void try_Login() throws IOException {
        System.out.println("로그인을 시도 합니다.");

        do {
            System.out.print("ID : ");
            String ID = helper.getUserInput();
            System.out.print("PW : ");
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

    public User runLoginSystem() throws IOException {
        init();
        System.out.println("1. 회원가입");
        make_ID();
        System.out.println("2. 로그인시도");
        try_Login();
        return loginUser;
    }
}
