package org.fleen.whelmer.videoCreationSystems;

import javax.swing.JFrame;

import org.fleen.whelmer.core.Whelmer;

@SuppressWarnings("serial")
public class UI extends JFrame{

  public ImagePanel imagepanel;
  
  public UI(Whelmer whelmer){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(50,50,whelmer.size+100,whelmer.size+100);
    imagepanel=new ImagePanel(whelmer);
    setContentPane(imagepanel);
    setVisible(true);}

}
