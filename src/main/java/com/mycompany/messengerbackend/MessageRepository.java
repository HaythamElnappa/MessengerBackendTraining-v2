
package com.mycompany.messengerbackend;

import java.util.ArrayList;


public abstract class MessageRepository {
    

	public abstract ArrayList getAllMessages();
        
	public abstract void addMessage(Message message);
	
	public abstract Message removeMessageById(int id);
        
	public abstract Message getMessageById(int id); 
}
