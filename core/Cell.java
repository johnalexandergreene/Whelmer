package org.fleen.whelmer.core;

public class Cell{
  
  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Cell(double distance){
    this.distance=distance;}
  
  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  //distance of this cell from from whelmer center in terms of whelmer radius (ie span/2), range [0,1]
  public double distance;
  
  /*
   * ################################
   * GET DELTA
   * ################################
   */
  
  /*
   * The delta is the sum of ring deltas at this cell
   */
  public double getDelta(Whelmer whelmer){
    double delta=0;
    for(Ring ring:whelmer.rings)
      delta+=ring.getDelta(distance);
    return delta;}

}
