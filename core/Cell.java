package org.fleen.whelmer.core;

import java.util.ArrayList;
import java.util.List;

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
   * PRESENCES
   * ################################
   */
  
  /*
   * look at every ring in the whelmer and get its presence value at this cell
   */
  public List<RingPresence> getPresences(Whelmer whelmer){
    List<RingPresence> p=new ArrayList<RingPresence>();
    for(Ring r:whelmer.rings)
      p.add(r.getPresence(this));
    return p;}

}
