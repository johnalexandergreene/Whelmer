package org.fleen.whelmer.whelmerVideoCreationSystems.w_test012_2dpalettetest_integerpalettelayer_over_test009;

import java.io.File;

import org.fleen.whelmer.core.ProgressListener;
import org.fleen.whelmer.core.VideoExporter;
import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.whelmerVideoCreationSystems.UI;

public class VCS{
  
  public static final int 
    SIZE=720,
    DURATION=3000;
  
  private static UI ui;
  
  private static final String WORKINGDIR="/home/john/Desktop/whelmerexport"; 
  
  private static ProgressListener listener=new ProgressListener(){
    
    public void timeIncremented(Whelmer whelmer){
      ui.repaint();}
    
    public void finished(Whelmer whelmer){
      System.out.println("finished");
    }};
  
  public static final void main(String[] a){
    Whelmer w=new Whelmer(
      SIZE,DURATION,new Rings0(),
      listener,new File(WORKINGDIR),
      new VideoRenderer1(),new VideoExporter(),
      new AudioRenderer0(),null
      );
    ui=new UI(w);
    w.run();}

}
