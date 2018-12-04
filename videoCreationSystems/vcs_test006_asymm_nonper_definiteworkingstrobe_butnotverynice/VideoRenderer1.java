package org.fleen.whelmer.videoCreationSystems.vcs_test006_asymm_nonper_definiteworkingstrobe_butnotverynice;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import org.fleen.whelmer.core.Cell;
import org.fleen.whelmer.core.VideoRenderer;
import org.fleen.whelmer.core.Whelmer;

public class VideoRenderer1 implements VideoRenderer{
  
  /*
   * the image fades to alpha=0 at the edge of the whelmer disk and beyond
   * the gradient starts at EDGEFADE from the edge 
   */
  static final double EDGEFADE=0.15;
  
  public BufferedImage renderFrame(Whelmer whelmer){
    palette=getPalette(); 
    //create a colored disk with an edge that fades to transparent
    BufferedImage iargb=new BufferedImage(whelmer.size,whelmer.size,BufferedImage.TYPE_INT_ARGB);
    Color c;
    for(int x=0;x<whelmer.size;x++){
      for(int y=0;y<whelmer.size;y++){
        c=getColor(whelmer.cells[x][y],whelmer);
        iargb.setRGB(x,y,c.getRGB());}}
    //convert to rgb because export strips the alpha data
    //do the background here too
    BufferedImage irgb=new BufferedImage(whelmer.size,whelmer.size,BufferedImage.TYPE_INT_RGB);
    Graphics2D g=irgb.createGraphics();
    g.setPaint(Color.black);
    g.fillRect(0,0,whelmer.size,whelmer.size);
    g.drawImage(iargb,null,null);
    //
    return irgb;}
  
  private Color getColor(Cell cell,Whelmer whelmer){
    //get alpha for edgefade
    double alpha;
    if(cell.distance>1.0){
      alpha=0;
    }else if(cell.distance<1.0-EDGEFADE){
      alpha=1.0;
    }else{//this is a nice sine curve fade
      alpha=(1.0-cell.distance)/EDGEFADE;
      alpha=alpha*(Math.PI/2.0);
      alpha=Math.sin(alpha);}
    //translate delta into color
    double delta=cell.getDelta(whelmer);
    int i=((int)(delta*palette.length))%palette.length;
    if(i<0)i=palette.length+i;
    Color c=palette[i];
    c=new Color(c.getRed(),c.getGreen(),c.getBlue(),(int)(alpha*255));
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
    if(palette==null)createPalette0();
    return palette;}
  
  void createPalette0(){
    //load it
    BufferedImage paletteimage=null;
    try{
      paletteimage=ImageIO.read(VideoRenderer1.class.getResource("palette001.png"));
    }catch(Exception x){
      x.printStackTrace();}
    //get the colors out of it
    int w=paletteimage.getWidth();
    palette=new Color[w];
    for(int i=0;i<w;i++){
      palette[i]=new Color(paletteimage.getRGB(i,0));}}
  

}
