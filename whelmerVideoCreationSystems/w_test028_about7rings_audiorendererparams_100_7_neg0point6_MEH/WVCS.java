package org.fleen.whelmer.whelmerVideoCreationSystems.w_test028_about7rings_audiorendererparams_100_7_neg0point6_MEH;

import java.io.File;

import org.fleen.whelmer.core.AudioExporter0;
import org.fleen.whelmer.core.ProgressListener;
import org.fleen.whelmer.core.VideoExporter;
import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.whelmerVideoCreationSystems.UI;

public class WVCS{
  
  public static final int 
    SIZE=720,
    DURATION=3600;
  
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
      SIZE,DURATION,new Projector1(),
      listener,new File(WORKINGDIR),
      new VideoRenderer1(),new VideoExporter(),
      new AudioRenderer0(),new AudioExporter0()
      );
    ui=new UI(w);
    w.run();}

}
