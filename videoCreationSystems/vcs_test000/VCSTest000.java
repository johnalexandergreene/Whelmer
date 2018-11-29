package org.fleen.whelmer.videoCreationSystems.vcs_test000;

import java.io.File;

import org.fleen.whelmer.core.ProgressListener;
import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.videoCreationSystems.UI;

public class VCSTest000{
  
  public static final int 
    SIZE=720,
    DURATION=100;
  
  private static UI ui;
  
  private static final String WORKINGDIR="/home/john/Desktop/whelmerexport"; 
  
  private static ProgressListener listener=new ProgressListener(){
    
    public void timeIncremented(Whelmer whelmer){
      ui.repaint();}
    
    public void finished(Whelmer whelmer){
      System.out.println("finished");
    }};
  
  public static final void main(String[] a){
    Whelmer w=new Whelmer0(
      SIZE,DURATION,new Rings0(),
      listener,new File(WORKINGDIR),
      new VideoRenderer0(),null,
      new AudioRenderer0(),null
      );
    ui=new UI(w);
    w.run();}

}
