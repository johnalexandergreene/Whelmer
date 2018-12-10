package org.fleen.whelmer.whelmerVideoCreationSystems;

import javax.swing.JFrame;

import org.fleen.whelmer.core.Whelmer;

@SuppressWarnings("serial")
public class UI extends JFrame{

  public ImagePanel imagepanel;
  
  public UI(Whelmer whelmer){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(50,50,whelmer.getCellArraySpan()+100,whelmer.getCellArraySpan()+100);
    imagepanel=new ImagePanel(whelmer);
    setContentPane(imagepanel);
    setVisible(true);}

}
