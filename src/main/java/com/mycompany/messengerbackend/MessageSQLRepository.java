
package com.mycompany.messengerbackend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class MessageSQLRepository extends MessageRepository {
    
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
                
                list.add(new Message(rs.getInt("id"),rs.getString("m.body")));
                
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
            st.setInt(1, m.getId());
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
    public Message removeMessageById(int id){
        
        try{
            
            MessageSQLRepository m = new MessageSQLRepository();
            Message deletedMessage = m.getMessageById(id);
            
            c = dbc.connect();
            query = "delete from message where id = ?";
            st = c.prepareStatement(query);
            st.setInt(1,id);
            st.execute();
            
            return deletedMessage;
        
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    //_____________________________________________________________________________________//
    
    @Override
    public Message getMessageById(int id){
        

        try {

            c = dbc.connect();
            query = "select id , m.body , senderid , receiverid from user where id = ?";
            st = c.prepareStatement(query);
            st.setInt(1, id);
            rs = st.executeQuery();
            rs.next();
            
            
            Message m = new Message(rs.getInt("id"),rs.getString("m.body"),rs.getString("senderid"),rs.getString("receiverid"));
            
            return m;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return null;

        }
    }
}
