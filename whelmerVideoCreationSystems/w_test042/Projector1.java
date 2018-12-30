package org.fleen.whelmer.whelmerVideoCreationSystems.w_test042;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.core.ring.Projector;
import org.fleen.whelmer.core.ring.Ring;
import org.fleen.whelmer.core.ring.Ring_PureSine;
import org.fleen.whelmer.core.ring.Ring_Simple;

public class Projector1 implements Projector{

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
   * ################################
   */
  
  Random random=new Random();
  static final double CREATIONPROBABILITY=0.03;
  
  public void conditionallyCreateRings(){
    double p=CREATIONPROBABILITY;
    if(rings.size()<3){
      p=1;
    }else if(rings.size()>7)p=0;
    if(random.nextDouble()<p){
      rings.add(new Ring_PureSine(
          whelmer,
          getRandomDirection(),
          getRandomSpeed(),
          getRandomThickness(),
          getRandomPolarity()));}}
  
  boolean getRandomDirection(){
    return random.nextBoolean();}
  
  double getRandomSpeed(){
    return random.nextDouble()*0.003+0.001;}
  
  double getRandomThickness(){
    return random.nextDouble()*0.5+0.08;}
  
  boolean getRandomPolarity(){
    return random.nextBoolean();}

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
