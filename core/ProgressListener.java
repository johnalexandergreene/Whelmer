package org.fleen.whelmer.core;

public interface ProgressListener{
  
  void timeIncremented(Whelmer whelmer);
  
  void finished(Whelmer whelmer);

}
