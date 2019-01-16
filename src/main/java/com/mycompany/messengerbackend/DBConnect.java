
package com.mycompany.messengerbackend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {
    
     private final String user = "root";
     private final String pass = "";
     private final String url = "jdbc:mysql://localhost/messengerbackend2";
    
    public Connection connect() throws SQLException{
        
            return DriverManager.getConnection(url, user, pass);
        
    };
    
}
