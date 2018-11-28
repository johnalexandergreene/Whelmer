package org.fleen.whelmer.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class Whelmer{

  /*
   * ################################
   * CONSTRUCTOR
   * ################################
   */
  
  Whelmer(int size,int duration,ProgressListener progresslistener,
    File exportdir,VideoRenderer videorenderer,VideoExporter videoexporter,
    AudioRenderer audiorenderer,AudioExporter audioexporter){
    this.size=size;
    this.duration=duration;
    this.exportdir=exportdir;
    this.progresslistener=progresslistener;
    this.videorenderer=videorenderer;
    this.videoexporter=videoexporter;
    this.audiorenderer=audiorenderer;
    this.audioexporter=audioexporter;
    initCells();}
  
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
  
  int size;
  
  public double getSize(){
    return size;}

  /*
   * ################################
   * TIME
   * ################################
   */
  
  int time=0,duration;
  
  public int getTime(){
    return time;}

  public void incrementTime(){
    if(time%100==0)System.out.println("time="+time);
    time++;
    if(time<duration){
      renderAndExportVideoFrame();
      renderAndStoreAudioFrame();
      rings.conditionallyCreateRings();
      rings.conditionallyDestroyRings();
      progresslistener.incremented(this);
    }else{
      System.out.println("exporting audio");
      exportAudio();
      progresslistener.finished(this);}}
  
  /*
   * ################################
   * RINGS
   * ################################
   */
  
  private Rings rings;
  
  public Rings getRings(){
    return rings;}

  /*
   * ################################
   * CELLS
   * ################################
   */
  
  Cell[][] cells;
  
  private void initCells(){
    cells=new Cell[size][size];
    for(int x=0;x<size;x++){
      for(int y=0;y<size;y++){
        cells[x][y]=new Cell(this,x,y);}}}
  
  public Cell[][] getCells(){
    return cells;}
  
  /*
   * ################################
   * VIDEO RENDERER
   * ################################
   */
  
  private VideoRenderer videorenderer=null;
  private BufferedImage videoframeimage=null;
  
  private void renderAndExportVideoFrame(){
    if(videorenderer!=null)
      videoframeimage=videorenderer.renderFrame(this);
    if(videoframeimage!=null)
      exportVideoFrameImage();}
  
  public BufferedImage getVideoFrameImage(){
    return videoframeimage;}
  
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
