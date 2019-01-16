
package com.mycompany.messengerbackend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class SQLMesseageRepository extends MesseageRepository {
    
    private Connection c;
    private PreparedStatement st;
    private ResultSet rs;
    private String query;
    private ArrayList<Message> list = new ArrayList(); 
    
    DBConnect dbc = new DBConnect();
    
    
    
    @Override
    public ArrayList getAllMessages(){
    
        try{
            
            c = dbc.connect();
            query = "select * from message";
            st = c.prepareStatement(query);
            rs = st.executeQuery();
            
            while(rs.next()){
                
                list.add(new Message(rs.getString("id"),rs.getString("m.body")));
                
            }
            
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    //_______________________________________________________________________________________//
    
    @Override
    public void addMessage(Message m){
        
        try{
            
            c = dbc.connect();
            query = "insert into message values(?,?,?,?)";
            st = c.prepareStatement(query);
            st.setString(1, m.getId());
            st.setString(2, m.getBody());
            st.setString(4, m.getReceivedId());
            st.setString(3, m.getSenderId());
            st.execute();
            
            
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            
        }
    
    }
    
    //_____________________________________________________________________________________//
    
    @Override
    public boolean removeMessage(String id){
        
        try{
            
            c = dbc.connect();
            query = "delete from message where id = ?";
            st = c.prepareStatement(query);
            st.setString(1,id);
            st.execute();
            
            System.out.println("step 1 complete");
            return true;
        
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    //_____________________________________________________________________________________//
    
    public Message getMessageById(String id){
        

        try {

            c = dbc.connect();
            query = "select id , m.body , senderid , receiverid from user where id = ?";
            st = c.prepareStatement(query);
            st.setString(1, id);
            rs = st.executeQuery();
            rs.next();
            
            
            Message m = new Message(rs.getString("id"),rs.getString("m.body"),rs.getString("senderid"),rs.getString("receiverid"));
            
            return m;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return null;

        }
    }
}
