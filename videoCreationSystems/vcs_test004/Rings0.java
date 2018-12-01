package org.fleen.whelmer.videoCreationSystems.vcs_test004;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.fleen.whelmer.core.Ring;
import org.fleen.whelmer.core.Rings;
import org.fleen.whelmer.core.Whelmer;

@SuppressWarnings("serial")
public class Rings0 extends ArrayList<Ring> implements Rings{
  
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
    double thickness,speed,delta;
    if(random.nextDouble()<CREATIONPROBABILITY){
      thickness=getRandomThickness();
      speed=getRandomSpeed();
      delta=getRandomDelta();
      if(random.nextBoolean()){
        add(new Ring0(whelmer,thickness,speed,delta));
      }else{
        add(new Ring1(whelmer,thickness,speed,delta));}}}
  
  double getRandomThickness(){
    return random.nextDouble()*0.5+0.8;
    }
  
  double getRandomSpeed(){
    return random.nextDouble()*0.003+0.003;
  }
  
  double getRandomDelta(){
    double a=random.nextDouble()*0.3+0.2;
    if(random.nextBoolean())a*=-1;
    return a;}

  /*
   * ################################
   * CONDITIONALLY DESTROY RINGS
   * ################################
   */
  
  public void conditionallyDestroyRings(){
    Iterator<Ring> i=iterator();
    Ring r;
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
