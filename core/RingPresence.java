package org.fleen.whelmer.core;

public class RingPresence{
  
  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public RingPresence(Ring ring,double delta){
    this.ring=ring;
    this.delta=delta;}
  
  /*
   * ################################
   * PARAMS
   * ################################
   */
  
  public Ring ring;
  
  /*
   * range [0,1]
   */
  public double delta;

}
