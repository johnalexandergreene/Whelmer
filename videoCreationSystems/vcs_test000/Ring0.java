package org.fleen.whelmer.videoCreationSystems.vcs_test000;

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
  
  public double getValue(double d){
    return 0.2;}

  /*
   * ################################
   * GET INTENSITY
   * ################################
   */
  
  public double getIntensity(double d){
    double 
      f=getFrontEdge(),
      b=getBackEdge();
    double i=0;
    if(d>b&&d<f){
      //outward fade
      i=1.0-d;
      //edge blur
      if(f-d<blur)
        i*=((f-d)/blur);
      if(f>thickness&&d-b<blur)
        i*=((d-b)/blur);
    }
    return i;}
  
  /*
   * ################################
   * GEOMETRY
   * ################################
   */
  
  double speed=0.013,thickness=0.06,blur=0.01;
  
  double getFrontEdge(){
    double a=speed*((double)getAge());
    return a;}
  
  double getBackEdge(){
    double a=getFrontEdge()-thickness;
    if(a<0)a=0;
    return a;}

}
