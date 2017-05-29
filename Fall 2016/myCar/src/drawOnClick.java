/**
 * Created by maxmya on 11/20/16.
 */

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is a basic JOGL app. Feel free to reuse this code or modify it.
 */
public class drawOnClick extends JFrame implements MouseMotionListener, MouseListener {
    GLCanvas glcanvas;
    StarGLEventListener listener = new StarGLEventListener();


    public static void main(String[] args) {

        drawOnClick app = new drawOnClick();


    }

    public drawOnClick() {
        //set the JFrame title
        super("The Cartesian Coordinate System");


        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //only two JOGL lines of code ... and here they are
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);

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

        glcanvas.addMouseMotionListener(this);
        glcanvas.addMouseListener(this);
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
class StarGLEventListener implements GLEventListener {

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

        gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
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

      //  drawGraph(gl, 800, 400);


        gl.glPushMatrix();
        gl.glColor3f((float) red, (float) green, (float) blue);
        gl.glTranslated(xs, ys, 0);


        gl.glPointSize(100.0f);


        // upper black body
        gl.glColor3f(0f, 0f, 0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(-200, 0);
        gl.glVertex2i(190, 0);
        gl.glVertex2i(160, 80);
        gl.glVertex2i(-120, 80);
        gl.glEnd();


        // white upper front glass
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(-180, 0);
        gl.glVertex2i(-193, 0);
        gl.glVertex2i(-120, 70);
        gl.glVertex2i(-107, 70);
        gl.glEnd();

        // white upper left glass
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(-90, 68);
        gl.glVertex2i(-163, 0);
        gl.glVertex2i(0, 0);
        gl.glVertex2i(0, 68);
        gl.glEnd();


        // white upper right glass
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(10, 68);
        gl.glVertex2i(155, 68);
        gl.glVertex2i(180, 0);
        gl.glVertex2i(10, 0);
        gl.glEnd();


        // black down body
        gl.glColor3f(0f, 0f, 0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(-250, 0);
        gl.glVertex2i(190, 0);
        gl.glVertex2i(190, -90);
        gl.glVertex2i(-250, -90);
        gl.glEnd();


        // front yellow lights
        gl.glColor3f(1f, 233 / 255f, 0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(-248, -2);
        gl.glVertex2i(-230, -2);
        gl.glColor3f(1f, 0f, 0f);
        gl.glVertex2i(-230, -15);
        gl.glVertex2i(-248, -15);
        gl.glEnd();

        // black back car block
        gl.glColor3f(0f, 0f, 0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(177, -5);
        gl.glVertex2i(205, -5);
        gl.glVertex2i(205, -68);
        gl.glVertex2i(177, -68);
        gl.glEnd();

        //red back lights
        gl.glColor3f(1f, 0f, 0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(190, -10);
        gl.glVertex2i(203, -10);
        gl.glVertex2i(203, -60);
        gl.glVertex2i(190, -60);
        gl.glEnd();

        // yellow back lights
        gl.glColor3f(1f, 233 / 255f, 0f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(190, -10);
        gl.glVertex2i(203, -10);
        gl.glColor3f(1f, 0f, 0f);
        gl.glVertex2i(190, -60);
        gl.glVertex2i(203, -60);
        gl.glEnd();


        // white right wheels
        gl.glColor3f(1f, 1f, 1f);
        double RredX = 50;
        double Rredy = 50;
        double RplaceX = 110;
        double RplaceY = -90;
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            double rad = (i * ONE_DEGREE);
            gl.glVertex2d(Math.cos(rad) * RredX + RplaceX, Math.sin(rad) * Rredy + RplaceY);
        }
        gl.glEnd();

        gl.glLineWidth(10.0f);

        // black right wheels outer line
        gl.glColor3f(0f, 0f, 0f);
        gl.glBegin(GL.GL_LINE_LOOP);
        for (int i = 0; i < 360; i++) {
            double rad = (i * ONE_DEGREE);
            gl.glVertex2d(Math.cos(rad) * RredX + RplaceX, Math.sin(rad) * Rredy + RplaceY);
        }
        gl.glEnd();

        //  black right wheels core
        gl.glColor3f(0f, 0f, 0f);
        double rx = 20;
        double ry = 20;
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            double rad = (i * ONE_DEGREE);
            gl.glVertex2d(Math.cos(rad) * rx + RplaceX, Math.sin(rad) * ry + RplaceY);
        }
        gl.glEnd();


        // right wheels black sticks
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(60, -80);
        gl.glVertex2i(160, -80);
        gl.glVertex2i(160, -100);
        gl.glVertex2i(60, -100);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(100, -40);
        gl.glVertex2i(120, -40);
        gl.glVertex2i(120, -140);
        gl.glVertex2i(100, -140);
        gl.glEnd();

        // white left wheels
        gl.glColor3f(1f, 1f, 1f);
        double LredX = 50;
        double Lredy = 50;
        double LplaceX = -150;
        double LplaceY = -90;
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            double rad = (i * ONE_DEGREE);
            gl.glVertex2d(Math.cos(rad) * LredX + LplaceX, Math.sin(rad) * Lredy + LplaceY);
        }
        gl.glEnd();

        gl.glLineWidth(10.0f);

        // black right wheels outer line

        gl.glColor3f(0f, 0f, 0f);
        gl.glBegin(GL.GL_LINE_LOOP);
        for (int i = 0; i < 360; i++) {
            double rad = (i * ONE_DEGREE);
            gl.glVertex2d(Math.cos(rad) * LredX + LplaceX, Math.sin(rad) * Lredy + LplaceY);
        }
        gl.glEnd();

        //  black left wheels core


        gl.glColor3f(0f, 0f, 0f);
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            double rad = (i * ONE_DEGREE);
            gl.glVertex2d(Math.cos(rad) * rx + LplaceX, Math.sin(rad) * ry + LplaceY);

        }
        gl.glEnd();


        // left wheels black sticks
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(-100, -80);
        gl.glVertex2i(-200, -80);
        gl.glVertex2i(-200, -100);
        gl.glVertex2i(-100, -100);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(-140, -40);
        gl.glVertex2i(-160, -40);
        gl.glVertex2i(-160, -140);
        gl.glVertex2i(-140, -140);
        gl.glEnd();

        // dor keys
        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2i(0, -3);
        gl.glVertex2i(-20, -3);
        gl.glVertex2i(-20, -12);
        gl.glVertex2i(0, -12);
        gl.glEnd();


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


