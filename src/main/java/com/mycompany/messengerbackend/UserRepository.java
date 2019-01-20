package com.mycompany.messengerbackend;

import java.util.ArrayList;


public abstract class UserRepository {


    public abstract void addUser(User a);

    public abstract User removeUserById(int id);
    
    public abstract User getUserById(int id);
    
    public abstract ArrayList getAllUsers();
}
