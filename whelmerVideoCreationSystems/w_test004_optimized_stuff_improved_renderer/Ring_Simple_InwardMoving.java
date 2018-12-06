package org.fleen.whelmer.whelmerVideoCreationSystems.w_test004_optimized_stuff_improved_renderer;

import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.core.ring.Ring_Simple;

public class Ring_Simple_InwardMoving extends Ring_Simple{
  
  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Ring_Simple_InwardMoving(Whelmer whelmer,double thickness,double speed,double basedelta){
    super(whelmer);
    this.thickness=thickness;
    this.speed=speed;
    this.basedelta=basedelta;}

  /*
   * ################################
   * THICKNESS
   * ################################
   */
  
  public double thickness;
  
  /*
   * ################################
   * SPEED
   * ################################
   */
  
  public double speed;
  
  /*
   * ################################
   * DELTA
   * ################################
   */
  
  double basedelta;
  
  public double getDelta(double d){
    double a=(getFrontEdge()+getBackEdge())/2;
    double b=Math.abs(d-a);
    double z=thickness/2;
    double c=(z-b)/z;
    if(d<getFrontEdge()&&d>getBackEdge())
      return basedelta*c;
    else
      return 0;}
  
  /*
   * ################################
   * DESTROY ME
   * ################################
   */
  
  public boolean destroyMe(){
    double a=getFrontEdge();
    if(a<0){
      return true;}
    return false;}
  
  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  double getFrontEdge(){
    double a=(1.0+thickness)-(speed*((double)getAge()));
    return a;}
  
  double getBackEdge(){
    double a=getFrontEdge()-thickness;
    return a;}

}
