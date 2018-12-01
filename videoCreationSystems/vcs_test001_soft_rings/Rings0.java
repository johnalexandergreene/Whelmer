package org.fleen.whelmer.videoCreationSystems.vcs_test001_soft_rings;

import java.util.ArrayList;
import java.util.Iterator;

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
  
  public void conditionallyCreateRings(){
    if(whelmer.time%33==0){
      System.out.println("created ring");
      add(new Ring0(whelmer));}
    if(whelmer.time%88==0){
      System.out.println("created ring");
      add(new Ring1(whelmer));}
    
  }

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
      if(r.destroyMe()){
        i.remove();
        destroyed++;}}
    if(destroyed>0)System.out.println("destroyed="+destroyed);}

}
