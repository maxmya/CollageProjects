import javax.swing.*;
import java.awt.*;
public class Calculate extends JFrame 
{
    public Calculate()
    {
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(5, 4));
        buttons.setPreferredSize(new Dimension(385, 315));
        JButton division = new JButton(" ÷ ");
        division.setForeground(Color.BLACK);
        JButton multiplay = new JButton(" × ");
        multiplay.setForeground(Color.BLACK);
        JButton subtract = new JButton(" - ");
        subtract.setForeground(Color.BLACK);
        JButton add = new JButton(" + ");
        add.setForeground(Color.BLACK);
        JButton equal = new JButton(" = ");
        equal.setForeground(Color.BLACK);
        JButton recet = new JButton(" CE ");
        recet.setForeground(Color.BLACK);
        JButton deleteAll = new JButton(" C ");
        deleteAll.setForeground(Color.BLACK);
        JButton delete = new JButton(" del ");
        delete.setForeground(Color.BLACK);
        JButton P_N = new JButton(" -+ ");
        P_N.setForeground(Color.BLACK);
        JButton dot = new JButton(" . ");
        dot.setForeground(Color.BLACK);
        JButton zero = new JButton(" 0 ");
        zero.setFont(font1);
        zero.setForeground(Color.BLACK);
        JButton one = new JButton(" 1 ");
        one.setFont(font1);
        one.setForeground(Color.BLACK);
        JButton two = new JButton(" 2 ");
        two.setFont(font1);
        two.setForeground(Color.BLACK);
        JButton three = new JButton(" 3 ");
        three.setFont(font1);
        three.setForeground(Color.BLACK);
        JButton four = new JButton(" 4 ");
        four.setFont(font1);
        four.setForeground(Color.BLACK);
        JButton five = new JButton(" 5 ");
        five.setFont(font1);
        five.setForeground(Color.BLACK);
        JButton six = new JButton(" 6 ");
        six.setFont(font1);
        six.setForeground(Color.BLACK);
        JButton seven = new JButton(" 7 ");
        seven.setFont(font1);
        seven.setForeground(Color.BLACK);
        JButton eight = new JButton(" 8 ");
        eight.setFont(font1);
        eight.setForeground(Color.BLACK);
        JButton nine = new JButton(" 9 ");
        nine.setFont(font1);
        nine.setForeground(Color.BLACK);
        buttons.add(recet);
        buttons.add(deleteAll);
        buttons.add(delete);
        buttons.add(division);
        buttons.add(seven);
        buttons.add(eight);
        buttons.add(nine);
        buttons.add(multiplay);
        buttons.add(four);
        buttons.add(five);
        buttons.add(six);
        buttons.add(subtract);
        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(add);
        buttons.add(P_N);
        buttons.add(zero);
        buttons.add(dot);
        buttons.add(equal);
        
        JPanel text = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JTextField feild = new JTextField();
        feild.setPreferredSize(new Dimension(385, 150));
        text.add(feild);
        
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(text);
        add(buttons);
        
    }
    
    public static void main(String[]args)
    {
        Calculate frame = new Calculate();
        frame.setTitle("Calculate");
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);   
    }
}
