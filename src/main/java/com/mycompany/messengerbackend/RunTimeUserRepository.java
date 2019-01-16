
package com.mycompany.messengerbackend;

import java.util.ArrayList;


public class RunTimeUserRepository extends UserRepository {
    
    private ArrayList<User> users = new ArrayList<User>() ;

    
    @Override
    public void addUser(User u){
        
        this.users.add(u);
    };
    
    @Override
    public boolean removeUserById(String id){
    	for(int i=0 ; i<users.size();i++) {
	    if(users.get(i).getId()==id) {
		users.remove(this.users.get(i));
		return true;
                    }
		}
	return false;   
    };
    
    @Override
    public User getElementById(String id){
    
        for(int i=0 ; i<users.size();i++) {
            if(users.get(i).getId()==id) {
                return this.users.get(i);
            }	
	}
	return null;
    }
    
    @Override
    public ArrayList getAllUsers(){
    
        return users;        
    }
            
    
    
}
