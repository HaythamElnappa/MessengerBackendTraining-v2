/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.messengerbackend;

import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

/**
 *
 * @author hayth
 */
public class Authentication {

    Key key ;
    Gson gson = new Gson();

    public Authentication() {
        key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String encodeToken(String data) {
        return Jwts.builder().setSubject(data).signWith(key).compact();
    }

    public String decodeToken(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
    }

    public String authenticateJSON(String jsonUser, UserRepository ur) {
        User sentUser = new Gson().fromJson(jsonUser, User.class);
        System.out.println(sentUser);
        User realUser = ur.getUserByName(sentUser.getName());
        System.out.println(realUser);
        if (realUser != null && sentUser.getPassword().equals(realUser.getPassword())) {
            String msg = "You are Authenticated";
            System.out.println(msg);
            return this.encodeToken(jsonUser);
        } else {
            String msg = "You are not Authenticated";
            System.out.println(msg);
            return null;
        }

    }

    public String authenticateToken(String token, UserRepository ur) {
        System.out.println("Enter auth function");
        String jsonUser = this.decodeToken(token);
        System.out.println(jsonUser);
        return this.authenticateJSON(jsonUser, ur);

    }
}


