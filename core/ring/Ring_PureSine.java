package org.fleen.whelmer.core.ring;

import org.fleen.whelmer.core.Whelmer;

/*
 * a stripe with a pure sine-wave shaped delta power curve
 * no base delta. delta is derived from the thickness
 */
public class Ring_PureSine extends Ring_Simple{

  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Ring_PureSine(
    Whelmer whelmer,boolean direction,double speed,
    double thickness,boolean polarity){
    super(whelmer,direction,speed,thickness);
    this.polarity=polarity;}
  
  /*
   * ################################
   * DELTA
   * ################################
   */
  
  public static final boolean POSITIVE=true,NEGATIVE=false;
  boolean polarity;
  double basedelta;
  
  double getPolarityVal(){
    if(polarity==POSITIVE) 
      return 1;
    else
      return -1;}
  
  public double getDelta(double distance){
    if(distance<getOuterEdge()&&distance>getInnerEdge()){
      double a=getOuterEdge()-getInnerEdge();
      double b=(distance-getInnerEdge())/a;
      double c=(b*Math.PI*2)+(3.0*Math.PI/2);
      double d=(Math.sin(c)+1)/2;
      return (thickness/Math.PI)*d*getPolarityVal();
    }else{
      return 0;}}

}