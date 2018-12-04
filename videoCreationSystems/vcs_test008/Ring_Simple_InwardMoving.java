package org.fleen.whelmer.videoCreationSystems.vcs_test008;

import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.core.ring.Ring;

public class Ring_Simple_InwardMoving extends Ring{
  
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
    
    double bd0=basedelta;
    if(getAge()%8<4)
      bd0+=0.12;
    else
      bd0-=0.12;
    
    
    double a=(getFrontEdge()+getBackEdge())/2;
    double b=Math.abs(d-a);
    double z=thickness/2;
    double c=(z-b)/z;
    if(d<getFrontEdge()&&d>getBackEdge())
      return bd0*c;
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
