/**
 * Created by maxmya on 11/20/16.
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;

/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class birdOnclick extends JFrame implements MouseMotionListener, MouseListener {
    GLCanvas glcanvas;
    StarGLEventListener2 listener = new StarGLEventListener2();


    public static void main(String[] args) {

        birdOnclick app = new birdOnclick();


    }

    public birdOnclick() {
        //set the JFrame title
        super("The Cartesian Coordinate System");


        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //only two JOGL lines of code ... and here they are
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);

        glcanvas.addMouseMotionListener(this);
        glcanvas.addMouseListener(this);

        glcanvas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        //add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);

        //center the JFrame on the screen
        setLocationRelativeTo(null);

        //Show what we have done
        setVisible(true);
        glcanvas.requestFocus();
    }


    public void mouseMoved(MouseEvent e) {

        listener.xcross = e.getX() - 250;
        listener.ycross = 150 - e.getY();

        System.out.println(" x : " + (e.getX() - 250) + " y : " + (150 - e.getY()));

        glcanvas.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        listener.red = (Math.random() * 255) / 255.0f;
        listener.green = (Math.random() * 255) / 255.0f;
        listener.blue = (Math.random() * 255) / 255.0f;
        double x = e.getX();
        double y = e.getY();
        double w = glcanvas.getWidth();
        double h = glcanvas.getHeight();

        x = (int) ((x / w) * 1600 - 800);

        y = (int) (((h - y) / h) * 800 - 400);

        listener.xs = x;
        listener.ys = y;

        glcanvas.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}


/**
 * For our purposes only two of the GLEventListeners matter. Those would be
 * init() and display().
 */
class StarGLEventListener2 implements GLEventListener {

    /**
     * Take care of initialization here.
     */

    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;


    double radius = 90;
    double x, y;

    int xcross = 30, ycross = 30;
    double xs, ys;
    int cita = 0;
    double red, green = 1.0, blue; // initial box color is green

    public void init(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        GLU glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glViewport(0, 0, 500, 300);
//        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-800.0, 800.0, -400.0, 400.0);

    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        drawGraph(gl, 800, 400);


        gl.glPushMatrix();
        gl.glColor3f((float) red, (float) green, (float) blue);
        gl.glTranslated(xs, ys, 0);


        gl.glPointSize(100.0f);

        //body right leg
        gl.glColor3f(1f, (230.0f / 255.0f), (128.0f / 255.0f));
        gl.glLineWidth(10.0f);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(0, 0);
        gl.glVertex2d(120, -200);
        gl.glEnd();

        //body left leg
        gl.glColor3f(1f, (230.0f / 255.0f), (128.0f / 255.0f));
        gl.glLineWidth(10.0f);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(0, 0);
        gl.glVertex2d(-120, -200);
        gl.glEnd();

        // mouse
        gl.glColor3f(0f, 1f, 1f);
        gl.glBegin(GL.GL_POLYGON);

        gl.glVertex2d(120, 110);
        gl.glVertex2d(120, 250);
        gl.glVertex2d(300, 225);

        gl.glEnd();


        // head
        gl.glColor3f(1f, (230.0f / 255.0f), (128.0f / 255.0f));
        double RredX3 = 120;
        double Rredy3 = 120;
        double RplaceX3 = 80;
        double RplaceY3 = 170;
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            double rad = (i * ONE_DEGREE);
            gl.glVertex2d(Math.cos(rad) * RredX3 + RplaceX3, Math.sin(rad) * Rredy3 + RplaceY3);
        }
        gl.glEnd();

