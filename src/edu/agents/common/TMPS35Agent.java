/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.agents.common;

import jade.core.Agent;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author luiri60
 */
public class TMPS35Agent extends Agent{
    
    private final List<Object> requests = new LinkedList<>();

    public List<Object> getRequests() {
        return requests;
    }                            
    
}
