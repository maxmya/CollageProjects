/**
 * Created by maxmya on 11/6/16.
 */

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Drawer extends JFrame implements GLEventListener, MouseMotionListener, MouseListener {

    GLCanvas glcanvas = new GLCanvas();
    JPanel pnl = new JPanel();
    JRadioButton line = new JRadioButton("Line");
    JRadioButton rect = new JRadioButton("Rectangle");
    JRadioButton circle = new JRadioButton("Circle");
    ButtonGroup bg = new ButtonGroup();

    double gX, gY, gX1, gY1;

    public Drawer() {

        super("Drawer");
        setSize(700, 400);
        centerWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        glcanvas.addGLEventListener(this);
        pnl.setLayout(new FlowLayout());
        bg.add(line);
        bg.add(circle);
        bg.add(rect);
        pnl.add(line);
        pnl.add(rect);
        pnl.add(circle);
        add(glcanvas, BorderLayout.CENTER);
        add(pnl, BorderLayout.SOUTH);
        glcanvas.addMouseListener(this);
        glcanvas.addMouseMotionListener(this);
        setVisible(true);


    }

    public static void main(String[] args) {
        new Drawer();
    }


    public void centerWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.width > screenSize.width) frameSize.width = screenSize.width;
        if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;
        this.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }


    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

        GL gl = glAutoDrawable.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(0, 0, 600, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-300.0, 300.0, -200.0, 200.0, -1.0, 1.0);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);


    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {

        GL gl = glAutoDrawable.getGL();

        drawGraph(gl, 600, 400);


        gl.glLineWidth(5.0f);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(gX, gY);
        gl.glVertex2d(gX1, gY1);
        gl.glEnd();


    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

        double x = e.getX();
        double y = e.getY();
        double w = glcanvas.getWidth();
        double h = glcanvas.getHeight();

        x = (int) ((x / w) * 600 - 300);

        y = (int) (((h - y) / h) * 400 - 200);

        gX = x;
        gY = y;

//        System.out.println("X " + (x) + "Y " + (y));
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        double x = e.getX();
        double y = e.getY();
        double w = glcanvas.getWidth();
        double h = glcanvas.getHeight();

        x = (int) ((x / w) * 600 - 300);

        y = (int) (((h - y) / h) * 400 - 200);

        gX1 = x;
        gY1 = y;

//        System.out.println("X " + (x) + "Y " + (y));
        glcanvas.repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

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