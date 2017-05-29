/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

/**
 * @author Marwan pc
 */
public class OurGraphApp extends JFrame implements
        ActionListener {

    public static void main(String[] args) {
        new OurGraphApp();
    }

    JPanel jp = new JPanel();
    ButtonGroup bg = new ButtonGroup();
//setting up the sine JRadioButton

    JRadioButton jrb1 = new JRadioButton("Line Graph");
    JRadioButton jrb2 = new JRadioButton("Trig Graph");


    public OurGraphApp() {
//set the JFrame title
        super("The Cartesian Coordinate System");
//kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jrb1.setActionCommand("sine");
        jrb1.addActionListener(this);
//setting up the cosine JRadioButton

        jrb2.setActionCommand("cosine");
        jrb2.addActionListener(this);
//setting up the tangent JRadioButton

//adding the buttons to the ButtonGroup
        bg.add(jrb1);
        bg.add(jrb2);

//adding the buttons to the JPanel
        jp.add(jrb1);
        jp.add(jrb2);
        setVisible(true);
        getContentPane().add("South", jp);
//only three JOGL lines of code ... and here they are
        GLCapabilities glcaps = new GLCapabilities();
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(
                new OurGraphGLEventListener()
        );
//add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
//center the JFrame on the screen
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jrb1.isSelected()) {
            setVisible(false);
            LineGraphApp app = new LineGraphApp();
        } else if (jrb2.isSelected()) {
            setVisible(false);

            TrigGraphApp app = new TrigGraphApp();
        }
    }
}

class OurGraphGLEventListener implements
        GLEventListener {
///////////////////////////////////////////////////
// GLEventListener implementation
//

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glLineWidth(2.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
//glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
        gl.glOrtho(-250.0, 250.0, -150, 150, -1.0, 1.0);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable gld) {
        drawGraph(gld.getGL());
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


///////////////////////////////////////////////////
// Other methods
//

    /**
     * In here we draw a Cartesian Coordinate System.
     */
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
//Details of glBegin() will be discussed latter.
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
        red = 0.0f;
        green = 0.2f;
        blue = 0.4f;
        gl.glColor3f(1.0f, 0.0f, 0.0f);
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

    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        System.out.println();
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
        System.out.println();
    }
}

