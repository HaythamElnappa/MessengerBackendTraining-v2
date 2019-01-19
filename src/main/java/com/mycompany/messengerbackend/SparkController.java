
package com.mycompany.messengerbackend;

import com.google.gson.Gson;
import static spark.Spark.*;


public class SparkController {

    
    public static void main(String[] args) {
        
        SQLUserRepository ur = new SQLUserRepository();
        

        
        get("/user/:id",(req,res)->{
            
            int id = Integer.parseInt(req.params(":id"));
            String body = new Gson().toJson(ur.getElementById(id));

            return body;
        });
        
        
        get("/users",(req,res)->{
            
            String body = new Gson().toJson(ur.getAllUsers());
            
            return body;
        });
        
        post("/user",(req,res)->{
            
            User u = new Gson().fromJson(req.body(), User.class);
            ur.addUser(u);
            
            return "user is added";
        });
        
        delete("/user/:id",(req,res)->{
            
            int id = Integer.parseInt(":id");
            
            ur.removeUserById(id);
            return "user is deleted";
        });
        
        
    }
    
}
