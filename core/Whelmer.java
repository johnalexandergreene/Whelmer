package org.fleen.whelmer.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.fleen.geom_2D.GD;

public class Whelmer{

  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  public Whelmer(
    int size,int duration,Rings rings,
    ProgressListener progresslistener,File exportdir,
    VideoRenderer videorenderer,VideoExporter videoexporter,
    AudioRenderer audiorenderer,AudioExporter audioexporter){
    this.size=size;
    this.duration=duration;
    this.rings=rings;
    rings.setWhelmer(this);
    this.exportdir=exportdir;
    this.progresslistener=progresslistener;
    this.videorenderer=videorenderer;
    this.videoexporter=videoexporter;
    this.audiorenderer=audiorenderer;
    this.audioexporter=audioexporter;
    initCells();}
  
  /*
   * ################################
   * MAIN GENERATION LOOP
   * ################################
   */
  
  public void run(){
    System.out.println("whelmer run : duration="+duration);
    for(int i=0;i<duration;i++){
//      try{
//        Thread.sleep(5);
//      }catch(Exception x){}
      incrementTime();}
    //
    System.out.println("exporting audio");
    exportAudio();
    progresslistener.finished(this);}
  
  /*
   * ################################
   * PROGRESS LISTENER
   * ################################
   */
  
  private ProgressListener progresslistener;
  
  /*
   * ################################
   * EXPORT DIR
   * ################################
   */
  
  File exportdir;
  
  /*
   * ################################
   * SIZE
   * ################################
   */
  
  public int size;

  /*
   * ################################
   * TIME
   * ################################
   */
  
  public int time=-1,duration;
 
  public void incrementTime(){
    time++;
    if(time%10==0)System.out.println("time="+time);
      renderAndExportVideoFrame();
      renderAndStoreAudioFrame();
      rings.conditionallyCreateRings();
      rings.conditionallyDestroyRings();
      progresslistener.timeIncremented(this);}
  
  /*
   * ################################
   * RINGS
   * ################################
   */
  
  public Rings rings;

  /*
   * ################################
   * CELLS
   * ################################
   */
  
  public Cell[][] cells;
  
  private void initCells(){
    double wc=((double)size)/2;
    cells=new Cell[size][size];
    for(int x=0;x<size;x++){
      for(int y=0;y<size;y++){
        cells[x][y]=new Cell(getCellDistance(wc,x,y));}}}
  
  /*
   * remember!
   * our distances are in terms of size/2.
   * ie, in range 0..1
   * clip everything bigger than 1
   */
  private double getCellDistance(double whelmercenter,double x,double y){
    double 
      cellcenterx=x+0.5,
      cellcentery=y+0.5,
      d=GD.getDistance_PointPoint(whelmercenter,whelmercenter,cellcenterx,cellcentery);
    d=(d*2)/((double)size);//normalize it to [0,1]
    return d;}
  
  /*
   * ################################
   * VIDEO RENDERER
   * ################################
   */
  
  private VideoRenderer videorenderer=null;
  public BufferedImage videoframe=null;
  
  private void renderAndExportVideoFrame(){
    if(videorenderer!=null)
      videoframe=videorenderer.renderFrame(this);
    if(videoframe!=null)
      exportVideoFrameImage();}
  
  public BufferedImage getVideoFrameImage(){
    return videoframe;}
  
  /*
   * ################################
   * VIDEO EXPORTER
   * ################################
   */
  
  private VideoExporter videoexporter=null;
  
  private void exportVideoFrameImage(){
    if(exportdir!=null&&videoexporter!=null)
      videoexporter.exportVideoFrame(videoframe,time,exportdir);}
  
  /*
   * ################################
   * AUDIO RENDERER
   * ################################
   */
  
  private AudioRenderer audiorenderer=null;
  private List<int[]> audioframes=new ArrayList<int[]>();
  
  private void renderAndStoreAudioFrame(){
    if(audiorenderer!=null){
      int[] a=audiorenderer.renderAudioFrame(this);
      audioframes.add(a);}}
  
  public List<int[]> getAudioFrames(){
    return audioframes;}
  
  /*
   * ################################
   * AUDIO EXPORTER
   * ################################
   */
  
  private AudioExporter audioexporter=null;
  
  private void exportAudio(){
    if(exportdir!=null&&audioexporter!=null)
      audioexporter.exportAudio(this);}

}