        // eye white
        gl.glColor3f(1f, 1f, 1f);
        double RredX4 = 50;
        double Rredy4 = 50;
        double RplaceX4 = 100;
        double RplaceY4 = 210;
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            double rad = (i * ONE_DEGREE);
            gl.glVertex2d(Math.cos(rad) * RredX4 + RplaceX4, Math.sin(rad) * Rredy4 + RplaceY4);
        }
        gl.glEnd();

        // eye black
        gl.glColor3f(0f, 0f, 0f);
        double RredX5 = 20;
        double Rredy5 = 20;
        double RplaceX5 = 110;
        double RplaceY5 = 210;
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            double rad = (i * ONE_DEGREE);
            gl.glVertex2d(Math.cos(rad) * RredX5 + RplaceX5, Math.sin(rad) * Rredy5 + RplaceY5);
        }
        gl.glEnd();


        // body
        gl.glColor3f(0f, 1f, 1f);
        double RredX = 180;
        double Rredy = 180;
        double RplaceX = 0;
        double RplaceY = 0;
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            double rad = (i * ONE_DEGREE);
            gl.glVertex2d(Math.cos(rad) * RredX + RplaceX, Math.sin(rad) * Rredy + RplaceY);
        }
        gl.glEnd();


        // body inside wings
        gl.glColor3f((160.0f / 255.0f), (255.0f / 255.0f), (255.0f / 255.0f));
        double RredX2 = 120;
        double Rredy2 = 120;
        double RplaceX2 = 30;
        double RplaceY2 = -50;
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            double rad = (i * ONE_DEGREE);
            gl.glVertex2d(Math.cos(rad) * RredX2 + RplaceX2, Math.sin(rad) * Rredy2 + RplaceY2);
        }
        gl.glEnd();
        gl.glPopMatrix();



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
        red = 0.2f;
        green = 0.2f;
        blue = 0.2f;

        gl.glColor3f(red, green, blue);

        //You may notice I'm using GL_LINES here.
        gl.glBegin(GL.GL_LINES);

        //draw the vertical lines
        for (int x = -250; x <= 250; x += 10) {
            gl.glVertex2d(x, -150);
            gl.glVertex2d(x, 150);
        }

        //draw the horizontal lines
        for (int y = -150; y <= 150; y += 10) {
            gl.glVertex2d(-250, y);
            gl.glVertex2d(250, y);
        }

        gl.glEnd();

        //////////////////////////////
        // draw the x-axis and y-axis
        red = 1.0f;
        green = 1.0f;
        blue = 1.0f;

        gl.glColor3f(red, green, blue);

        gl.glBegin(GL.GL_LINES);

        //line for y-axis
        gl.glVertex2d(0, 150);
        gl.glVertex2d(0, -150);

        //line for x-axis
        gl.glVertex2d(250, 0);
        gl.glVertex2d(-250, 0);

        gl.glEnd();

        /////////////////////
        // draw arrow heads
        gl.glBegin(GL.GL_TRIANGLES);

        gl.glVertex2d(0, 150);
        gl.glVertex2d(-5, 140);
        gl.glVertex2d(5, 140);

        gl.glVertex2d(0, -150);
        gl.glVertex2d(-5, -140);
        gl.glVertex2d(5, -140);

        gl.glVertex2d(250, 0);
        gl.glVertex2d(240, -5);
        gl.glVertex2d(240, 5);

        gl.glVertex2d(-250, 0);
        gl.glVertex2d(-240, -5);
        gl.glVertex2d(-240, 5);

        gl.glEnd();

    }


    private void drawGraph(GL gl, int width, int height) {
        float red;
        float green;
        float blue;
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glLineWidth(1.0f);

        red = 0.2f;
        green = 0.2f;
        blue = 0.2f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_LINES);
        for (int x = -width; x <= width; x += 10) {
            gl.glVertex2d(x, -height);
            gl.glVertex2d(x, height);
        }
        for (int y = -height; y <= height; y += 10) {
            gl.glVertex2d(-width, y);
            gl.glVertex2d(width, y);
        }
        gl.glEnd();
        red = 0.0f;
        green = 0.2f;
        blue = 0.4f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(0, height - 10);
        gl.glVertex2d(0, -height - 10);
        gl.glVertex2d(width - 10, 0);
        gl.glVertex2d(-width - 10, 0);
        gl.glEnd();
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glVertex2d(0, height);
        gl.glVertex2d(-5, height - 10);
        gl.glVertex2d(5, height - 10);
        gl.glVertex2d(0, -height);
        gl.glVertex2d(-5, -height - 10);
        gl.glVertex2d(5, -height - 10);
        gl.glVertex2d(width, 0);
        gl.glVertex2d(width - 10, -5);
        gl.glVertex2d(width - 10, 5);
        gl.glVertex2d(-width, 0);
        gl.glVertex2d(-width - 10, -5);
        gl.glVertex2d(-width - 10, 5);
        gl.glEnd();
    }


}


