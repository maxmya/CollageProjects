import javax.swing.*;
import java.awt.*;
import javax.media.opengl.*;

/**
 * Created by maxmya on 10/23/16.
 */

public class birdDrawing extends JFrame implements GLEventListener {


    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;


    double radius = 90;
    double x, y;

    public static void main(String[] args) {


        new birdDrawing();


    }

    public birdDrawing() {

        super("Car Drawing");
        setSize(700, 400);
        centerWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(this);
        add(glcanvas, BorderLayout.CENTER);


        setVisible(true);

    }


    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

        GL gl = glAutoDrawable.getGL();
        gl.glClearColor(1.2f, 1.2f, 1.3f, 1.0f);
        gl.glViewport(0, 0, 600, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-600.0, 600.0, -400.0, 400.0, -1.0, 1.0);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);


    }

    @Override
    public void display(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        gl.glPointSize(100.0f);


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
        double RplaceX2 = 45;
        double RplaceY2 = -50;
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i < 360; i++) {
            double rad = (i * ONE_DEGREE);
            gl.glVertex2d(Math.cos(rad) * RredX2 + RplaceX2, Math.sin(rad) * Rredy2 + RplaceY2);
        }
        gl.glEnd();


    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

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
}
