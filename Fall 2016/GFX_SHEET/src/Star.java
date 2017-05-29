

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
public class Star extends JFrame implements MouseMotionListener, MouseListener {
    GLCanvas glcanvas;
    StarGLEventListener listener = new StarGLEventListener();

    public static void main(String[] args) {

        Star app = new Star();


    }

    public Star() {
        //set the JFrame title
        super("The Cartesian Coordinate System");


        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //only two JOGL lines of code ... and here they are
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);

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
        listener.xs = e.getX() - 250;
        listener.ys = 150 - e.getY();

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
    int xcross = 30, ycross = 30;
    int xs, ys;
    int cita = 0;
    double red, green = 1.0, blue; // initial box color is green

    public void init(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        GLU glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glViewport(0, 0, 500, 300);
//        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);

    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        drawGraph(gl);


        gl.glPushMatrix();
        gl.glColor3f((float) red, (float) green, (float) blue);
        gl.glTranslated(xs, ys, 0);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(50, 20);
        gl.glVertex2d(55, 70);
        gl.glVertex2d(55, 70);
        gl.glVertex2d(-5, 30);
        gl.glVertex2d(50, 20);
        gl.glVertex2d(100, 0);
        gl.glVertex2d(100, 0);
        gl.glVertex2d(50, -20);
        gl.glVertex2d(50, -20);
        gl.glVertex2d(55, -70);
        gl.glVertex2d(55, -70);
        gl.glVertex2d(-5, -30);
        gl.glVertex2d(-5, -30);
        gl.glVertex2d(-30, -70);
        gl.glVertex2d(-30, -70);
        gl.glVertex2d(-50, 0);
        gl.glVertex2d(-50, 0);
        gl.glVertex2d(-30, 70);
        gl.glVertex2d(-30, 70);
        gl.glVertex2d(-5, 30);
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

}


