/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

public class FirstCircle extends JFrame {

    public static void main(String[] args) {


        new FirstCircle();
    }

    public FirstCircle() {
//set the JFrame title
        super("First Circle Using Sine and Cosine");

//kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//only three JOGL lines of code ... and here they are
        GLCapabilities glcaps = new GLCapabilities();
        GLCanvas glcanvas = new GLCanvas();

        glcanvas.addGLEventListener(
                new FirstCircleEventListener()
        );
//add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500,350);
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


/**
 * We make the center of the GLCanvas the origin of our graph
 * and construct a circle around it using sine and cosine
 * methods from the Math class.
 * <p>
 * We have ignored insets in this and other examples, so this
 * circle may be slightly more of an oval depending on the OS.
 */
class FirstCircleEventListener
        implements GLEventListener {


    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
//GLU glu = gld.getGLU();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
//glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
        gl.glOrtho(-250.0, 250.0, -150, 150, -1.0, 1.0);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        double x, y;
        double radius = 100;
        float red = 0.5f;
        float green = 0.0f;
        float blue = 0.5f;
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_POLYGON);
// angle is
// x = radius * (cosine of angle)
// y = radius * (sine of angle)
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
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




