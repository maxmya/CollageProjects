import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by maxmya on 10/9/16.
 */
public class Calculator extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JPanel numPanel = new JPanel();
    private JPanel keyPanel = new JPanel();


    private JTextArea screen = new JTextArea(3, 8);

    private JButton[] numPad;

    private JButton zero;
    private JButton plus;
    private JButton minus;
    private JButton multiply;
    private JButton division;
    private JButton equal;
    private JButton floating;
    private JButton clear;

    private double before;
    private double after;
    private double ans;
    private String Equation;


    public Calculator() {

        setLayout(new CardLayout());
        setTitle("Calculator");
        setSize(450, 200);
        setResizable(false);
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);


        numPad = new JButton[9];
        for (int i = 0; i < numPad.length; i++) {
            numPad[i] = new JButton(String.valueOf(i + 1));
        }

        zero = new JButton("0");
        plus = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        division = new JButton("/");
        equal = new JButton("=");
        clear = new JButton("Clear");
        floating = new JButton(".");


        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen.append("0");
            }
        });
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (before == 0 && after == 0) {
                    String src = screen.getText();
                    if (!(src.isEmpty())) {
                        before = Double.parseDouble(src);

                    }
                    screen.setText("");
                } else if (after == 0) {
                    String src = screen.getText();
                    if (!(src.isEmpty())) {
                        after = Double.parseDouble(src);

                    }
                    screen.setText("");
                } else {
                    ans = ans + before + after;
                    before = 0;
                    after = 0;
                    screen.setText(String.valueOf(ans));
                }


            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                before = 0;
                after = 0;
                ans = 0;
                screen.setText("");
            }
        });
        floating.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String scr = screen.getText();
                if (!scr.contains(".")) {
                    screen.append(".");
                }
            }
        });


        numPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < numPad.length; i++) {
            numPanel.add(numPad[i]);

        }

        for (int i = 0; i < 9; i++) {
            numPad[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (ans == 0) {
                        JButton pressed = (JButton) e.getSource();
                        screen.append(String.valueOf(pressed.getText()));
                    } else {
                        screen.setText("");
                        JButton pressed = (JButton) e.getSource();
                        screen.append(String.valueOf(pressed.getText()));
                    }
                }
            });
        }


        keyPanel.setLayout(new GridLayout(2, 4));
        keyPanel.add(plus);
        keyPanel.add(minus);
        keyPanel.add(multiply);
        keyPanel.add(division);
        keyPanel.add(floating);
        keyPanel.add(equal);
        keyPanel.add(clear);

        mainPanel.add(screen, BorderLayout.NORTH);
        mainPanel.add(numPanel, BorderLayout.CENTER);
        mainPanel.add(keyPanel, BorderLayout.EAST);
        mainPanel.add(zero, BorderLayout.SOUTH);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }


}
