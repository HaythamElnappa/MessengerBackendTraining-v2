
package com.mycompany.messengerbackend;

import com.google.gson.Gson;
import java.util.ArrayList;
import static spark.Spark.*;


public class MainClass {

    
    public static void main(String[] args) {
        
        UserSQLRepository ur = new UserSQLRepository();
        

        
        get("/user/:id",(req,res)->{
            
            int id = Integer.parseInt(req.params(":id"));
            User u = ur.getUserById(id);
            String jsonUser = new Gson().toJson(u);

            return jsonUser;
        });
        
        
        get("/users",(req,res)->{
            
            ArrayList u = ur.getAllUsers();
            String jsonUsers = new Gson().toJson(u);
            
            return jsonUsers;
        });
        
        post("/user",(req,res)->{
            
            User u = new Gson().fromJson(req.body(), User.class);
            ur.addUser(u);
            
            return "user is added";
        });
        
        delete("/user/:id",(req,res)->{
            
            int id = Integer.parseInt(req.params(":id"));
            User deletedUser = ur.removeUserById(id);
            
            return deletedUser;
        });
        
        
    }
    
}
