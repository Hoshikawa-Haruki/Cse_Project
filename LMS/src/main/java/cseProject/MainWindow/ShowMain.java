/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cseProject.MainWindow;

import cseProject.SystemHelper;
import java.io.IOException;

/**
 *
 * @author 이승환
 */
public class ShowMain {

    private SystemHelper helper;
    public String check;

    public void init() {
        helper = new SystemHelper(); // 시스템 헬퍼 호출
    }

    public void firstWindow() throws IOException {
        System.out.println("1. 로그인 하기");
        System.out.println("2. 회원가입");
        check = helper.getUserInput();
    }

    public void runShowMain() throws IOException {
        init();
        firstWindow();
    }
}
