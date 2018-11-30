package org.fleen.whelmer.core;

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
   * the value of whelmer.getTime() when this ring was created.
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
   * 
   * This is one of the 3 important functions that characterize this ring, defining its behavior
   */
  public abstract boolean destroyMe(); 
  
  /*
   * ################################
   * VALUE
   * ################################
   */
  
  /*
   * Get VALUE at the specified distance.
   *  
   * By distance we mean the distance of a cell from the center of the whelmer. 
   * That is, the distance from the center point of the cell square to the center point of the whelmer square.
   * 
   * So in calculating VALUE we consider
   *   cell distance
   *   ring age
   *   
   * VALUE is an abstract, general-purpose value in range [0,1] 
   * It can be translated into a color (H in HSB?) or sound (a base frequency?).
   * It can be blended with other ring values 
   * 
   * This is one of the 3 important functions that characterize this ring, defining its behavior
   */
  public abstract double getValue(double d);
  
  /*
   * ################################
   * INTENSITY
   * ################################
   */
  
  /*
   * Get INTENSITY at the specified distance.
   *  
   * By distance we mean the distance of a cell from the center of the whelmer. 
   * That is, the distance from the center point of the cell square to the center point of the whelmer square.
   * 
   * So in calculating INTENSITY we consider
   *   cell distance
   *   ring age
   *   
   * We're talking the INTENSITY of VALUE. Like a light. VALUE is the color and INTENSITY is the brightness. 
   * 
   * This is one of the 3 important functions that characterize this ring, defining its behavior
   */
  public abstract double getIntensity(double d);
  
  /*
   * ################################
   * PRESENCE
   * ################################
   */
  
  public RingPresence getPresence(Cell cell){
    RingPresence p=new RingPresence(this,getValue(cell.distance),getIntensity(cell.distance));
    return p;}
  
}
