
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
            query = "select * from message2";
            st = c.prepareStatement(query);
            rs = st.executeQuery();
            
            while(rs.next()){
                
                list.add(new Message(rs.getInt("id"),rs.getString("body"),rs.getInt("senderId"),rs.getInt("receiverId")));
                
            }
            
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
        }
        return list;

    }
    
    //_______________________________________________________________________________________//
    
    @Override
    public void addMessage(Message m){
        
        try{
            
            c = dbc.connect();
            query = "insert into message2(body , senderId ,receiverId ) values(?,?,?)";
            st = c.prepareStatement(query);
            st.setString(1, m.getBody());
            st.setInt(2, m.getSenderId());
            st.setInt(3, m.getReceivedId());
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
            query = "delete from message2 where id = ?";
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
            query = "select id , body , senderId , receiverId from message2 where id = ?";
            st = c.prepareStatement(query);
            st.setInt(1, id);
            rs = st.executeQuery();
            rs.next();
            
            
            Message m = new Message(rs.getInt("id"),rs.getString("body"),rs.getInt("senderId"),rs.getInt("receiverId"));
            
            return m;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return null;

        }
    }
}
