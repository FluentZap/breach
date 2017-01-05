package com.example.toad.breach;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by Toad on 12/29/2016.
 */

public class GameEngine extends Thread{
    static final long FPS = 60;



    public boolean Loop_Active = true;
    private Context con;
    private GLRender glr;
    private GLSurfaceView glView;


    public GameEngine(Context mcontext, GLRender gl, GLSurfaceView glV)
    {
        con = mcontext;
        glr = gl;
        glView = glV;
    }


    @Override
    public void run()
    {
        long ticksPS = 1000 / FPS;
        long startTime;
        long sleepTime;
        while(Loop_Active) {
            startTime = System.currentTimeMillis();
            glr.y += 1;
            if (glr.y >= 500) glr.y = 0;
            sleepTime = ticksPS - (System.currentTimeMillis() - startTime);
            try {
                if (sleepTime > 0)
                    sleep(sleepTime);
                else
                    sleep(10);
            } catch (Exception e) {}
        }
    }





}
