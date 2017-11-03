/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informationmanagement.tests;

import com.informantionmanagement.model.DatabaseConection;
import java.sql.SQLException;
import junit.framework.TestCase;

/**
 *
 * @author ASUS
 */
public class DatabaseAcess extends TestCase{
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        DatabaseConection con = new DatabaseConection();
        assertEquals("the value should be 0",0,1);
    }
    
}
