/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lowlevel.comboCM211;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DaZi20
 */
public abstract class StationComponent {
    
    protected GenericCombo211Library combo;
    
    public void sleep (int millis){
        try{
            Thread.sleep(millis);
        }
        catch (InterruptedException ex ) {
            Logger.getLogger(StationComponent.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void setCombo(GenericCombo211Library combo){
        this.combo= combo;
    }
}

    

