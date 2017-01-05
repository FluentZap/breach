package com.example.toad.breach;

import android.app.Application;
import android.content.Context;
import android.opengl.GLES11;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

/**
 * Created by Toad on 12/28/2016.
 */

public class GLRender implements GLSurfaceView.Renderer {

    public int color;

    private GLHelper.Square square;
    private int tex0;
    private Context context;

    public GLRender(Context mcontext)
    {
    context = mcontext;
    }


    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES11.glClearColor(0.2f, 0.6f, 0.6f, 1.0f);
        square = new GLHelper.Square();
        tex0 = GLHelper.loadTexture(context, R.drawable.box);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        GLES11.glViewport(0, 0, width, height);

        //float ratio = (float) width / height;
        gl.glMatrixMode(GL10.GL_PROJECTION);        // set matrix to projection mode
        gl.glLoadIdentity();                        // reset the matrix to its default state
        //gl.glOrthof(0.0f, 32, 0.0f, height, 0.0f, 1.0f);
        //gl.glFrustumf(-ratio, ratio, -1, 1, 3, 7);  // apply the projection matrix

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES11.glClear(GLES11.GL_COLOR_BUFFER_BIT);
        GLES11.glClearColor(0.0f, 0.0f, 1.0f, 1.0f);


        //GLES11.glColor4x(128, 50, 50, 200);
        GLES11.glEnable(GLES11.GL_TEXTURE_2D);
        GLES11.glDisable(GLES11.GL_DITHER);
        GLES11.glDisable(GLES11.GL_LIGHTING);
        GLES11.glBlendFunc(GLES11.GL_SRC_ALPHA, GLES11.GL_ONE_MINUS_SRC_ALPHA);

        GLES11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
        GLES11.glEnableClientState(GL11.GL_TEXTURE_COORD_ARRAY);

        GLES11.glFrontFace(GL11.GL_CW);
        GLES11.glVertexPointer(3, GL11.GL_FLOAT, 0, square.vertexBuffer);
        GLES11.glBindTexture(GLES11.GL_TEXTURE_2D, tex0);
        GLES11.glTexCoordPointer(2, GLES11.GL_FLOAT, 0, square.texBuffer);


        GLES11.glDrawElements(GLES11.GL_TRIANGLES, 6, GLES11.GL_UNSIGNED_SHORT, square.drawListBuffer);
    }


}
