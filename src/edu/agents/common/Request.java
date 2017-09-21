/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.agents.common;

import jade.lang.acl.ACLMessage;
import java.io.Serializable;

/**
 *
 * @author luiri60
 */
public abstract class Request implements Serializable {

    private ACLMessage originalMessage = null;
   
    public ACLMessage getOriginalMessage() {
        return originalMessage;
    }

    public void setOriginalMessage(ACLMessage originalMessage) {
        this.originalMessage = originalMessage;
    }
    
    

}
