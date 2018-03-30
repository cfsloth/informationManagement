/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.tests;

import com.informationmanagement.model.WarningModel;
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
        //WebServiceConnection a = new WebServiceConnection() {};
        //Gson b = new Gson();
        //UserModel user = new UserModel();
        //user.setEmail("simaocunha@gmail.com");
        //user.setPassword("simaosaborosa");
        //String c = b.toJson(user);
        //a.deleteRequest("http://172.26.53.157:8081/WebServiceIM/user.php",c);
        //a.putRequest("http://172.26.53.157:8081/WebServiceIM/user.php",c);
        WarningModel a = new WarningModel();
        a.getWarningByUser("claudiofilipesilvagoncalves@gmail.com");
    }
}
