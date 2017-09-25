/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.agents.station3.thirdConveyor;

import edu.agents.common.ExecutionRequest;
import edu.agents.common.ReceiveMessages;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author DaZi20
 */
public class StorageConveyorExecutionProcess extends CyclicBehaviour{

     public void onStart(){
        myAgent.addBehaviour(
                new ReceiveMessages(ReceiveMessages.EXECUTION_REQUEST));
    }
    
    @Override
    public void action() {
        
        
     if(!((StorageConveyorAgent)myAgent).getRequests().isEmpty()) {
        ExecutionRequest executionRequest = (ExecutionRequest) 
            ((StorageConveyorAgent)myAgent).getRequests().remove(0);
        ACLMessage aclMessage = executionRequest.getOriginalMessage().createReply();
    
        try{
        
            ((StorageConveyorAgent)myAgent). getStorageConveyor().checkFreeStorage();
        }
        catch (Exception e ) {
        aclMessage.setPerformative(ACLMessage.INFORM); // maybe failure
                aclMessage.setContent(String.valueOf(false));
        myAgent.send(aclMessage);
                return;
                
        
        }
        
        aclMessage.setPerformative(ACLMessage.INFORM);
        aclMessage.setContent(String.valueOf(true));
        myAgent.send(aclMessage);
     }
     block(500); // why block ????? 
    }
    
}
