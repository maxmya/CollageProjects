import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by maxmya on 10/10/16.
 */
public class Demo {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JPanel mainPanel;


    Demo() {

        button4.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hoa");
            }
        });
    }


    public static void main(String[] args) {

        JFrame myAppFrame = new JFrame("Myapp");
        myAppFrame.setContentPane(new Demo().mainPanel);
        myAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myAppFrame.setSize(600, 600);
        myAppFrame.setVisible(true);

    }

}
