/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lowlevel.comboCM211;

import edu.agents.common.thirdConveyor.StorageConveyor;

/**
 *
 * @author user
 */
public class FinalStationSystem {
    /*add here all the other objects of the other groups */ 
     private StorageConveyor storageConveyor = new StorageConveyor();
    /*add also a get- and a aset-function for each object.*/
     public void setStorageConveyor(StorageConveyor storageConveyor1) {
         this.storageConveyor = storageConveyor1;
     }
     public StorageConveyor getStorageConveyor(){
     return this.storageConveyor;
     }
     
    private static FinalStationSystem instance = new FinalStationSystem();
   /*Figure out the correct IP address and output port  */ 
    
    private final GenericCombo211Library combo = 
            new GenericCombo211Library(".....",50000);

    private FinalStationSystem(){
        storageConveyor.setCombo(combo);
    }

    public static FinalStationSystem getInstance (){
    return instance ;}
}
