package org.fleen.whelmer.core.ring;

public interface Ring{
  
  /*
   * ring geometry
   */
  
  double getInnerEdge();
  
  double getOuterEdge();
  
  /*
   * Get DELTA at the specified distance.
   *  
   * By distance we mean the distance of a cell from the center of the whelmer. 
   * That is, the distance from the center point of the cell square to the center point of the whelmer square.
   * 
   * So in calculating DELTA we consider
   *   cell distance
   *   ring age
   *   
   * DELTA is an abstract, general-purpose value in range [0,1] 
   * It can be translated into a color (H in HSB?) or sound (a base frequency?).
   * It can be blended with other ring values 
   */
  double getDelta(double distance);
  
  /*
   * signals that the ring is done dancing and it's time to remove it from the stage
   */
  boolean destroyMe();

}
