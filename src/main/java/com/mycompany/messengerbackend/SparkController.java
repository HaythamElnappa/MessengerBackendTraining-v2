
package com.mycompany.messengerbackend;

import com.google.gson.Gson;
import static spark.Spark.*;


public class SparkController {

    
    public static void main(String[] args) {
        
        SQLUserRepository ur = new SQLUserRepository();
        

        
        get("/user/:id",(req,res)->{

            return new Gson().toJson(ur.getElementById(Integer.parseInt(req.params(":id"))));
        });
        
        get("/user",(req,res)->{
            
            return new Gson().toJsonTree(ur.getAllUsers());
        });
        
        post("/user",(req,res)->{
            
            ur.addUser(new Gson().fromJson(req.body(), User.class));
            return "user is added";
        });
        
        post("/user/:id",(req,res)->{
            
            ur.removeUserById(Integer.parseInt(":id"));
            return "user is deleted";
        });
        
        
    }
    
}
