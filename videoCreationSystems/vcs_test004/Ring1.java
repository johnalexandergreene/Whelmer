package org.fleen.whelmer.videoCreationSystems.vcs_test004;

import org.fleen.whelmer.core.Ring;
import org.fleen.whelmer.core.Whelmer;

/*
 * it moves in reverse, from the outer edge
 */
public class Ring1 extends Ring{

  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Ring1(Whelmer whelmer,double thickness,double speed,double basedelta){
    super(whelmer);
    this.thickness=thickness;
    setSpeed(speed);
    this.basedelta=basedelta;}

  /*
   * ################################
   * DESTROY ME
   * ################################
   */
  
  //cuz it moves in reverse
  public boolean destroyMe(){
    double a=getFrontEdge();
    if(a<0){
      return true;}
    return false;}

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
      return 0;
    }

  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  double thickness=0.33;
  
  double getFrontEdge(){
    double a=(1.0+thickness)-(getSpeed()*((double)getAge()));
    return a;}
  
  double getBackEdge(){
    double a=getFrontEdge()-thickness;
    return a;}

}
