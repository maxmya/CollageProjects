import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by maxmya on 10/23/16.
 */

public class Car extends JFrame implements GLEventListener, MouseListener, MouseMotionListener {


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
        glcanvas.addMouseListener(this);
        glcanvas.addMouseMotionListener(this);


        setVisible(true);

    }


    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

        GL gl = glAutoDrawable.getGL();
        gl.glClearColor(1.2f, 1.2f, 1.3f, 1.0f);
        gl.glViewport(0, 0, 600, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-300.0, 300.0, -200.0, 200.0, -1.0, 1.0);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);


    }

    @Override
    public void display(GLAutoDrawable drawable) {


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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {


        double x = MouseInfo.getPointerInfo().getLocation().getX();
        double y = MouseInfo.getPointerInfo().getLocation().getY();

        System.out.println(x + " " + y);


    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
