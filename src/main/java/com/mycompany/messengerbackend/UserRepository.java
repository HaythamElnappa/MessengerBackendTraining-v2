package com.mycompany.messengerbackend;

import java.util.ArrayList;


public abstract class UserRepository {


    public abstract void addUser(User a);

    public abstract boolean removeUserById(int id);
    
    public abstract User getElementById(int id);
    
    public abstract ArrayList getAllUsers();
}
