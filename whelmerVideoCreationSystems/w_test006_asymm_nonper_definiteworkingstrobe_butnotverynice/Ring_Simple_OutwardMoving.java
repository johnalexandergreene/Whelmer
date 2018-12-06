package org.fleen.whelmer.whelmerVideoCreationSystems.w_test006_asymm_nonper_definiteworkingstrobe_butnotverynice;

import org.fleen.whelmer.core.Whelmer;
import org.fleen.whelmer.core.ring.Ring_Simple;

public class Ring_Simple_OutwardMoving extends Ring_Simple{
  
  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Ring_Simple_OutwardMoving(Whelmer whelmer,double thickness,double speed,double basedelta){
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
  
  public double basedelta;
  
  public double getDelta(double d){
    
    double bd0=basedelta;
    if(getAge()%6<3)
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
    double a=getBackEdge();
    if(a>1){
      return true;}
    return false;}
  
  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  double getFrontEdge(){
    double a=speed*((double)getAge());
    return a;}
  
  double getBackEdge(){
    double a=getFrontEdge()-thickness;
    return a;}

}
