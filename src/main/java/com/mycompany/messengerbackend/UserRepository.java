package com.mycompany.messengerbackend;

import java.util.ArrayList;


public abstract class UserRepository {


    public abstract void addUser(User a);

    public abstract boolean removeUserById(String id);
    
    public abstract User getElementById(String id);
    
    public abstract ArrayList getAllUsers();
}
