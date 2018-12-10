package org.fleen.whelmer.whelmerVideoCreationSystems.w_test25_asymmetric_periodic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.core.ring.Ring_PureSine;
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
  
  public void conditionallyCreateRings(){
    if((whelmer.time+44)%66==0)
      add(new Ring_PureSine(whelmer,Ring_PureSine.OUTWARD,0.004,0.1,Ring_PureSine.POSITIVE));
    if((whelmer.time+19)%123==0)
      add(new Ring_PureSine(whelmer,Ring_PureSine.INWARD,0.006,0.5,Ring_PureSine.NEGATIVE));
    if((whelmer.time+200)%111==0)
      add(new Ring_PureSine(whelmer,Ring_PureSine.INWARD,0.006,0.19,Ring_PureSine.POSITIVE));
    if((whelmer.time+66)%166==0)
      add(new Ring_PureSine(whelmer,Ring_PureSine.INWARD,0.0003,0.25,Ring_PureSine.NEGATIVE));
    if((whelmer.time+100)%88==0)
      add(new Ring_PureSine(whelmer,Ring_PureSine.INWARD,0.0018,0.33,Ring_PureSine.POSITIVE));
    if((whelmer.time+266)%201==0)
      add(new Ring_PureSine(whelmer,Ring_PureSine.INWARD,0.01,0.42,Ring_PureSine.NEGATIVE));
  
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
      if(r.destroyMe()){
        i.remove();
        destroyed++;}}
    if(destroyed>0)System.out.println("destroyed="+destroyed);}

}
