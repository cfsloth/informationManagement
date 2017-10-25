/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informantionmanagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author CláudioFilipedaSilva
 */
public class DatabaseConection {
    Connection c;
        
    public DatabaseConection() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/InformationManagement",
            "postgre", "claudiofilipe21");
    }
}
