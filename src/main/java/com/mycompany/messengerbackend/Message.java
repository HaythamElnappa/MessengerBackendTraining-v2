
package com.mycompany.messengerbackend;


public class Message {
    
    // the private variable 
	
	private int id;
	private String body;
	private String senderId;
	private String receivedId;
        
        public Message(){};
	
	 
	public Message (int id , String body ,String senderId, String reciverId) {
		this.id = id;
		this .body =body;
                this.senderId = senderId;
                this.receivedId = reciverId;
	}
        
        public Message (int id , String body) {
		this.id = id;
		this .body =body;
                
	}
        
        
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSenderId() {
		return this.senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getReceivedId() {
		return this.receivedId;
	}

	public void setReceivedId(String receivedId) {
		this.receivedId = receivedId;
	}
    
}
