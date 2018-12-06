package org.fleen.whelmer.core.ring;

import org.fleen.whelmer.core.Whelmer;

/*
 * this ring is shaped like a hill of sine wave. Nice tapered edges and a hump in the middle.
 * delta is 0 at the edges and basedelta at the middle
 * front and back edges move at the same speed
 */
public class Ring_Simple_Sine extends Ring_Simple{

  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Ring_Simple_Sine(
    Whelmer whelmer,boolean direction,double speed,
    double thickness,double basedelta){
    super(whelmer,direction,speed,thickness);
    this.basedelta=basedelta;}
  
  /*
   * ################################
   * DELTA
   * ################################
   */
  
  double basedelta;
  
  public double getDelta(double distance){
    if(distance<getOuterEdge()&&distance>getInnerEdge()){
      double a=getOuterEdge()-getInnerEdge();
      double b=(distance-getInnerEdge())/a;
      double c=(b*Math.PI*2)+(3.0*Math.PI/2);
      double d=(Math.sin(c)+1)/2;
      return basedelta*d;
    }else{
      return 0;}}

}
