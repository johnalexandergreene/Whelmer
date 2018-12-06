package org.fleen.whelmer.whelmerVideoCreationSystems.w_test010_2dpalettetest_smalldelta_shortpalette;

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
  
//  public void conditionallyCreateRings(){
//    double thickness,speed,basedelta,cp=CREATIONPROBABILITY;
//    if(size()<1)cp=1.0;
//    if(size()>3)cp=0;
//    if(random.nextDouble()<cp){
//      thickness=getRandomThickness();
//      speed=getRandomSpeed();
//      basedelta=getRandomDelta();
//      if(random.nextBoolean()){
//        add(new Ring_Simple_OutwardMoving(whelmer,thickness,speed,basedelta));
//      }else{
//        add(new Ring_Simple_InwardMoving(whelmer,thickness,speed,basedelta));}}}
  
  public void conditionallyCreateRings(){
    if((whelmer.time+33)%122==0)
      add(new Ring_Simple_OutwardMoving(whelmer,0.8,0.002,0.3));
    if(whelmer.time%166==0)
      add(new Ring_Simple_InwardMoving(whelmer,0.4,0.001,0.4));
    }
  
  double getRandomThickness(){
    return 0.05;
//    return random.nextDouble()*0.3+0.8;
    }
  
  double getRandomSpeed(){
    return 0.001;
//    return random.nextDouble()*0.0007+0.0008;
    }
  
  double getRandomDelta(){
    if(whelmer.time%2==0)
      return 0.4;
    else
      return -0.4;
      
    
//    double a=random.nextDouble()*0.3+0.2;
//    if(random.nextBoolean())a*=-1;
//    return a;
    }

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
