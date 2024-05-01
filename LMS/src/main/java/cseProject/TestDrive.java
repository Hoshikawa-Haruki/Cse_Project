/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cseProject;

import cseProject.Login.LoginSystem;
import java.io.IOException;
import cseProject.MainWindow.ShowMain;

/**
 *
 * @author 이승환
 *
 */
public class TestDrive {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //ShowMain ShowMain = new ShowMain();
        LoginSystem loginSystem = new LoginSystem();

        //ShowMain.runShowMain();        
        loginSystem.runLoginSystem();

    }
}
