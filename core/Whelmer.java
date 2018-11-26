package org.fleen.whelmer.core;

import java.util.List;

public interface Whelmer{
  
  /*
   * the visual and logical edge of this system. 
   * rings that pass beyond it tend to disappear or something.
   */
  double getMaxRadius(); 
  
  int getTime();
  
  void incrementTime();
  
  List<Ring> getRings();
  
  /*
   * a 2d array of cells. 
   * each cell of the system holds the presence of the background and any Rings that touch that cell.
   * at a cell, the background only manifests to the degree 1.0-sum_of_all_ring_presences. 
   * So if there are enough rings present then the background is completely hidden.
   */
  Cell[][] getState(); 
  
} 
