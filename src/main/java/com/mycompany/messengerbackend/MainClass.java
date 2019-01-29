package com.mycompany.messengerbackend;

import com.google.gson.Gson;
import java.util.ArrayList;
import static spark.Spark.*;

public class MainClass {

    public static void main(String[] args) {

        UserSQLRepository ur = new UserSQLRepository();
        MessageSQLRepository mr = new MessageSQLRepository();
        Authentication auth = new Authentication();
        Gson gson = new Gson();

        post("/login", (req, res) -> {
            return auth.authenticateJSON(req.body(), ur);
        });

        get("/user/:name", (req, res) -> {
            String token = req.headers("Authorization");
            if (auth.authenticateToken(token, ur) != null) {
                String name = req.params(":name");
                User u = ur.getUserByName(name);
                String jsonUser = gson.toJson(u);

                return jsonUser;
            } else {
                String msg = "You are not Authenticated";
                return msg;
            }

        });

        get("/users", (req, res) -> {
            
            String token = req.headers("Authorization");
            if (auth.authenticateToken(token, ur) != null){
                ArrayList u = ur.getAllUsers();
                String jsonUsers = gson.toJson(u);
            
                return jsonUsers;
            }else {
                String msg  = "you are not Authenticated";
                return msg;
            }
        });

        post("/signup", (req, res) -> {
            String jsonUser = req.body();
            User u = gson.fromJson(jsonUser, User.class);
            ur.addUser(u);

            return auth.authenticateJSON(jsonUser, ur);
        });

        delete("/user/:id", (req, res) -> {
            String token = req.headers("Authorization");
            if(auth.authenticateToken(token, ur) != null){
                int id = Integer.parseInt(req.params(":id"));
                User deletedUser = ur.removeUserById(id);

                return deletedUser;
            }else {
                String msg = "you are not authenticated";
                return msg;
            }
        });
        
        post("/message",(req,res)->{
            String token = req.headers("Authorization");
            
            if(auth.authenticateToken(token, ur) != null){
                String sentMessage = req.body();
                Message m = gson.fromJson(sentMessage, Message.class);
                System.out.println("sender id is : " + m.getSenderId());
                mr.addMessage(m);
                String msg = "message added";
                return msg;
            }else{
                String msg = "you are not authenticated";
                return msg;
            }
        });
        
        get("/messages",(req,res)->{
            String token = req.headers("Authorization");
            
            if(auth.authenticateToken(token, ur) != null){
                ArrayList m = mr.getAllMessages();
                String jsonRes = gson.toJson(m);
                return jsonRes;
            }else{
                String msg = "you are not authenticated";
                return msg;
            }
        });
        
        get("/message/:id",(req,res)->{
            String token =req.headers("Authorization");
            
            if(auth.authenticateToken(token, ur) != null){
                int sentId = Integer.parseInt(req.params(":id"));
                Message m = mr.getMessageById(sentId);
                String jsonRes = gson.toJson(m);
                return jsonRes;
            }else{
                String msg = "you are not authenticated";
                return msg;
            }
        });
        
        delete("/message/:id",(req,res)->{
            String token = req.headers("Authorization");
            
            if(auth.authenticateToken(token, ur) != null){
                int sentId = Integer.parseInt(req.params(";id"));
                Message deletedMessage = mr.removeMessageById(sentId);
                
                return deletedMessage;
            }else{
                String msg = "you are not authenticated";
                return msg;
            }
        });

    }

}
