/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

public class TrigGraphApp extends JFrame implements ActionListener {
    TrigGLEventListener listener = new TrigGLEventListener();
    GLCanvas glcanvas;

    public static void main(String[] args) {
        new TrigGraphApp();
    }

    JPanel jp = new JPanel();
    ButtonGroup bg = new ButtonGroup();
    double m = -1;
    double a = 2;
    double b = 3;

    JPanel linePanel = new JPanel();
//setting up the sine JRadioButton

    JRadioButton jrb1 = new JRadioButton("Sine", true);
    JRadioButton jrb2 = new JRadioButton("Cosine");
    JRadioButton jrb3 = new JRadioButton("Tangent");
    JRadioButton jrb4 = new JRadioButton("Line");
    JScrollPane scrl = new JScrollPane();

    JTextField ajtf = new JTextField("3", 3);
    JTextField bjtf = new JTextField("2", 3);
    JTextField mjtf = new JTextField("-1", 6);
    JButton jb = new JButton("Redraw");


    public TrigGraphApp() {
//set the JFrame title
        super("Sine, Cosine and Tangent");
//kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Setting up our southern JPanel with JRadioButtons

        linePanel.setLayout(new FlowLayout());
        linePanel.add(ajtf);
        linePanel.add(bjtf);
        linePanel.add(mjtf);
        linePanel.add(jb);
        linePanel.setVisible(false);
        jrb1.setActionCommand("sine");
        jrb1.addActionListener(this);
        jb.addActionListener(this);
//setting up the cosine JRadioButton

        jrb2.setActionCommand("cosine");
        jrb2.addActionListener(this);
//setting up the tangent JRadioButton

        jrb3.setActionCommand("tangent");
        jrb3.addActionListener(this);
//adding the buttons to the ButtonGroup

        jrb4.setActionCommand("line");
        jrb4.addActionListener(this);


        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        bg.add(jrb4);
//adding the buttons to the JPanel
        jp.add(jrb1);
        jp.add(jrb2);
        jp.add(jrb3);
        jp.add(jrb4);
        jp.add(linePanel);
        getContentPane().add("South", jp);
//only three JOGL lines of code ... and here they are
        GLCapabilities glcaps = new GLCapabilities();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
//add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        //getContentPane().add(linePanel, BorderLayout.SOUTH);
        setSize(700, 500);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jrb1.isSelected()) {
            linePanel.setVisible(false);
            listener.whatToDraw = "sine";
            glcanvas.repaint();
        } else if (jrb2.isSelected()) {
            linePanel.setVisible(false);
            listener.whatToDraw = "cosine";
            glcanvas.repaint();
        } else if (jrb3.isSelected()) {
            linePanel.setVisible(false);
            listener.whatToDraw = "tangent";
            glcanvas.repaint();
        } else if (jrb4.isSelected()) {
            linePanel.setVisible(true);
            listener.whatToDraw = "line";
            glcanvas.repaint();
        }

        if (e.getSource().equals(jb)) {
            try {
                System.out.println("Debug");
                a = Double.parseDouble(ajtf.getText());
                b = Double.parseDouble(bjtf.getText());
                m = Double.parseDouble(mjtf.getText());

                glcanvas.repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Wrong Input");
            }


//
//        if (e.getSource().equals(jb1)) {
//
//            setVisible(false);
//            OurGraphApp app = new OurGraphApp();
//        }


        }

    }

    class TrigGLEventListener implements GLEventListener {
        public String whatToDraw = "sine";
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

        /**
         * Take care of drawing here.
         */
        public void display(GLAutoDrawable gld) {

            GL gl = gld.getGL();
            drawGraph(gl);
//This is the new code. We find out
//which trig function is selected,
//then we draw a scaled up version of
//the function.
            float red;
            float green;
            float blue;
////////////////////
//drawing the grid
            red = 1.0f;
            green = 0.2f;
            blue = 0.2f;
            gl.glColor3f(red, green, blue);
            gl.glBegin(GL.GL_POINTS);
            if (whatToDraw.equals("sine")) {
//draw enlarged sine function
                for (int x = -250; x < 250; x++)
                    gl.glVertex2d(x, (Math.sin(x / 60.0) * 100.0));
            } else if (whatToDraw.equals("cosine")) {
//draw enlarged cosine function
                for (int x = -250; x < 250; x++)
                    gl.glVertex2d(x, (Math.cos(x / 60.0) * 100.0));
            } else if (whatToDraw.equals("tangent")) {
//draw enlarged tangent function
                for (int x = -250; x < 250; x++)
                    gl.glVertex2d(x, (Math.tan(x / 60.0) * 30.0));
            } else if (whatToDraw.equals("line")) {


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


        @Override
        public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
            System.out.println();
        }

        @Override
        public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
            System.out.println();
        }
    }
}
