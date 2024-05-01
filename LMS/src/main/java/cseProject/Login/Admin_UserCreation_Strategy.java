/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.Login;

/**
 *
 * @author 이승환
 */
public class Admin_UserCreation_Strategy implements UserCreation_Strategy {

    @Override
    public void make_User(String newID, String newPW, String newName, boolean newisManager) {
        System.out.println("관리자 코드를 입력하세요:");
        String managerCode = helper.getUserInput();
        if (!managerCode.equals("1111")) {
            System.out.println("올바르지 않은 관리자 코드입니다. 회원가입을 취소합니다.");
            return; // 메서드를 즉시 종료하고 호출자로 반환
        } else {
            User newUser = UserFactory.createUser(newID, newPW, newName, newisManager);
            userDB.add(newUser);
            System.out.println("회원가입이 완료되었습니다.");
        }
    }

}
