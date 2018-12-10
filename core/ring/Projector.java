package org.fleen.whelmer.core.ring;

import java.util.Iterator;

import org.fleen.whelmer.core.Whelmer;

/*
 * manages stuff that gets projected upon whelmer cells
 *   so far that stuff consists of a system of moving rings and a strobe
 * 
 * rings
 *   a collection of rings
 *   logic for creating and destroying rings
 *   ring access
 *   
 * strobe
 *   some kind of strobe function
 */
public interface Projector{
 
  /*
   * ################################
   * WHELMER
   * ################################
   */
  
  void setWhelmer(Whelmer whelmer);
  
  Whelmer getWhelmer();
  
  /*
   * ################################
   * RINGS
   * ################################
   */
  
  int getRingCount();
  
  Iterator<Ring> getRingIterator();
  
  /*
   * create 0..n rings
   */
  void conditionallyCreateRings();
  
  /*
   * destroy 0..n rings
   */
  void conditionallyDestroyRings();
  
  /*
   * ################################
   * STROBE
   * ################################
   */
  
  /*
   * returns a strobe value, applied to all cells in the whelmer
   * a value in range [0,1]
   * translates to distance on the renderer palette and/or whatever
   */
  double getStrobe();
  
  /*
   * ################################
   * DELTA
   * ################################
   */
  
  /*
   * r is the radius value of a strobe
   * returns a value derived from the compounded influence of the rings and strobe 
   */
  double getDelta(double r);

}
