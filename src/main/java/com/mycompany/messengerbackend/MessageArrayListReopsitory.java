
package com.mycompany.messengerbackend;

import java.util.ArrayList;


public class MessageArrayListReopsitory extends MessageRepository {
    
    
    private ArrayList<Message> messages = new ArrayList<>();

    
    @Override
    public ArrayList getAllMessages() {
	return this.messages;
    }
    
    //_________________________________________________________________________//
    
    @Override
    public Message removeMessageById(int id) {
	for(int i =0 ; i <this.messages.size();i++) {
		if (this.messages.get(i).getId()== id) {
			this.messages.remove(this.messages.get(i));
			return this.messages.get(i);
		}
            }
	return null;
    }
    
    //__________________________________________________________________________//
    
    @Override
    public Message getMessageById(int id) {
	for(int i =0 ; i <this.messages.size();i++) {
		if (this.messages.get(i).getId()== id) {
			return this.messages.get(i);
		}
            }
	return null;
    }
    
    //__________________________________________________________________________//

    @Override
    public void addMessage(Message message) {
        
	this.messages.add(message);
    }

    
}
