package cseProject.Login;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import cseProject.SystemHelper;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public class LoginSystem {

    private static LoginSystem instance;
    private User loginUser;
    private ArrayList<User> userDB;
    private SystemHelper helper;

    // 생성자를 private으로 선언하여 외부에서 인스턴스화 방지
    private LoginSystem() {
        // Private 생성자
    }

    public static LoginSystem getInstance() {
        if (instance == null) {
            instance = new LoginSystem();
        }
        return instance;
    }

    public User getLoginUser() {
        return loginUser;
    }

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

        // 관리자로 가입하는 기능 추가
        System.out.println("관리자로 가입하시겠습니까? (y/n)");
        String isManagerChoice = helper.getUserInput();
        boolean isManager = false; // 일단 기본값은 일반 사용자로 설정

        if (isManagerChoice.equalsIgnoreCase("y")) {
            System.out.println("관리자 코드를 입력하세요:");
            String managerCode = helper.getUserInput();
            if (managerCode.equals("1111")) {
                isManager = true; // 올바른 관리자 코드를 입력했을 때만 관리자로 설정
            } else {
                System.out.println("올바르지 않은 관리자 코드입니다.");
                return;
            }
        }

        // 팩토리 메서드를 통해 사용자 객체 생성
        User newUser = UserFactory.createUser(newID, newPW, newName, isManager);
        userDB.add(newUser);
        System.out.println("회원가입이 완료되었습니다.");

        /*User newUser = new User(newID, newPW, newName);
        userDB.add(newUser);
        System.out.println("회원가입이 완료되었습니다.");*/ // 팩토리 메서드 미적용
    }

    public void try_Login() throws IOException {
        //System.out.println("로그인을 시도 합니다.");
        do {
            System.out.print("ID : ");
            String ID = helper.getUserInput();
            System.out.print("PW : ");
            String PW = helper.getUserInput();

            for (User check_user : userDB) {
                if (check_user.getUserID().equals(ID) && check_user.getUserPW().equals(PW)) {
                    loginUser = check_user; // 로그인 성공 시 현재 로그인한 사용자 설정
                    System.out.println("로그인 성공.");
                    if (check_user.getIsManager()) {
                        System.out.println("안녕하세요 " + loginUser.getUserName() + "관리자님");
                    } else {
                        System.out.println("안녕하세요 " + loginUser.getUserName() + "님");
                    }
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
        while (true) {
            System.out.println("1. 회원가입, 2. 로그인");
            String choice = helper.getUserInput();

            switch (choice) {
                case "1":
                    System.out.println("회원가입을 시작합니다.");
                    make_ID();
                    break;
                case "2":
                    System.out.println("로그인을 시도합니다.");
                    try_Login();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
            // 회원가입 또는 로그인 후에도 다시 while 루프를 돌기 위해 루프 조건을 유지
            // 로그인에 성공했을 때만 루프를 빠져나옴
            if (loginUser != null) {
                break;
            }
        }
        return loginUser;
    }
}
