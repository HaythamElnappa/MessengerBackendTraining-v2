
package com.mycompany.messengerbackend;

import java.util.ArrayList;


public class RunTimeMesseageRepository extends MesseageRepository {
    
    
    private ArrayList<Message> messages = new ArrayList<>();

    
    @Override
    public ArrayList getAllMessages() {
	return messages;
    }
    
    //_________________________________________________________________________//
    
    @Override
    public boolean removeMessage(String id) {
	for(int i =0 ; i <messages.size();i++) {
		if (messages.get(i).getId()== id) {
			messages.remove(this.messages.get(i));
			return true;
		}
            }
	return false;
    }
    
    //__________________________________________________________________________//
    
    @Override
    public Message getMessageById(String id) {
	for(int i =0 ; i <messages.size();i++) {
		if (messages.get(i).getId()== id) {
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
