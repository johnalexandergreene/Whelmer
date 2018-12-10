package org.fleen.whelmer.whelmerVideoCreationSystems.w_test25_asymmetric_periodic;

import java.util.ArrayList;
import java.util.List;

import org.fleen.whelmer.core.AudioRenderer;
import org.fleen.whelmer.core.Cell;
import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.core.ring.Ring;

/*
 * sample a strip of cells extending from the center of the cell field to the edge
 * this is a good representation of the whole cell field
 * use this to derive sound
 * 
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
    //get cell sounds
    //sample cells in strip extending from center to edge of cell array
    List<Cell> samplestrip=getSampleStrip(whelmer);
    List<int[]> cellsounds=new ArrayList<int[]>();
    for(Cell c:samplestrip)
      cellsounds.add(getCellSound(c,soundpiecelength,whelmer));
    //get averaged cell sounds
    int[] totalsound=new int[soundpiecelength];
    int a;
    for(int i=0;i<soundpiecelength;i++){
      a=0;
      for(int[] cellsound:cellsounds)
        a+=cellsound[i];
      a/=cellsounds.size();
      totalsound[i]=a;}
    //
    return totalsound;}
  
  List<Cell> samplestrip=null;
  
  List<Cell> getSampleStrip(Whelmer whelmer){
    if(samplestrip==null)gleanSampleStrip(whelmer);
    return samplestrip;}
  
  void gleanSampleStrip(Whelmer whelmer){
    samplestrip=new ArrayList<Cell>();
    int 
      x=whelmer.size/2,
      y=x;
    Cell c;
    for(;x<whelmer.size-1;x++){
      c=whelmer.cells[x][y];
      samplestrip.add(c);}}
  
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
  
  static final double BASEFREQUENCYFACTOR=256;
  static final double CELLDELTACAP=6.0;
  
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
