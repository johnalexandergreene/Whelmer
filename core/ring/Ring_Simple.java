package org.fleen.whelmer.core.ring;

import org.fleen.whelmer.core.Whelmer;

public abstract class Ring_Simple implements Ring{
  
  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
 
  public Ring_Simple(Whelmer whelmer,boolean direction,double speed,double thickness){
    this.whelmer=whelmer;
    birthday=whelmer.time;
    this.direction=direction;
    this.speed=speed;
    this.thickness=thickness;}
  
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
   * DIRECTION
   * ################################
   */
  
  public static final boolean 
    OUTWARD=true,
    INWARD=false;
  
  public boolean direction;
  
  /*
   * ################################
   * SPEED
   * ################################
   */
  
  public double speed;
  
  /*
   * ################################
   * THICKNESS
   * in terms of the whelmer span/2
   * ################################
   */
  
  public double thickness;
  
  /*
   * ################################
   * DESTROY ME
   * ################################
   */
  
  public boolean destroyMe(){
    if(direction==OUTWARD)
      return getInnerEdge()>1;
    else
      return getOuterEdge()<0;}
  
  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  public double getOuterEdge(){
    double a;
    if(direction==OUTWARD)
      a=speed*((double)getAge());
    else//direction=BACKWARD
      a=(1.0+thickness)-(speed*((double)getAge()));
    return a;}
  
  public double getInnerEdge(){
    double a=getOuterEdge()-thickness;
    return a;}
  
}
