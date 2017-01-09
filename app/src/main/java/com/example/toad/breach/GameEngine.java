package com.example.toad.breach;

import android.content.Context;
import android.graphics.Point;
import android.opengl.GLSurfaceView;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Toad on 12/29/2016.
 */

public class GameEngine extends Thread{
    static final long FPS = 60;


    public boolean Loop_Active = true;
    private Context con;
    private GLRender glr;
    private GLSurfaceView glView;


    private battle_Map current_Map;
    private LinkedList<MotionEvent> inputStack;


    public GameEngine(Context mcontext, GLRender gl, GLSurfaceView glV)
    {
        con = mcontext;
        glr = gl;
        glView = glV;

        inputStack = new LinkedList<>();



        glView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                inputStack.add(event);
                return true;

            }
        });



    }





    @Override
    public void run()
    {
        long ticksPS = 1000 / FPS;
        long startTime;
        long sleepTime;
        while(Loop_Active) {
            startTime = System.currentTimeMillis();
            sleepTime = ticksPS - (System.currentTimeMillis() - startTime);
            try {
                if (sleepTime > 0) {
                    logic();
                    ui();
                    sleep(sleepTime);
                }
                else
                    sleep(10);
            } catch (Exception e) {}
        }
    }


    public void logic()
    {
        if (current_Map == null)
            current_Map = new battle_Map(new Point(16, 16));
        glr.current_Map = current_Map;

    }

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;

    private float mscx;
    private float mscy;



    public void ui()
    {
        MotionEvent e = inputStack.poll();

        float x = e.getX();
        float y = -e.getY();


        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPreviousX = x;
                mPreviousY = y;
                mscx = glr.screen_Scroll.x;
                mscy = glr.screen_Scroll.y;

            case MotionEvent.ACTION_MOVE:
                glr.screen_Scroll.x = (int)(mscx + (x - mPreviousX));
                glr.screen_Scroll.y = (int)(mscy + (y - mPreviousY));

            case MotionEvent.ACTION_UP:

        }


    }




}
