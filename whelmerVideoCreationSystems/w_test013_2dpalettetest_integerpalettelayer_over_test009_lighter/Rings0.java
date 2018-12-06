package org.fleen.whelmer.whelmerVideoCreationSystems.w_test013_2dpalettetest_integerpalettelayer_over_test009_lighter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.core.ring.Ring_Simple;
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
    if((whelmer.time+33)%122==0)
      add(new Ring_Simple_OutwardMoving(whelmer,0.8,0.002,0.6));
    if(whelmer.time%166==0)
      add(new Ring_Simple_InwardMoving(whelmer,0.4,0.001,0.8));}
      
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
      
      
//      System.out.println("speed = "+r.getSpeed());
//      System.out.println("age = "+r.getAge());
//      if(r instanceof Ring1)
//        System.out.println("r1 front edge = "+((Ring1)r).getFrontEdge());
      
      
      if(r.destroyMe()){
        i.remove();
        destroyed++;}}
    if(destroyed>0)System.out.println("destroyed="+destroyed);}

}
