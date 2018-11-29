package org.fleen.whelmer.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.fleen.geom_2D.GD;

public abstract class Whelmer{

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
      try{
        Thread.sleep(500);
      }catch(Exception x){}
      incrementTime();}}
  
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
  
  int time=0,duration;
  
  public int getTime(){
    return time;}

  public void incrementTime(){
    if(time%10==0)System.out.println("time="+time);
    time++;
    if(time<duration){
      renderAndExportVideoFrame();
      renderAndStoreAudioFrame();
      rings.conditionallyCreateRings();
      rings.conditionallyDestroyRings();
      progresslistener.timeIncremented(this);
    }else{
      System.out.println("exporting audio");
      exportAudio();
      progresslistener.finished(this);}}
  
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
  
  private double getCellDistance(double wc,double x,double y){
    double 
      cx=x+0.5,
      cy=y+0.5,
      d=GD.getDistance_PointPoint(wc,wc,cx,cy);
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
      videoexporter.exportVideoFrame(this);}
  
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
