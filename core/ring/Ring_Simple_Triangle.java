package org.fleen.whelmer.core.ring;

import org.fleen.whelmer.core.Whelmer;

/*
 * a simple ring with a triangular crossection
 */
public class Ring_Simple_Triangle extends Ring_Simple{

  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Ring_Simple_Triangle(
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
  
  public double getDelta(double d){
    double a=(getOuterEdge()+getInnerEdge())/2;
    double b=Math.abs(d-a);
    double z=thickness/2;
    double c=(z-b)/z;
    if(d<getOuterEdge()&&d>getInnerEdge())
      return basedelta*c;
    else
      return 0;}

}
