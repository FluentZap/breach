package com.example.toad.breach;

import android.opengl.GLES11;
import android.opengl.GLSurfaceView;

/**
 * Created by Toad on 12/29/2016.
 */

public class GameEngine {

    public void Start(GLRender glr,GLSurfaceView glView)
    {
        while(glr.color < 255) {
            glr.color += 1;
            glView.requestRender();
        }
    }



}
