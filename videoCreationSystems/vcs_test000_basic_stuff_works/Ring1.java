package org.fleen.whelmer.videoCreationSystems.vcs_test000_basic_stuff_works;

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
    if(d<getFrontEdge()&&d>getBackEdge())
      return 0.2;
    else
      return 0;
    }

  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  double speed=0.009,thickness=0.13,blur=0.02;
  
  double getFrontEdge(){
    double a=speed*((double)getAge());
    return a;}
  
  double getBackEdge(){
    double a=getFrontEdge()-thickness;
    if(a<0)a=0;
    return a;}

}
