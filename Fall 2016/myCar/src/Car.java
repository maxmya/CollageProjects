import javax.swing.*;
import java.awt.*;
import javax.media.opengl.*;

/**
 * Created by maxmya on 10/23/16.
 */

public class Car extends JFrame implements GLEventListener {


    final double ONE_DEGREE = (Math.PI / 180);
    final double THREE_SIXTY = 2 * Math.PI;


    double radius = 90;
    double x, y;

    public static void main(String[] args) {


        new Car();


    }

    public Car() {

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
