/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.agents.common;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luiri60
 */
public class ReceiveMessages extends CyclicBehaviour {

    public static final int TRANSPORT_REQUEST = 0;
    public static final int EXECUTION_REQUEST = 1;
    

    private final int decodeAs;
    private MessageTemplate mt;

    public ReceiveMessages(int decodeAs) {
        this.decodeAs = decodeAs;
        switch(decodeAs){
            case TRANSPORT_REQUEST:
                mt = MessageTemplate.and(MessageTemplate.MatchOntology(Vocabulary.TRANSPORT),
                        MessageTemplate.MatchPerformative(ACLMessage.REQUEST));
                break;
            case EXECUTION_REQUEST:
                mt = MessageTemplate.and(MessageTemplate.MatchOntology(Vocabulary.EXECUTION),
                        MessageTemplate.MatchPerformative(ACLMessage.REQUEST));
                break;
        }
    }

    @Override
    public void action() {                
        ACLMessage request = myAgent.receive();
        if (request != null) {
            try {
                switch (decodeAs) {
                    case TRANSPORT_REQUEST:
                        TransportRequest transportReq = (TransportRequest) request.getContentObject();
                        transportReq.setOriginalMessage(request);
                        ((TMPS35Agent) myAgent).getRequests().add(transportReq);
                        break;
                    case EXECUTION_REQUEST:
                        ExecutionRequest execReq = (ExecutionRequest) request.getContentObject();
                        execReq.setOriginalMessage(request);
                        ((TMPS35Agent) myAgent).getRequests().add(execReq);
                        break;
                }

            } catch (UnreadableException ex) {
                Logger.getLogger(ReceiveMessages.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        block(500);
    }

}
