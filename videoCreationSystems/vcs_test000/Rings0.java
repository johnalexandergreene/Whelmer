package org.fleen.whelmer.videoCreationSystems.vcs_test000;

import java.util.ArrayList;

import org.fleen.whelmer.core.Ring;
import org.fleen.whelmer.core.Rings;
import org.fleen.whelmer.core.Whelmer;

@SuppressWarnings("serial")
public class Rings0 extends ArrayList<Ring> implements Rings{
  
  /*
   * ################################
   * WHELMER
   * ################################
   */
  
  Whelmer whelmer;
  
  public void setWhelmer(Whelmer whelmer){
    this.whelmer=whelmer;}
  
  public Whelmer getWhelmer(){
    return whelmer;}
  
  /*
   * ################################
   * CONDITIONALLY CREATE RINGS
   * ################################
   */
  
  public void conditionallyCreateRings(){
    if(isEmpty())
      add(new Ring0(whelmer));
    
  }

  /*
   * ################################
   * CONDITIONALLY DESTROY RINGS
   * ################################
   */
  
  public void conditionallyDestroyRings(){
    // TODO Auto-generated method stub
    
  }

}
