package org.fleen.whelmer.whelmerVideoCreationSystems.w_test016_strobe2_2_64_nicesimpleperiodicsemisymmetric_good;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.core.ring.Ring_Simple;
import org.fleen.whelmer.core.ring.Ring_Simple_Sine;
import org.fleen.whelmer.core.ring.Projector;

@SuppressWarnings("serial")
public class Rings0 extends ArrayList<Ring_Simple> implements Projector{
  
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
    if((whelmer.time+77)%99==0)
      add(new Ring_Simple_Sine(whelmer,Ring_Simple.OUTWARD,0.002,0.5,0.5));
    if(whelmer.time%123==0)
      add(new Ring_Simple_Sine(whelmer,Ring_Simple.INWARD,0.002,0.5,-0.5));}
      
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
