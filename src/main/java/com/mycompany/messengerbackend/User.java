
package com.mycompany.messengerbackend;


public class User {
    
    // the private variable 
	private String id;
	private String name;
	private String password;
	
	// the constractor
	
	public User(String id , String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
        
//        public User(){}
        
        

	
	//the public getter and setter for the variable

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
	
	
	
	

}