package org.fleen.whelmer.core;

import java.util.List;

public interface Cell{
  
  int getX();
  
  int getY();
  
  /*
   * look at every ring in the whelmer and get its presence value at this cell
   */
  List<RingPresence> getPresences(Whelmer whelmer);

}
