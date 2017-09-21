/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.agents.common;

import jade.util.leap.Serializable;

/**
 *
 * @author luiri60
 */
public final class TransportRequest extends Request implements Serializable {

    private final String from;
    private final String to;

    public TransportRequest(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

}
