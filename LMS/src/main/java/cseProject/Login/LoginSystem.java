package cseProject.Login;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import cseProject.Login.User_Strategy.General_UserCreation_Strategy;
import cseProject.Login.User_Strategy.Admin_UserCreation_Strategy;
import java.util.ArrayList;
import cseProject.SystemHelper;
import cseProject.Login.User_Manager;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public class LoginSystem {

    private static LoginSystem instance;
    //private User_Info loginUser;
    //private ArrayList<User_Info> userDB;
    private static SystemHelper helper = SystemHelper.getInstance();
    private static User_Manager manager = User_Manager.getInstance();
//    // 생성자를 private으로 선언하여 외부에서 인스턴스화 방지
//    private LoginSystem() {
//        // Private 생성자
//    }
//
//    public static LoginSystem getInstance() {
//        if (instance == null) {
//            instance = new LoginSystem();
//        }
//        return instance;
//    }

//    public User_Info getLoginUser() {
//        return loginUser;
//    }
//    public void init() {
//        loginUser = null; // 처음에는 아무도 로그인 안함
//        userDB = new ArrayList<>(); // 유저 정보를 담을 객체배열
//    }
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
        boolean newisManager = isManagerChoice.equalsIgnoreCase("y");

        if (newisManager) {
            // 관리자 전략을 사용하여 가입 처리
            Admin_UserCreation_Strategy adminStrategy = new Admin_UserCreation_Strategy();
            adminStrategy.make_User(newID, newPW, newName, newisManager);
        } else {
            // 일반 사용자 전략을 사용하여 가입 처리
            General_UserCreation_Strategy generalStrategy = new General_UserCreation_Strategy();
            generalStrategy.make_User(newID, newPW, newName, newisManager);
        }

        //팩토리 메서드를 통해 사용자 객체 생성
//        User_Info newUser = User_Factory.createUser(newID, newPW, newName, newisManager);
//        userDB.add(newUser);
//        System.out.println("회원가입이 완료되었습니다.");
    }

    public void try_Login() throws IOException {
        //System.out.println("로그인을 시도 합니다.");
        do {
            System.out.print("ID : ");
            String ID = helper.getUserInput();
            System.out.print("PW : ");
            String PW = helper.getUserInput();

            for (User_Info check_user : manager.getUserDB()) {
                if (check_user.getUserID().equals(ID) && check_user.getUserPW().equals(PW)) {
                    //loginUser = check_user; // 로그인 성공 시 현재 로그인한 사용자 설정 (지금은 필요없음!)
                    System.out.println("로그인 성공.");
                    if (check_user.getIsManager()) {
                        System.out.println("안녕하세요 " + manager.getLoginUser().getUserName() + " 관리자님");
                    } else {
                        System.out.println("안녕하세요 " + manager.getLoginUser().getUserName() + " 님");
                    }
                    break;
                }
            }

            if (manager.getLoginUser() == null) {
                System.out.println("로그인 정보를 찾을 수 없습니다.");
            }

        } while (manager.getLoginUser() == null);
    }

    public User_Info runLoginSystem() throws IOException {
        //init();
        while (true) {
            System.out.println("1. 회원가입, 2. 로그인");
            String choice = helper.getUserInput();

            switch (choice) {
                case "1" -> {
                    System.out.println("회원가입을 시작합니다.");
                    make_ID();
                }
                case "2" -> {
                    System.out.println("로그인을 시도합니다.");
                    try_Login();
                }
                default ->
                    System.out.println("잘못된 입력입니다.");
            }
            // 회원가입 또는 로그인 후에도 다시 while 루프를 돌기 위해 루프 조건을 유지
            // 로그인에 성공했을 때만 루프를 빠져나옴
            if (manager.getLoginUser() != null) {
                break;
            }
        }
        return manager.getLoginUser();
    }
}
