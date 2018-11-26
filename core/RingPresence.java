package org.fleen.whelmer.core;

public interface RingPresence{
  
  Ring getRing();
  
  /*
   * range 0 (not even touching) to 1 (total nonfadey coverage)
   */
  double getIntensity();

}
