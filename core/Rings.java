package org.fleen.whelmer.core;

import java.util.List;

/*
 * a collection of rings
 * logic for creating and destroying rings
 * ring access
 */
public interface Rings{
  
  void setWhelmer(Whelmer whelmer);
  
  /*
   * create 0..n rings
   */
  void conditionallyCreateRings();
  
  /*
   * destroy 0..n rings
   */
  void conditionallyDestroyRings();
  
  List<Ring> getRings();

}
