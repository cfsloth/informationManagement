/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.tests;

import com.informantionmanagement.model.WebServiceConnection;
import junit.framework.TestCase;

/**
 *
 * @author ASUS
 */
public class Tests extends TestCase {
    
    public static void main(String[] args) throws Exception{
        WebServiceConnection a = new WebServiceConnection();
        String b = a.getRequest("http://www.google.com");
        System.out.println(b);
    }
    
}
