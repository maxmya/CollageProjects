/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
//import net.java.games.jogl.*;

public class SecondJoglApp extends JFrame {


    public static void main(String[] args) {
        new SecondJoglApp();
    }

    public SecondJoglApp() {
//set the JFrame title
        super("Second JOGL Application");
//kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//only three JOGL lines of code ... and here they are
        GLCapabilities glcaps = new GLCapabilities();
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(new SecondGLEventListener());
//add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
//center the JFrame on the screen
        centerWindow(this);
        setVisible(true);
    }

    public void centerWindow(Component frame) {
        Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();

        Dimension frameSize = frame.getSize();
        if (frameSize.width > screenSize.width)
            frameSize.width = screenSize.width;
        if (frameSize.height > screenSize.height)
            frameSize.height = screenSize.height;
        frame.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }


}

class SecondGLEventListener implements GLEventListener {
    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
//GLU glu = gld.getGLU();
        gl.glClearColor(0f,0f,0f, 1.0f);
        gl.glViewport(0, 0, 500, 300); //This is using the GL Object to set the area of the screen to be seen.
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
//glu.gluOrtho2D(0.0, 500.0, 0.0, 300.0);
        gl.glOrtho(0.0, 500.0, 0.0, 300.0, -1.0, 1.0);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        float red = 0.0f;

        float green = 0.0f;
        float blue = 0.0f;
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glPointSize(10.0f);
        for (int i = 0; i < 50; i++) {
            red -= .09f;
            green -= .12f;
            blue -= .15f;
            if (red < 0.15) red = 1.0f;
            if (green < 0.15) green = 1.0f;
            if (blue < 0.15) blue = 1.0f;
            gl.glColor3f(red, green, blue);
            gl.glBegin(GL.GL_POINTS);
            gl.glVertex2i((i * 10), 150);
            gl.glEnd();
            gl.glColor3f(red, green, blue);

//            gl.glBegin(GL.GL_POINTS);
//            gl.glVertex2i(250, (i * 10));
//            gl.glEnd();

        }
    }

    public void reshape(
            GLDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {
    }

    public void displayChanged(
            GLDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {
    }

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {

    }


}


