package org.fleen.whelmer.core;

public class RingPresence{
  
  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public RingPresence(Ring ring,double value,double intensity){
    this.ring=ring;
    this.value=value;
    this.intensity=intensity;}
  
  /*
   * ################################
   * PARAMS
   * ################################
   */
  
  public Ring ring;
  
  /*
   * range [0,1]
   */
  public double value,intensity;

}
