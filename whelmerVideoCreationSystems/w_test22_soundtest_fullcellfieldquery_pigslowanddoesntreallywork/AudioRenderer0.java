package org.fleen.whelmer.whelmerVideoCreationSystems.w_test22_soundtest_fullcellfieldquery_pigslowanddoesntreallywork;

import java.util.ArrayList;
import java.util.List;

import org.fleen.whelmer.core.AudioRenderer;
import org.fleen.whelmer.core.Cell;
import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.core.ring.Ring;

/*
 * get sound for each cell
 *   delta is frequency
 *   closeness to whelmer center-ring is volume
 * average them?
 *   but that would attenuate stuff
 *   maybe we should do weighted average
 *   
 */
public class AudioRenderer0 implements AudioRenderer{
  
  public int[] renderAudioFrame(Whelmer whelmer){
    //get metrics
    int soundpiecelength=whelmer.getAudioSampleRatePerFrame();
    //get all cell sounds
    List<int[]> cellsounds=new ArrayList<int[]>();
    for(int x=0;x<whelmer.size;x++)
      for(int y=0;y<whelmer.size;y++)
        cellsounds.add(getCellSound(whelmer.cells[x][y],soundpiecelength,whelmer));
    //get averaged sound array
    int[] totalsound=new int[soundpiecelength];
    if(whelmer.rings.isEmpty())return totalsound;
    int a;
    for(int i=0;i<soundpiecelength;i++){
      a=0;
      for(int[] cellsound:cellsounds)
        a+=cellsound[i];
      a/=cellsounds.size();
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
  int[] getCellSound(Cell cell,int soundpiecelength,Whelmer whelmer){
    int[] sound=new int[soundpiecelength];
    double a;
    for(int i=0;i<soundpiecelength;i++){
      a=((double)i)/((double)soundpiecelength);
      a=a*Math.PI*2*getFrequencyFactor(cell,whelmer);
      sound[i]=(int)(Math.sin(a)*MAXAMPLITUDE*getVolumeFactor(cell));}
    return sound;}
  
  static final double BASEFREQUENCYFACTOR=16;
  static final double CELLDELTACAP=12.0;
  
  private double getFrequencyFactor(Cell cell,Whelmer whelmer){
    double d=cell.getDelta(whelmer);
    d=((d%CELLDELTACAP)/CELLDELTACAP)*BASEFREQUENCYFACTOR;
    return d;}
  
  /*
   * valoume=closeness to whelmer center ring radius 0.5
   */
  private double getVolumeFactor(Cell cell){
    if(cell.distance<0||cell.distance>1.0)return 0;
    double closeness=(0.5-(Math.abs(0.5-cell.distance)))*2;
    return closeness;
    
    
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
