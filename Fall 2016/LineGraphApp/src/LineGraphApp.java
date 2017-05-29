/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.swing.*;

public class LineGraphApp extends JFrame implements
        ActionListener {
    //Notice we've given these two objects a larger scope.
//Local scope to the constructor was no longer sufficient.
    LineGLEventListener listener = new LineGLEventListener();
    GLCanvas glcanvas;
    JTextField ajtf = new JTextField("3", 3);
    JTextField bjtf = new JTextField("2", 3);
    JTextField mjtf = new JTextField("-1", 6);
    JButton jb = new JButton("Redraw");
    JButton jb1 = new JButton("back");


    public static void main(String[] args) {
        new LineGraphApp();
    }


    public LineGraphApp() {
//set the JFrame title
        super("Point-Slope Calculation");
//kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Setting up our southern JPanel
        JPanel jp = new JPanel();
//adding the JTextFields and JLabels
        jp.add(new JLabel("x:"));
        jp.add(ajtf);
        jp.add(new JLabel(" y:"));
        jp.add(bjtf);
        jp.add(new JLabel(" slope: "));
        jp.add(mjtf);
//adding the JButton

        jb.addActionListener(this);
        jb1.addActionListener(this);
        jp.add(jb);
        jp.add(jb1);
        getContentPane().add("South", jp);
//only three JOGL lines of code ... and here they are
        GLCapabilities glcaps = new GLCapabilities();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
//add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
//center the JFrame on the screen
        setVisible(true);
        centerWindow(this);
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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(jb)) {
            try {

                listener.a = Double.parseDouble(ajtf.getText());
                listener.b = Double.parseDouble(bjtf.getText());
                listener.m = Double.parseDouble(mjtf.getText());

                glcanvas.repaint();
            }catch (Exception e ){
                JOptionPane.showMessageDialog(null,"Wrong Input");
            }

        } else if (ae.getSource().equals(jb1)) {
            setVisible(false);
            OurGraphApp app = new OurGraphApp();
        }
    }

}

/**
 * For our purposes only two of the GLEventListeners matter.
 * Those would be
 * init() and display().
 */
class LineGLEventListener implements GLEventListener {
    //public slope and (a,b) for setting up the line
    double m, a, b;

    //floats used for color selection
    LineGLEventListener() {
        m = -1;
        a = 2;
        b = 3;
    }

    float red;
    float green;
    float blue;
///////////////////////////////////////////////////
// GLEventListener implementation
//

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
//GLU glu = gld.getGLU();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glLineWidth(2.0f);
        gl.glPointSize(2.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
//glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
        gl.glOrtho(-250.0, 250.0, -150, 150, -1.0, 1.0);
    }


    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        drawGraph(gl);

//This is the new code. We find out
//which trig function is selected,
//then we draw a scaled up version of
//the function.
//Let's make the line red
        red = 1.0f;
        green = 0.2f;
        blue = 0.2f;
        gl.glColor3f(red, green, blue);
// Point-slope form of a line is:
// y = m(x -a) + b where (a,b) is the
// point.
// Also,
// y - b = m( x - a )
// works.
// m is of course the slope.
//Let's make the line
        gl.glBegin(GL.GL_POINTS);
//let's make every grid one point even
//though it is made by 10 x 10 pixels.
        double a1 = a * 10;
        double b1 = b * 10;
        for (int x = -250; x <= 250; x++) {
            gl.glVertex2d(x, (m * (x - a1) + b1));
        }
        gl.glEnd();
//Let's make the point now
//making the point white
        red = 1.0f;
        green = 1.0f;
        blue = 1.0f;
        gl.glColor3f(red, green, blue);
        gl.glPointSize(4.0f);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(a1, b1);
        gl.glEnd();
//resetting the point to 2 pixels.
        gl.glPointSize(2.0f);
    }

    public void reshape(
            GLAutoDrawable drawable,
            int x,

            int y,
            int width,
            int height
    ) {
    }

    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {
    }
///////////////////////////////////////////////////
// Other methods
//

    /**
     * In here we draw a Cartesian Coordinate System.
     */
    private void drawGraph(GL gl) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
////////////////////
//drawing the grid
        red = 0.2f;
        green = 0.2f;
        blue = 0.2f;
        gl.glColor3f(red, green, blue);
//You may notice I'm using GL_LINES here.
//Details of glBegin() will be discussed latter.
        gl.glBegin(GL.GL_LINES);
//draw the vertical lines
        for (int x = -250; x <= 250; x += 3) {
            gl.glVertex2d(x, -150);
            gl.glVertex2d(x, 150);
        }
//draw the horizontal lines
        for (int y = -150; y <= 150; y += 3) {
            gl.glVertex2d(-250, y);
            gl.glVertex2d(250, y);
        }
        gl.glEnd();
//////////////////////////////
// draw the x-axis and y-axis
        red = 0.0f;
        green = 0.2f;
        blue = 0.4f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_LINES);

//line for y-axis
        gl.glVertex2d(0, 140);
        gl.glVertex2d(0, -140);
//line for x-axis
        gl.glVertex2d(240, 0);
        gl.glVertex2d(-240, 0);
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