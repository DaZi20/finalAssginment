/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.agents.common;

import java.io.Serializable;

/**
 *
 * @author luiri60
 */
public final class ExecutionRequest extends Request implements Serializable {

    private final int argument;

    public ExecutionRequest(int argument) {
        this.argument = argument;
    }
   
    public int getArgument() {
        return argument;
    }

}
