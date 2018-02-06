/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.tests;

import com.informationmanagement.model.UserModel;
import junit.framework.TestCase;

/**
 *
 * @author ASUS
 */
public class Tests extends TestCase {
    
    public static void main(String[] args) throws Exception{
        //WebServiceConnection a = new WebServiceConnection() {};
        //String b = a.getRequest("http://192.168.1.143:8081/WebServiceIM/"
          //      + "user.php?email=claudio2filipesilvagoncalves@gmail.com");
        //System.out.println(b);
        UserModel a = new UserModel();
        UserModel b = a.getUser("asdfasfa");
        System.out.println(b.getFirstName());
    }
}
