
package com.mycompany.messengerbackend;

import java.util.ArrayList;


public abstract class MesseageRepository {
    

	public abstract ArrayList getAllMessages();
        
	public abstract void addMessage(Message message);
	
	public abstract boolean removeMessage(String id);
        
	public abstract Message getMessageById(String id); 
}
