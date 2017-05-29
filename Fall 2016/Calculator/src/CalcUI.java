import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

/**
 * Created by maxmya on 10/10/16.
 */
public class CalcUI {

    private JPanel mainPanel;
    private JPanel keyPanel;
    private JButton cButton;
    private JButton delButton;
    private JButton divisonButton;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton multButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton plustButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton minusButton;
    private JButton a0Button;
    private JButton floatButton;
    private JButton equalButton;
    private JTextArea screen;
    public JPanel Calc;


    public CalcUI() {


        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String src = ((JButton) e.getSource()).getText();

                switch (src) {

                    case "0": {
                        screen.append("0");
                        screen.requestFocus();
                        break;
                    }
                    case "1": {
                        screen.append("1");
                        screen.requestFocus();
                        break;

                    }
                    case "2": {
                        screen.append("2");
                        screen.requestFocus();
                        break;

                    }
                    case "3": {
                        screen.append("3");
                        screen.requestFocus();
                        break;

                    }
                    case "4": {
                        screen.append("4");
                        screen.requestFocus();
                        break;

                    }
                    case "5": {
                        screen.append("5");
                        screen.requestFocus();
                        break;

                    }
                    case "6": {
                        screen.append("6");
                        screen.requestFocus();
                        break;

                    }
                    case "7": {
                        screen.append("7");
                        screen.requestFocus();
                        break;

                    }
                    case "8": {
                        screen.append("8");
                        screen.requestFocus();
                        break;

                    }
                    case "9": {
                        screen.append("9");
                        screen.requestFocus();
                        break;

                    }
                    case "C": {
                        screen.setText("");
                        screen.requestFocus();
                        break;

                    }
                    case "Del": {
                        if (!screen.getText().isEmpty()) {
                            if (screen.getText().equals("Err")) {

                                screen.setText("");

                            } else {
                                String now = screen.getText().substring(0, screen.getText().length() - 1);
                                screen.setText(now);
                            }
                        }
                        screen.requestFocus();
                        break;
                    }
                    case ".": {
                        try {
                            String s = screen.getText();
                            String[] nums = s.split("[+]|[-]|[*]|[/]");
                            int l = nums.length - 1;
                            boolean flag = nums[l].contains(".");
                            if (!flag) {
                                screen.append(".");
                            }

                        } catch (Exception ee) {
                        }
                        screen.requestFocus();
                        break;
                    }
                    case "+": {
                        Addition();
                        screen.requestFocus();
                        break;
                    }
                    case "-": {
                        Substraction();
                        screen.requestFocus();
                        break;
                    }
                    case "*": {
                        Multiply();
                        screen.requestFocus();
                        break;
                    }
                    case "/": {
                        Division();
                        screen.requestFocus();
                        break;

                    }
                    case "=": {
                        Evaluate();
                        screen.requestFocus();
                        break;
                    }
                }

            }
        };
        cButton.addActionListener(listener);
        delButton.addActionListener(listener);
        divisonButton.addActionListener(listener);
        a1Button.addActionListener(listener);
        a2Button.addActionListener(listener);
        a3Button.addActionListener(listener);
        multButton.addActionListener(listener);
        a4Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a6Button.addActionListener(listener);
        plustButton.addActionListener(listener);
        a7Button.addActionListener(listener);
        a8Button.addActionListener(listener);
        a9Button.addActionListener(listener);
        minusButton.addActionListener(listener);
        a0Button.addActionListener(listener);
        equalButton.addActionListener(listener);
        floatButton.addActionListener(listener);
        screen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_1: {
                        screen.append("1");
                        break;
                    }
                    case KeyEvent.VK_0: {
                        screen.append("0");
                        break;
                    }
                    case KeyEvent.VK_2: {
                        screen.append("2");
                        break;
                    }
                    case KeyEvent.VK_3: {
                        screen.append("3");
                        break;
                    }
                    case KeyEvent.VK_4: {
                        screen.append("4");
                        break;
                    }
                    case KeyEvent.VK_5: {
                        screen.append("5");
                        break;
                    }
                    case KeyEvent.VK_6: {
                        screen.append("6");
                        break;
                    }
                    case KeyEvent.VK_7: {
                        screen.append("7");
                        break;
                    }
                    case KeyEvent.VK_8: {
                        screen.append("8");
                        break;
                    }
                    case KeyEvent.VK_9: {
                        screen.append("9");
                        break;
                    }
                    case KeyEvent.VK_BACK_SPACE: {

                        if (!screen.getText().isEmpty()) {
                            if (screen.getText().equals("Err")) {
                                screen.setText("");
                            } else {
                                String now = screen.getText().substring(0, screen.getText().length() - 1);
                                screen.setText(now);
                            }
                        }

                        break;
                    }
                    case KeyEvent.VK_NUMPAD1: {
                        screen.append("1");
                        break;
                    }
                    case KeyEvent.VK_NUMPAD0: {
                        screen.append("0");
                        break;
                    }
                    case KeyEvent.VK_NUMPAD2: {
                        screen.append("2");
                        break;
                    }
                    case KeyEvent.VK_NUMPAD3: {
                        screen.append("3");
                        break;
                    }
                    case KeyEvent.VK_NUMPAD4: {
                        screen.append("4");
                        break;
                    }
                    case KeyEvent.VK_NUMPAD5: {
                        screen.append("5");
                        break;
                    }
                    case KeyEvent.VK_NUMPAD6: {
                        screen.append("6");
                        break;
                    }
                    case KeyEvent.VK_NUMPAD7: {
                        screen.append("7");
                        break;
                    }
                    case KeyEvent.VK_NUMPAD8: {
                        screen.append("8");
                        break;
                    }
                    case KeyEvent.VK_NUMPAD9: {
                        screen.append("9");
                        break;
                    }
                    case KeyEvent.VK_MULTIPLY: {
                        Multiply();
                        break;
                    }
                    case KeyEvent.VK_DIVIDE: {
                        Division();
                        break;
                    }
                    case KeyEvent.VK_ADD: {
                        Addition();
                        break;
                    }
                    case KeyEvent.VK_SUBTRACT: {
                        Substraction();
                        break;
                    }
                    case KeyEvent.VK_ENTER: {
                        Evaluate();
                        break;
                    }
                    case KeyEvent.VK_ESCAPE: {
                        System.exit(0);
                    }

                }
            }
        });
    }

    void Multiply() {

        try {
            String strng = screen.getText();
            char c = strng.charAt(strng.length() - 1);
            if (!(c == '+' || c == '-' || c == '/' || c == '*')) {
                screen.append("*");
            }
        } catch (Exception ex) {
        }

    }

    void Addition() {
        try {
            String strng = screen.getText();
            char c = strng.charAt(strng.length() - 1);
            if (!(c == '+' || c == '-' || c == '/' || c == '*')) {
                screen.append("+");
            }
        } catch (Exception ee) {
        }
    }

    void Substraction() {

        try {
            String strng = screen.getText();
            char c = strng.charAt(strng.length() - 1);

            if (!(c == '+' || c == '-' || c == '/' || c == '*')) {
                screen.append("-");
            }
        } catch (Exception xx) {
        }
    }

    void Division() {
        try {
            String strng = screen.getText();
            char c = strng.charAt(strng.length() - 1);
            if (!(c == '+' || c == '-' || c == '/' || c == '*')) {
                screen.append("/");
            }
        } catch (Exception ex) {
        }
    }

    void Evaluate() {
        try {

            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            String equation = screen.getText();

            try {
                screen.setText(engine.eval(equation).toString());
            } catch (Exception e1) {
                screen.setText("Err");
            }
        } catch (Exception ee) {

        }
    }
}