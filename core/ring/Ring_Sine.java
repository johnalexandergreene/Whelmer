package org.fleen.whelmer.core.ring;

import org.fleen.whelmer.core.Whelmer;

/*
 * this ring is shaped like a half cycle of sine wave
 * delta is 0 at the edges and basedelta at the middle
 * front and back edges move at the same speed
 */
public abstract class Ring_Sine extends Ring{
  
  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Ring_Sine(Whelmer whelmer,double thickness,double speed,double basedelta){
    super(whelmer);
    this.thickness=thickness;
    this.speed=speed;
    this.basedelta=basedelta;}

  /*
   * ################################
   * THICKNESS
   * ################################
   */
  
  public double thickness;
  
  /*
   * ################################
   * SPEED
   * ################################
   */
  
  public double speed;
  
  /*
   * ################################
   * DELTA
   * ################################
   */
  
  double basedelta;
  
  public double getDelta(double d){
    double 
      fe=getFrontEdge(),
      be=getBackEdge();
    
    
    
//    double a=(getFrontEdge()+getBackEdge())/2;
//    double b=Math.abs(d-a);
//    double z=thickness/2;
//    double c=(z-b)/z;
//    if(d<getFrontEdge()&&d>getBackEdge())
//      return basedelta*c;
//    else
//      return 0;}
    
  }
  
  /*
   * ################################
   * DESTROY ME
   * ################################
   */
  
  public abstract boolean destroyMe();
  
  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  public abstract double getFrontEdge();
  
  public double getBackEdge(){
    double a=getFrontEdge()-thickness;
    return a;}

}
