/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Marwan pc
 * @author Marwan pc
 * @author Marwan pc
 * @author Marwan pc
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marwan pc
 */

import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.j2d.TextRenderer;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class Clock extends JFrame implements ActionListener, KeyListener {

    GLCanvas glcanvas;
    ClockGLEventListener listener = new ClockGLEventListener();
    JPanel jp = new JPanel();

    JButton jrb1 = new JButton("ClockWise");
    JButton jrb2 = new JButton("Anti-ClockWise");
    JButton jrb3 = new JButton("exit");

    public static void main(String[] args) {

        Clock app = new Clock();

    }

    public Clock() {
        //set the JFrame title
        super("The Cartesian Coordinate System");
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jrb1.addActionListener(this);

        jrb2.addActionListener(this);

        jrb3.addActionListener(this);
        jp.add(jrb1);
        jp.add(jrb2);
        jp.add(jrb3);

        setVisible(true);
        getContentPane().add("South", jp);
        //only two JOGL lines of code ... and here they are

        glcanvas = new GLCanvas();
        glcanvas.addKeyListener(this);
        glcanvas.addGLEventListener(listener);
        // Creating an animator that will redraw the scene 40 times per second.
        FPSAnimator animator = new FPSAnimator(1);

        // Registering the canvas to the animator.
        animator.add(glcanvas);

        // Starting the animator.
        animator.start();

        //add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(800, 500);

        //center the JFrame on the screen
        setLocationRelativeTo(null);

        //Show what we have done
        setVisible(true);
        glcanvas.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jrb1)) {
            listener.myVar -= 1;
        } else if (e.getSource().equals(jrb2)) {
            listener.myVar += 1;
        }
        glcanvas.repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

/**
 * For our purposes only two of the GLEventListeners matter. Those would be
 * init() and display().
 */
class ClockGLEventListener implements GLEventListener {
    TextRenderer renderer;
    float myVar = 0f;
    float min = 0f;
    float sec = 0f;
    float hour = 0f;

    /**
     * Take care of initialization here.
     */
    int xcross = 30, ycross = 30;
    int x, y, x1, y1;

    double radius = 150;
    double dist = 0;
    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;
    int cita = 0;
    double red, green = 1.0, blue; // initial box color is green

    public void init(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        GLU glu = new GLU();
        renderer = new TextRenderer(new Font("SansSerif", Font.BOLD, 24));
        gl.glClearColor(255.0f, 255.0f, 255.0f, 0.0f);
        gl.glViewport(0, 0, 800, 500);
//        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-400.0, 400.0, -250.0, 250.0);


    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        double x, y;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        float red = 0.5f;
        float green = 0.0f;
        float blue = 0.5f;
        GL gl = drawable.getGL();
        hour = cal.get(Calendar.HOUR);
        min = cal.get(Calendar.MINUTE);
        sec = cal.get(Calendar.SECOND);


        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        gl.glColor3f(1, 1, 0);
        gl.glLineWidth(10);
        gl.glBegin(GL.GL_POLYGON);

        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
        gl.glColor3f(0.0f / 255.0f, 0.0f / 255.0f, 0.0f / 255.0f);
        gl.glLineWidth(1);
        gl.glBegin(GL.GL_LINES);

        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE * 6) {

            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));

            gl.glVertex2d(x, y);
            x = (radius - 10) * (Math.cos(a));
            y = (radius - 10) * (Math.sin(a));
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
        gl.glColor3f(0, 0, 0);
        gl.glLineWidth(1);
        gl.glBegin(GL.GL_LINES);

        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE * 30) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glVertex2d(x, y);
            x = (radius - 20) * (Math.cos(a));
            y = (radius - 20) * (Math.sin(a));
            gl.glVertex2d(x, y);

        }
        gl.glEnd();

        renderer.begin3DRendering();

        String[] rr = {"3", "2", "1", "12", "11", "10", "9", "8", "7", "6", "5", "4"};
        int count = 0;
        renderer.setColor(1.0f, 0.0f, 0.0f, 0.8f);
        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE * 30) {
            x = (115) * (Math.cos(a)) - 10;
            y = (115) * (Math.sin(a)) - 10;

            renderer.draw(rr[count], (int) x, (int) y);
            count++;
        }


        renderer.end3DRendering();

        //*----------------MINUTES---------------------------*//
        gl.glColor3f(0, 1, 1);
        gl.glPushMatrix();
        gl.glRotatef(myVar * 30, 0.0f, 0.0f, 1.0f);

        gl.glBegin(GL.GL_POLYGON);
        //BOT
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex2d(0, 0);
        //Right

        gl.glVertex2d(10, 30);
        //TOP

        gl.glVertex2d(0, 150);
        //LEFT
        gl.glColor3f(0.2f, 0.8f, 0.2f);
        gl.glVertex2d(-1, 30);

        gl.glEnd();
        //*----------------HOURS---------------------------*//
        gl.glPopMatrix();
