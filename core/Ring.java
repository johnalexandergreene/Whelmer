package org.fleen.whelmer.core;

public interface Ring{
  
  /*
   * the whelmer of which this ring is a component
   */
  Whelmer getWhelmer();

  /*
   * the inner edge
   * a radius, in terms of whelmer radius
   * the inner edge radius is always less than the outer edge radius
   */
  double getInnerEdge();
  
  /*
   * the outer edge
   * a radius, in terms of whelmer radius
   * the outer edge radius is always greater than the inner edge radius
   */
  double getOuterEdge();

  /*
   * the distance from the inner edge to the outer edge 
   * thickness is always >= innerfade+outerfade
   */
  double getThickness();
  
  /*
   * distance over which the outer edge fades (to 0 at exact outer radius)
   * an interval, in terms of whelmer radius
   */
  double getOuterFade(); //distance over which the edge fades
  
  /*
   * distance over which the inner edge fades (to 0 at exact inner radius)
   * an interval, in terms of whelmer radius
   */
  double getInnerFade();
  
  /*
   * change of outer radius per time interval. 
   * Positive speed means movement outward from center. Can be negative.
   */
  double getOuterSpeed();
  
  /*
   * change of inner radius per time interval. 
   * Positive speed means movement outward from center. Can be negative.
   */
  double getInnerSpeed();
  
  /*
   * the value of whelmer.getTime() when this ring was created.
   */
  int getBirthday();
  
  /*
   * at some point a ring gets destroyed. 
   * Maybe it passes outside the geometry of the whelmer or something.... 
   * At that point we might signal that we are ready to be discarded from the whelmer system.
   */
  boolean killMe(); 
  
  /*
   * an abstract value in range 0<=n<1 distinguishing this ring. 
   * It can be translated into a color (H in HSB?) or sound (a base frequency?).
   * It can be blended with other ring values to create a group value 
   */
  double getValue();   
  
}
