package org.fleen.whelmer.whelmerVideoCreationSystems.w_test23_soundtest_soundusescellstripquery_asymmetric_nonperiodic_GOOD;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.core.ring.Ring_PureSine;
import org.fleen.whelmer.core.ring.Ring_Simple;
import org.fleen.whelmer.core.ring.Ring_Simple_Sine;
import org.fleen.whelmer.core.ring.Rings;

@SuppressWarnings("serial")
public class Rings0 extends ArrayList<Ring_Simple> implements Rings{
  
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
   * CONDITIONALLY CREATE RINGS
   * ################################
   */
  
  Random random=new Random();
  static final double CREATIONPROBABILITY=0.03;
  
  public void conditionallyCreateRings(){
    double p=CREATIONPROBABILITY;
    if(size()<2){
      p=1;
    }else if(size()>5)p=0;
    if(random.nextDouble()<p){
      add(new Ring_PureSine(
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
  
  
//  public void conditionallyCreateRingsZ(){
//    if((whelmer.time+44)%33==0)
//      add(new Ring_PureSine(whelmer,Ring_PureSine.OUTWARD,0.002,0.08,Ring_PureSine.POSITIVE));
//    if(whelmer.time%123==0)
//      add(new Ring_PureSine(whelmer,Ring_PureSine.INWARD,0.003,0.5,Ring_PureSine.NEGATIVE));
//    if(whelmer.time%111==0)
//      add(new Ring_PureSine(whelmer,Ring_PureSine.INWARD,0.004,0.19,Ring_PureSine.POSITIVE));
//    if(whelmer.time%166==0)
//      add(new Ring_PureSine(whelmer,Ring_PureSine.INWARD,0.0033,0.25,Ring_PureSine.NEGATIVE));}
      
  /*
   * ################################
   * CONDITIONALLY DESTROY RINGS
   * ################################
   */
  
  public void conditionallyDestroyRings(){
    Iterator<Ring_Simple> i=iterator();
    Ring_Simple r;
    int destroyed=0;
    while(i.hasNext()){
      r=i.next();
      if(r.destroyMe()){
        i.remove();
        destroyed++;}}
    if(destroyed>0)System.out.println("destroyed="+destroyed);}

}
