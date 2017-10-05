package edu.agents.common.thirdConveyor;
import edu.lowlevel.comboCM211.StationComponent;

/**
 *
 * @author DaZi20
 */
public class StorageConveyor extends StationComponent {
     /** 
     General control functions for conveyor belt with two pushers
     * given by PLCPinDescription.pdf **/ 
   
    
    public void startStorageConveyor(){
         combo.setValue_PIN_31(true);
    }
    
    public void stopStorageConveyor(){
         combo.setValue_PIN_31(false);
    }
    public void extendPusher1(){
         combo.setValue_PIN_33(true);
    
    }
    
    public void extendPusher2(){
         combo.setValue_PIN_35(true);
    
    }
    
    public void retractPusher1(){
         combo.setValue_PIN_34(true);
    
    }
    public void retractPusher2(){
         combo.setValue_PIN_36(true);
    
    }
    public void stopPusher1(){
         combo.setValue_PIN_33(false);
         combo.setValue_PIN_34(false);
         
    }
    
    public void stopPusher2(){
         combo.setValue_PIN_35(false);
        combo.setValue_PIN_36(false);
    
    }
    
    public boolean pusher1Extended(){
        return combo.isValue_PIN_20(); 
    }
    
    public boolean pusher1Retracted(){
        return combo.isValue_PIN_21(); 
    }
    
    public boolean pusher1Engaged(){
        return combo.isValue_PIN_22(); 
    }
    
    public boolean pusher2Extended(){
        return combo.isValue_PIN_23(); 
    }
    
    
    public boolean pusher2Retracted(){
        return combo.isValue_PIN_24(); 
    }
    
    public boolean pusher2Engaged(){
        return combo.isValue_PIN_25(); 
    }
    
    public boolean storage1Engaged(){
        return combo.isValue_PIN_26(); 
    }
    
    public boolean storage2Engaged(){
        return combo.isValue_PIN_27(); 
    }
    /**
     *Main function to proceed the whole object-storing process
     *A moving conveyor belt (performed from an other main mehtod ) 
     *is required ( startConveyor(); **/ 
    public void checkFreeStorage(){
    if(storage2Engaged()) {
        if(storage1Engaged()){ 
        /** in case of all storages are occupied:  
         * stop conveyor, throw the package away, whatever**/ 
        }
        else {
        moveToPusher1();}
    }else {
        moveToPusher2();}
    }
    
    /**Wait until object reaches Storage1,than proceed the storing process  **/ 
    public void moveToPusher1(){
       while (!pusher1Engaged()) { 
           /* wait while conveyor is moving object to first Stacker
           should be solved bether than in a while loop -> periodic timer, async thread */
        }
   //     if(pusher1Engaged()) {
            stopStorageConveyor();
     /*       while(!pusher1Extended()){
                extendPusher1();
            }
            stopPusher1();
            sleep(1000);
            while(!pusher1Retracted()){
                retractPusher1(); 
            }
      //  } */
    }
    
    
    /**Wait until object reaches Storage2,than proceed the storing process  **/
    public void moveToPusher2(){
       while (!pusher2Engaged()) { 
           /* wait while conveyor is moving object to seccond Stacker
           should be solved bether than in a while loop -> periodic timer, async thread */
        }
   //     if(pusher1Engaged()) {
            stopStorageConveyor();
       /*     while(!pusher2Extended()){
                extendPusher2();
            }
            stopPusher2();
            sleep(1000);
            while(!pusher2Retracted()){
                retractPusher2();
            }
            
      //  }
         */  
    }
    
    
    
    
    
    
    
}
