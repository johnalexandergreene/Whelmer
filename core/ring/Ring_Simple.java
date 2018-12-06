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
    FORWARD=true,
    BACKWARD=false;
  
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
   * ################################
   */
  
  public double thickness;
  
  /*
   * ################################
   * DESTROY ME
   * ################################
   */
  
  public boolean destroyMe(){
    if(direction==FORWARD)
      return getInnerEdge()>1;
    else
      return getOuterEdge()<0;}
  
  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  double getOuterEdge(){
    double a;
    if(direction==FORWARD)
      a=speed*((double)getAge());
    else//direction=BACKWARD
      a=(1.0+thickness)-(speed*((double)getAge()));
    return a;}
  
  double getInnerEdge(){
    double a=getOuterEdge()-thickness;
    return a;}
  
}
