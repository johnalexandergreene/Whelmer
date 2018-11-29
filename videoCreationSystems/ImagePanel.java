package org.fleen.whelmer.videoCreationSystems;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import org.fleen.whelmer.core.Whelmer;

public class ImagePanel extends JPanel{

  private static final long serialVersionUID=581500866418502553L;
  
  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  ImagePanel(Whelmer whelmer){
    this.whelmer=whelmer;}
  
  /*
   * ################################
   * WHELMER
   * ################################
   */
  
  Whelmer whelmer;
  
  /*
   * ################################
   * PAINT
   * ################################
   */
  
  static final AffineTransform OFFSETALITTLE=AffineTransform.getTranslateInstance(50,50);
  
  public void paint(Graphics g){
    super.paint(g);
    if(whelmer.videoframe==null)return;
    Graphics2D g2=(Graphics2D)g;
    g2.drawImage(whelmer.videoframe,OFFSETALITTLE,null);}

}
