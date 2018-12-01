package org.fleen.whelmer.videoCreationSystems.vcs_test002_basic_2way;

import org.fleen.whelmer.core.Ring;
import org.fleen.whelmer.core.Whelmer;

public class Ring1 extends Ring{

  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Ring1(Whelmer whelmer){
    super(whelmer);}

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
   * GET VALUE
   * ################################
   */
  
  public double getDelta(double d){
    double a=(getFrontEdge()+getBackEdge())/2;
    double b=Math.abs(d-a);
    double z=thickness/2;
    double c=(z-b)/z;
    if(d<getFrontEdge()&&d>getBackEdge())
      return 0.2*c;
    else
      return 0;
    }

  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  double speed=0.006,thickness=0.33;
  
  double getFrontEdge(){
    double a=1.0-speed*((double)getAge());
    return a;}
  
  double getBackEdge(){
    double a=getFrontEdge()-thickness;
    return a;}

}
