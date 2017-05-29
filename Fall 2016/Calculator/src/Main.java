import javax.swing.*;
import java.awt.*;

/**
 * Created by maxmya on 10/10/16.
 */
public class Main {

    static JFrame mycalc;

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        mycalc = new JFrame("Calculator");
        Image g = new ImageIcon("src/clc.png").getImage();
        mycalc.setIconImage(g);
        mycalc.setContentPane(new CalcUI().Calc);
        mycalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mycalc.setSize(180, 250);
        mycalc.setResizable(false);
        centerWindow();
        mycalc.setVisible(true);

    }


    public static void centerWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = mycalc.getSize();

        if (frameSize.width > screenSize.width) frameSize.width = screenSize.width;
        if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;

        mycalc.setLocation(
                (screenSize.width - frameSize.width) >> 1,
                (screenSize.height - frameSize.height) >> 1
        );
    }

}
