package org.fleen.whelmer.videoCreationSystems.vcs_test000;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import org.fleen.whelmer.core.RingPresence;
import org.fleen.whelmer.core.VideoRenderer;
import org.fleen.whelmer.core.Whelmer;

public class VideoRenderer0 implements VideoRenderer{

  public BufferedImage renderFrame(Whelmer whelmer){
    BufferedImage image=new BufferedImage(whelmer.size,whelmer.size,BufferedImage.TYPE_INT_RGB);
    Graphics2D g=image.createGraphics();
    
//    AffineTransform t=AffineTransform.getScaleInstance(1,-1);
//    t.translate(0,h);
//    g.setTransform(t);
    
    g.setPaint(Color.gray);
    g.fillRect(0,0,whelmer.size,whelmer.size);
    
    List<RingPresence> p;
    int c;
    for(int x=0;x<whelmer.size;x++){
      for(int y=0;y<whelmer.size;y++){
        p=whelmer.cells[x][y].getPresences(whelmer);
        c=getColor(p);
        image.setRGB(x,y,c);}}
    return image;}
  
  /*
   * for our test
   * h=averaged values
   * s=1
   * b=averaged intensities
   */
  private int getColor(List<RingPresence> presences){
    double av=0,ai=0;
    for(RingPresence p:presences){
      av+=p.value;
      ai+=p.intensity;}
    av/=((double)presences.size());
    ai/=((double)presences.size());
    int rgb=Color.HSBtoRGB((float)av,(float)1,(float)ai);
    return rgb;}

}
