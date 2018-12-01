package org.fleen.whelmer.videoCreationSystems.vcs_test001_soft_rings;

import org.fleen.whelmer.core.Ring;
import org.fleen.whelmer.core.Whelmer;

public class Ring0 extends Ring{

  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Ring0(Whelmer whelmer){
    super(whelmer);}

  /*
   * ################################
   * DESTROY ME
   * ################################
   */
  
  public boolean destroyMe(){
    double a=getBackEdge();
    if(a>1){
      System.out.println("des : backedge="+a);
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
      return 0.4*c;
    else
      return 0;
    }
  
  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  double speed=0.013,thickness=0.31,blur=0.01;
  
  double getFrontEdge(){
    double a=speed*((double)getAge());
    return a;}
  
  double getBackEdge(){
    double a=getFrontEdge()-thickness;
    if(a<0)a=0;
    return a;}

}
