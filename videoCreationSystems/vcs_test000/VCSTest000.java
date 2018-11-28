package org.fleen.whelmer.videoCreationSystems.vcs_test000;

import org.fleen.whelmer.core.ProgressListener;
import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.videoCreationSystems.UI;

public class VCSTest000{
  
  public static final int 
    SIZE=720,
    DURATION=6000;
  
  private static UI ui;
  
  private static final String WORKINGDIR="/home/john/Desktop/cpexport"; 
  
  private static ProgressListener listener=new ProgressListener(){
    public void timeIncremented(Whelmer whelmer){
      ui.repaint();}};
  
  /*
   * new VideoExporter0()
   * 
   * 
   */
  public static final void main(String[] a){
    Whelmer cp=new Whelmer(
      SIZE,DURATION,
      new StripeGenerator0(),
      WORKINGDIR,
      new VideoRenderer0(),new VideoExporter0(),
      new AudioRenderer1(),new AudioExporter0(),
      listener);
    ui=new UI(cp);
    cp.run();}

}
