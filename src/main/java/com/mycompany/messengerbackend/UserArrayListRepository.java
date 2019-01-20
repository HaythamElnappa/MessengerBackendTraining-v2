
package com.mycompany.messengerbackend;

import java.util.ArrayList;


public class UserArrayListRepository extends UserRepository {
    
    private ArrayList<User> users = new ArrayList<User>() ;

    
    @Override
    public void addUser(User u){
        
        this.users.add(u);
    };
    
    @Override
    public User removeUserById(int id){
    	for(int i=0 ; i<this.users.size();i++) {
	    if(this.users.get(i).getId()== id) {
		this.users.remove(this.users.get(i));
		return this.users.get(i);
                    }
		}
	return null;   
    };
    
    @Override
    public User getUserById(int id){
    
        for(int i=0 ; i<this.users.size();i++) {
            if(this.users.get(i).getId()==id) {
                return this.users.get(i);
            }	
	}
	return null;
    }
    
    @Override
    public ArrayList getAllUsers(){
    
        return this.users;        
    }
}
