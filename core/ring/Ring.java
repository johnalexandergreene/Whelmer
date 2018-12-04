package org.fleen.whelmer.core.ring;

import org.fleen.whelmer.core.Whelmer;

public abstract class Ring{
  
  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
 
  public Ring(Whelmer whelmer){
    this.whelmer=whelmer;
    birthday=whelmer.time;}
  
  /*
   * ################################
   * WHELMER
   * ################################
   */
  
  public Whelmer whelmer;
  
  /*
   * ################################
   * BIRTHDAY AND AGE
   * ################################
   */
  
  /*
   * the value of whelmer.time when this ring was created.
   */
  public int birthday;
  
  public int getAge(){
    return whelmer.time-birthday;}
  
  /*
   * ################################
   * DESTROY ME
   * ################################
   */
  
  /*
   * at some point a ring gets destroyed. 
   * Maybe it passes outside the geometry of the whelmer or something.... 
   * At that point we might signal that we are ready to be discarded from the whelmer system.
   */
  public abstract boolean destroyMe(); 
  
  /*
   * ################################
   * DELTA
   * ################################
   */
  
  /*
   * Get DELTA at the specified distance.
   *  
   * By distance we mean the distance of a cell from the center of the whelmer. 
   * That is, the distance from the center point of the cell square to the center point of the whelmer square.
   * 
   * So in calculating DELTA we consider
   *   cell distance
   *   ring age
   *   
   * DELTA is an abstract, general-purpose value in range [0,1] 
   * It can be translated into a color (H in HSB?) or sound (a base frequency?).
   * It can be blended with other ring values 
   */
  public abstract double getDelta(double d);
  
  /*
   * ################################
   * TODO
   * properly fleshed out ring logic
   * front edge speed, back edge speed
   * front edge fade, back edge fade
   * all fade...
   * etc
   * ################################
   */
  
}
