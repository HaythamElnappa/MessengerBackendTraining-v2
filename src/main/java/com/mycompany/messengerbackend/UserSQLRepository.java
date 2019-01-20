
package com.mycompany.messengerbackend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserSQLRepository extends UserRepository {
    
    Connection c ;
    PreparedStatement st;
    String query;
    ResultSet rs;
    DBConnect dbc = new DBConnect();
    ArrayList<User> list = new ArrayList() ;
    
    @Override
    public void addUser(User a) {
        

        try {
            

            c = dbc.connect();
            query = "insert into user values(?,?,?)";
            st = c.prepareStatement(query);
            st.setInt(1, a.getId());
            st.setString(2, a.getName());
            st.setString(3, a.getPassword());
            st.execute();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }
    
    @Override
    public User removeUserById(int id){
        
        UserSQLRepository u = new UserSQLRepository();
        
        try{
            
            User deletedUser = u.getUserById(id);
            c = dbc.connect();
            query = "delete from user where id = ?";
            st = c.prepareStatement(query);
            st.setInt(1,id);
            st.execute();
            
            System.out.println("step 1 complete");
            return deletedUser;
        
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    @Override
    public User getUserById(int id) {


        try {

            c = dbc.connect();
            query = "select id , name , password from user where id = ?";
            st = c.prepareStatement(query);
            st.setInt(1, id);
            rs = st.executeQuery();
            rs.next();
            
            User u = new User (rs.getInt("id"),rs.getString("name"),rs.getString("password"));

            return u;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return null;

        }
    }
    
    @Override
    public ArrayList getAllUsers(){
        
        try{
            
            c = dbc.connect();
            query = "select * from user";
            st = c.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()){
                list.add(new User(rs.getInt("id"),rs.getString("name"),rs.getString("password")));
            }
        }catch(SQLException e){
            
            System.out.println(e.getMessage());
            
        }
    
        return list;
    }
}
