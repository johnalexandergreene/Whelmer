package org.fleen.whelmer.core.ring;

import java.util.List;

import org.fleen.whelmer.core.Whelmer;

/*
 * ring manager
 * a collection of rings
 * logic for creating and destroying rings
 * ring access
 */
public interface Rings extends List<Ring_Simple>{
 
  void setWhelmer(Whelmer whelmer);
  
  Whelmer getWhelmer();
  
  /*
   * create 0..n rings
   */
  void conditionallyCreateRings();
  
  /*
   * destroy 0..n rings
   */
  void conditionallyDestroyRings();

}
