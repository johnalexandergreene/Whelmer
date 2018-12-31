package org.fleen.whelmer.whelmerVideoCreationSystems.w_test044_addedarandomring_pitchedabithigh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.core.ring.Projector;
import org.fleen.whelmer.core.ring.Ring;
import org.fleen.whelmer.core.ring.Ring_PureSine;
import org.fleen.whelmer.core.ring.Ring_Simple;

public class Projector2 implements Projector{

  /*
   * ################################
   * WHELMER
   * ################################
   */
  
  Whelmer whelmer;
  
  public void setWhelmer(Whelmer whelmer){
    this.whelmer=whelmer;}
  
  public Whelmer getWhelmer(){
    return whelmer;}

  /*
   * ################################
   * RINGS
   * ################################
   */
  
  private List<Ring> rings=new ArrayList<Ring>();
  
  public int getRingCount(){
    return rings.size();}
  
  public Iterator<Ring> getRingIterator(){
    return rings.iterator();}

  /*
   * ################################
   * CONDITIONALLY CREATE RINGS
   * 2 seamless random flows, inward and outward.
   * Random rings
   * random periodic flows. Of arbitrary period and length.
   * ################################
   */
  
  Random random=new Random();
  
  public void conditionallyCreateRings(){
    conditionallyCreateSeamlessInward();
    conditionallyCreateSeamlessOutward();
    conditionallyCreateRandomRing();
   
    
  }  
  
  boolean getRandomPolarity(){
    return random.nextBoolean();}
  
  /*
   * ++++++++++++++++++++++++++++++++
   * random ring or periodic sequence of rings
   * ++++++++++++++++++++++++++++++++
   */
  
  static final double 
    RANDOMRINGBASICCREATIONPROBABILITY=0.03,
    PERIODICSEQUENCEPROBABILITY=0.2;
  
  public void conditionallyCreateRandomRing(){
    double p=RANDOMRINGBASICCREATIONPROBABILITY;
    if(rings.size()<4){
      p=1;
    }else if(rings.size()>7){
      p=0;}
    if(random.nextDouble()<p){
      if(random.nextDouble()>PERIODICSEQUENCEPROBABILITY){
        rings.add(new Ring_PureSine(
          whelmer,
          getRandomDirectionForRandom(),
          getRandomSpeedForRandom(),
          getRandomThicknessForRandom(),
          getRandomPolarity()));
      }else{
        doPeriodicSequence();
      }}}
  
  boolean getRandomDirectionForRandom(){
    return random.nextBoolean();}
  
  double getRandomSpeedForRandom(){
    return random.nextDouble()*0.005+0.002;}
  
  double getRandomThicknessForRandom(){
    return random.nextDouble()*0.3+0.5;}
  
  /*
   * ++++++++++++++++++++++++++++++++
   * PERIODIC SEQUENCE
   * ++++++++++++++++++++++++++++++++
   */
  
  void doPeriodicSequence(){
    
  }
  
  /*
   * ++++++++++++++++++++++++++++++++
   * 2way seamless ring process
   * ++++++++++++++++++++++++++++++++
   */

  static final double SEAMLESSSPEED=0.001;
 
  Ring 
    seamlessinward=null,
    seamlessoutward=null;

  void conditionallyCreateSeamlessInward(){
    if(seamlessinward==null||seamlessinward.getOuterEdge()<1.0){
      seamlessinward=new Ring_PureSine(
        whelmer,
        Ring_Simple.INWARD,
        SEAMLESSSPEED,
        getRandomThicknessForSeamless(),
        true);
      rings.add(seamlessinward);}}
  
  void conditionallyCreateSeamlessOutward(){
    if(seamlessoutward==null||seamlessoutward.getInnerEdge()>0){
      seamlessoutward=new Ring_PureSine(
        whelmer,
        Ring_Simple.OUTWARD,
        SEAMLESSSPEED,
        getRandomThicknessForSeamless(),
        true);
      rings.add(seamlessoutward);}}
  
  //nice and fat
  //TODO but we get edge flutter because we're using puresine rings
  //we need to create flat rings
  double getRandomThicknessForSeamless(){
    return random.nextDouble()*0.3+0.5;}
  
  /*
   * ################################
   * CONDITIONALLY DESTROY RINGS
   * ################################
   */
  
  public void conditionallyDestroyRings(){
    Iterator<Ring> i=rings.iterator();
    Ring r;
    int destroyed=0;
    while(i.hasNext()){
      r=i.next();
      if(r.destroyMe()){
        i.remove();
        destroyed++;}}
    if(destroyed>0)System.out.println("destroyed="+destroyed);}

  /*
   * ################################
   * STROBE
   * we use this when calculating delta
   * we might also refer to this when filtering sound, 
   *   because the strobe will probably create a big 60hz tone
   *   
   * We could do something fancy here. 
   *   A sin(time) kinda deal. 
   *   or multiple strobes of differing rhythms, summed.
   * ################################
   */
  
//  static final int[] STROBE_DELTA_OVERLAY={-32,-32,32,32};
  static final double[] STROBE_DELTA_OVERLAY={-0.04,-0.04,0.04,0.04};
  
  public double getStrobe(){
    double s=STROBE_DELTA_OVERLAY[whelmer.time%STROBE_DELTA_OVERLAY.length];
    return s;}

  /*
   * ################################
   * DELTA
   * ################################
   */
  
  public double getDelta(double r){
    double delta=0;
    for(Ring ring:rings)
      delta+=ring.getDelta(r);
    delta+=getStrobe();
    return delta;}

}
