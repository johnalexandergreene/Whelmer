package org.fleen.whelmer.whelmerVideoCreationSystems.w_test018_periodic_asymmetric_2_2_strobe_veryverynice;

import java.util.ArrayList;
import java.util.List;

import org.fleen.whelmer.core.AudioRenderer;
import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.core.ring.Ring;

/*
 * get sound for each ring
 * average it
 */
public class AudioRenderer0 implements AudioRenderer{
  
  public int[] renderAudioFrame(Whelmer whelmer){
    //get metrics
    int soundpiecelength=whelmer.getAudioSampleRatePerFrame();
    //get all ring sounds
    List<int[]> ringsounds=new ArrayList<int[]>();
    for(Ring ring:whelmer.controller)
      ringsounds.add(getRingSound(ring,soundpiecelength));
    //get averaged sound array
    int[] totalsound=new int[soundpiecelength];
//    int a;
//    for(int i=0;i<soundpiecelength;i++){
//      a=0;
//      for(int[] ringsound:ringsounds)
//        a+=ringsound[i];
//      a/=ringsounds.size();
//      totalsound[i]=a;}
    
    //TEST
    totalsound=getRingSound(null,soundpiecelength);
    
    
    
    //
    return totalsound;}
  
//  static final double MAXAMPLITUDE=32768;
  static final double MAXAMPLITUDE=16000;
  
  /*
   * make a hunk of sine wave
   * start and end at 0 for pop reduction
   * remember, the length of this piece of sound is 1/60 of a second, so even a single sine wave is gonna make a nice tone
   */
  int[] getRingSound(Ring ring,int soundpiecelength){
    int[] sound=new int[soundpiecelength];
    double a;
    for(int i=0;i<soundpiecelength;i++){
      a=((double)i)/((double)soundpiecelength);
      a=a*Math.PI*2;
      sound[i]=(int)(Math.sin(a)*MAXAMPLITUDE);}
    return sound;}

}
