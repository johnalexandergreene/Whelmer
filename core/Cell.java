package org.fleen.whelmer.core;

import java.util.List;

public class Cell{
  
  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Cell(Whelmer whelmer,int x,int y){
    this.whelmer=whelmer;
    this.x=x;
    this.y=y;
    initDistance();}
  
  /*
   * ################################
   * WHELMER
   * ################################
   */
  
  Whelmer whelmer;
  
  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  //coors
  int x,y;
  //distance of this cell from from whelmer center in terms of whelmer radius (ie span/2), range [0,1]
  double distance;
  
  public int getX(){
    return x;}
  
  public int getY(){
    return y;}
  
  private void initDistance(){
    //get whelmer center
    double wcxy=((double)whelmer.getSize())/2;
    //get cell center
    double ccx=
    
  }
  
  /*
   * ################################
   * PRESENCES
   * ################################
   */
  
  /*
   * look at every ring in the whelmer and get its presence value at this cell
   */
  public List<RingPresence> getPresences(Whelmer whelmer){
    
  }

}
