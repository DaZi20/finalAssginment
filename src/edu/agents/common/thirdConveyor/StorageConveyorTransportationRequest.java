/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.agents.common.thirdConveyor;

import edu.agents.common.ReceiveMessages;
import jade.core.behaviours.CyclicBehaviour;
import edu.agents.common.TransportRequest;
import edu.agents.common.Vocabulary;
import edu.lowlevel.comboCM211.FinalStationSystem;

import edu.lowlevel.comboCM211.FinalStationSystem;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author user
 */
public class StorageConveyorTransportationRequest extends CyclicBehaviour{

    /**Setting for the superordinate agent to identify if the conveyor is working right now 
     or if it is waiting for a new task **/
    private boolean isBussy = false;
    public void setIsBussy(boolean bussy){isBussy = bussy;}
    public boolean getIsBussy (){return isBussy;}
    
    
    /**Enable messaging **/
    @Override 
    public void onStart(){
    myAgent.addBehaviour(
                new ReceiveMessages(ReceiveMessages.TRANSPORT_REQUEST));
    }
    
    @Override
    public void action() {
    
    if (!((StorageConveyorAgent)myAgent).getRequests().isEmpty()){
            TransportRequest transportRequest =(TransportRequest) ((StorageConveyorAgent)myAgent).getRequests().remove(0);
            ACLMessage reply = transportRequest.getOriginalMessage().createReply();
            String from = transportRequest.getFrom();
            String to = transportRequest.getTo();
       
            if (from.equalsIgnoreCase(Vocabulary.STORAGE_CONVEYOR_INPUT)&& to.equalsIgnoreCase(Vocabulary.PUSHER_1)){
                ((StorageConveyorAgent)myAgent).getStorageConveyor().moveToPusher1();
                setIsBussy(true);
                reply.setPerformative(ACLMessage.INFORM);
                reply.setContent(to);
            } else
                if (from.equalsIgnoreCase(Vocabulary.STORAGE_CONVEYOR_INPUT) && to.equalsIgnoreCase(Vocabulary.PUSHER_2)){
                ((StorageConveyorAgent)myAgent).getStorageConveyor().moveToPusher2();
                setIsBussy(true);
                reply.setPerformative(ACLMessage.INFORM);
                reply.setContent(to);
                }
        }
    }
    
}
