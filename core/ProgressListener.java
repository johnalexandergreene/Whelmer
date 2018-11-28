package org.fleen.whelmer.core;

public interface ProgressListener{
  
  void incremented(Whelmer whelmer);
  
  void finished(Whelmer whelmer);

}
