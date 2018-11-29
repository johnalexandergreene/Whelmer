package org.fleen.whelmer.videoCreationSystems.vcs_test000;

import java.io.File;

import org.fleen.whelmer.core.AudioExporter;
import org.fleen.whelmer.core.AudioRenderer;
import org.fleen.whelmer.core.ProgressListener;
import org.fleen.whelmer.core.Rings;
import org.fleen.whelmer.core.VideoExporter;
import org.fleen.whelmer.core.VideoRenderer;
import org.fleen.whelmer.core.Whelmer;

public class Whelmer0 extends Whelmer{

  Whelmer0(
    int size,int duration,Rings rings,
    ProgressListener progresslistener,File exportdir,
    VideoRenderer videorenderer,VideoExporter videoexporter,
    AudioRenderer audiorenderer,AudioExporter audioexporter){
    super(
      size,duration,rings,
      progresslistener,exportdir,
      videorenderer,videoexporter,
      audiorenderer,audioexporter);}

}
