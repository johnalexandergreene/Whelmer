package org.fleen.whelmer.videoCreationSystems.vcs_test000;

import org.fleen.geom_2D.GD;
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
    return false;}

  /*
   * ################################
   * GET VALUE
   * ################################
   */
  
  public double getValue(double d){
    double 
      a=d*GD.PI*getAge(),
      b=Math.abs(Math.sin(a));
    return b;}

  /*
   * ################################
   * GET INTENSITY
   * ################################
   */
  
  public double getIntensity(double d){
    double 
    a=d*GD.PI*getAge(),
    b=Math.abs(Math.sin(a));
  return b;}

}
