package org.fleen.whelmer.videoCreationSystems.vcs_test000_basic_stuff_works;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import org.fleen.geom_2D.GD;
import org.fleen.whelmer.core.RingPresence;
import org.fleen.whelmer.core.VideoRenderer;
import org.fleen.whelmer.core.Whelmer;

public class VideoRenderer1_big_palette_use_delta implements VideoRenderer{
  
  public BufferedImage renderFrame(Whelmer whelmer){
    
    palette=getPalette();
    
    BufferedImage image=new BufferedImage(whelmer.size,whelmer.size,BufferedImage.TYPE_INT_RGB);
    Graphics2D g=image.createGraphics();
    
//    AffineTransform t=AffineTransform.getScaleInstance(1,-1);
//    t.translate(0,h);
//    g.setTransform(t);
    
    g.setPaint(Color.gray);
    g.fillRect(0,0,whelmer.size,whelmer.size);
    
    List<RingPresence> p;
    Color c;
    for(int x=0;x<whelmer.size;x++){
      for(int y=0;y<whelmer.size;y++){
        p=whelmer.cells[x][y].getPresences(whelmer);
        c=getColor(p);
        image.setRGB(x,y,c.getRGB());}}
    return image;}
  
  /*
   * for our test
   * h=averaged values
   * s=1
   * b=averaged intensities
   */
  private Color getColor(List<RingPresence> presences){
    double summeddelta=0;
    int i;
    //average presences with nonzero intensity
    for(RingPresence p:presences){
        summeddelta+=p.delta;}
    i=((int)(summeddelta*palette.length))%palette.length;
    if(i<0)i=palette.length+i;
    Color c=palette[i];
    return c;}
  
  /*
   * CREATE A BIG PALETTE FOR FLOATY INDICES
   * A cell's delta ( range [0,1] ) is the sum of all deltas placed there by rings : summeddelta
   * This summed delta is a location on the palette. We get the specific index via summeddelta*palettelength : paletteintex
   * the palette is 1024 long. Maybe more. A big smear of colors. 
   * 
   * On the smear there is a more-or-less uniform delta-value that means 
   * "compatible but not too similar", and anotehr that means "bold contrast".
   * Every location on the palette has 2 such options (because there are 2 directions on the palette, neg and pos) 
   * 
   */
  
  Color[] palette=null;
  
  Color[] getPalette(){
    if(palette==null)createPalette();
    return palette;}
  
  void createPalette(){
    palette=new Color[255];
    int h;
    double d0;
    for(int i=0;i<palette.length;i++){
      d0=i;
      d0=(d0/((double)palette.length));
      h=(int)(d0*255);
      palette[i]=new Color(h,h,h);}}
  
  

}