//        gl.glColor3f(0, 1, 1);
//        gl.glPushMatrix();
//        gl.glRotatef(-hour * 30 - min / 2.5f, 0.0f, 0.0f, 1.0f);
//        gl.glLineWidth(3);
//        gl.glBegin(GL.GL_POLYGON);
//        //BOT
//
//        gl.glColor3f(1.0f, 0.0f, 0.0f);
//        gl.glVertex2d(0, 0);
//        //Right
//
//        gl.glVertex2d(10, 30);
//        //TOP
//
//        gl.glVertex2d(0, 100);
//        //LEFT
//        gl.glColor3f(0.2f, 0.8f, 0.2f);
//        gl.glVertex2d(-1, 30);
//
//        gl.glEnd();
//        gl.glPopMatrix();
//        //*----------------Seconds---------------------------*//
//        gl.glColor3f(1, 0, 0);
//        gl.glPushMatrix();
//        gl.glRotatef(-sec * 6, 0.0f, 0.0f, 1.0f);
//        gl.glLineWidth(1);
//        gl.glBegin(GL.GL_LINES);
//
//        gl.glVertex2d(0, 0);
//        gl.glVertex2d(0, 100);
//
//        gl.glEnd();
//        gl.glPopMatrix();
//        //*-------------------dsdfs8-----------------------*//
//        gl.glColor3f(1, 0, 0);
//        gl.glLineWidth(10);
//        gl.glBegin(GL.GL_POLYGON);
//
//        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
//            x = 25 * (Math.cos(a));
//            y = 25 * (Math.sin(a));
//            gl.glVertex2d(x, y);
//        }
//        gl.glEnd();
//        gl.glColor3f(0, 0, 0);
//        gl.glLineWidth(2);
//        gl.glBegin(GL.GL_LINE_LOOP);
//
//        for (double a = 0; a < THREE_SIXTY; a += ONE_DEGREE) {
//            x = 25 * (Math.cos(a));
//            y = 25 * (Math.sin(a));
//            gl.glVertex2d(x, y);
//        }
//        gl.glEnd();
//        renderer.begin3DRendering();
//
//
//        renderer.setColor(1.0f, 0.0f, 0.0f, 0.8f);
//
//
//        renderer.draw(String.valueOf((int) hour), -30, -200);
//        renderer.draw(":", -15, -200);
//        if (min < 10)
//            renderer.draw("0" + String.valueOf((int) min), -10, -200);
//        else
//            renderer.draw(String.valueOf((int) min), -10, -200);
//        renderer.draw(":", 15, -200);
//        if (sec < 10)
//            renderer.draw("0" + String.valueOf((int) sec), 20, -200);
//        else
//            renderer.draw(String.valueOf((int) sec), 20, -200);
//
//
//        renderer.end3DRendering();
    }


    /**
     * Called when the GLDrawable (GLCanvas or GLJPanel) has changed in size.
     */
    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height) {
    }

    /**
     * If the display depth is changed while the program is running this method
     * is called. Nowadays this doesn't happen much, unless a programmer has his
     * program do it.
     */
    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged) {
    }

    private void drawGraph(GL gl) {
        float red;
        float green;
        float blue;

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        ////////////////////
        //drawing the grid
    }

}
