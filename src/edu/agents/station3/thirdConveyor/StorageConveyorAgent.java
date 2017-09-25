/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.agents.station3.thirdConveyor;

import edu.agents.common.TMPS35Agent;
import edu.lowlevel.comboCM211.FinalStationSystem;
import jade.core.Agent;

/**
 *
 * @author DaZi20
 */
public class StorageConveyorAgent extends TMPS35Agent{
    public StorageConveyor storageConveyor;
    
    
@Override
    protected void setup(){
    super.setup();
    storageConveyor = FinalStationSystem.getInstance().getStorageConveyor();
    // why static =?
    addBehaviour(new StorageConveyorExecutionProcess());
}
    
public StorageConveyor getStorageConveyor(){
    return storageConveyor;
}

    
    
}
