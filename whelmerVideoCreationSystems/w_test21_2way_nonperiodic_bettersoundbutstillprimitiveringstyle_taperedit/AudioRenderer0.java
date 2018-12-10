package org.fleen.whelmer.whelmerVideoCreationSystems.w_test21_2way_nonperiodic_bettersoundbutstillprimitiveringstyle_taperedit;

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
    for(Ring ring:whelmer.rings)
      ringsounds.add(getRingSound(ring,soundpiecelength));
    //get averaged sound array
    int[] totalsound=new int[soundpiecelength];
    if(whelmer.rings.isEmpty())return totalsound;
    int a;
    for(int i=0;i<soundpiecelength;i++){
      a=0;
      for(int[] ringsound:ringsounds)
        a+=ringsound[i];
      a/=ringsounds.size();
      totalsound[i]=a;}
    //
    return totalsound;}
  
  //apparently 32768 is too high. It makes a harsh clipping. so this works fine.
  static final double MAXAMPLITUDE=30000;
  
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
      a=a*Math.PI*2*getFrequencyFactor(ring);
      sound[i]=(int)(Math.sin(a)*MAXAMPLITUDE*getVolumeFactor(ring));}
    return sound;}
  
  static final double BASEFREQUENCYFACTOR=16;
  
  private double getFrequencyFactor(Ring ring){
    double f=ring.getOuterEdge()*BASEFREQUENCYFACTOR;
    return f;}
  
  /*
   * max in the middle and tapered on the ends
   */
  private double getVolumeFactor(Ring ring){
    double ringmidline=(ring.getOuterEdge()-ring.getInnerEdge())/2;
    if(ringmidline<0)ringmidline=0;
    if(ringmidline>1)ringmidline=1;
    double closenesstocenter=(0.5-(Math.abs(0.5-ringmidline)))*2;
//    System.out.println("closenesstocenter="+closenesstocenter);
    double curved=closenesstocenter*closenesstocenter;
    return curved;
    
    
  }
  
  //60 hz
//  int[] getRingSound(Ring ring,int soundpiecelength){
//    int[] sound=new int[soundpiecelength];
//    double a;
//    for(int i=0;i<soundpiecelength;i++){
//      a=((double)i)/((double)soundpiecelength);
//      a=a*Math.PI*2;
//      sound[i]=(int)(Math.sin(a)*MAXAMPLITUDE);}
//    return sound;}

}
