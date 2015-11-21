import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Created by Birthright on 18.11.2015.
 */
public class Calculator implements ActionListener {
    JFrame f;
    JTextField jTextField;
    static JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdiv, bmul, bsub, badd, bdec, beq, bdel, bclr;

    static double a = 0, b = 0, result = 0;
    static String operator;

    public Calculator() {
        f = new JFrame("Calculator");
        jTextField = new JTextField();
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bdiv = new JButton("/");
        bmul = new JButton("*");
        bsub = new JButton("-");
        badd = new JButton("+");
        bdec = new JButton(".");
        beq = new JButton("=");
        bdel = new JButton("Delete");
        bclr = new JButton("Clear");
        jTextField.setBounds(0, 0, 200, 30);
        b7.setBounds(0, 30, 50, 40);
        b8.setBounds(50, 30, 50, 40);
        b9.setBounds(100, 30, 50, 40);
        bdiv.setBounds(150, 30, 50, 40);
        b4.setBounds(0, 70, 50, 40);
        b5.setBounds(50, 70, 50, 40);
        b6.setBounds(100, 70, 50, 40);
        bmul.setBounds(150, 70, 50, 40);
        b1.setBounds(0, 110, 50, 40);
        b2.setBounds(50, 110, 50, 40);
        b3.setBounds(100, 110, 50, 40);
        bsub.setBounds(150, 110, 50, 40);
        bdec.setBounds(0, 150, 50, 40);
        b0.setBounds(50, 150, 50, 40);
        beq.setBounds(100, 150, 50, 40);
        badd.setBounds(150, 150, 50, 40);
        bdel.setBounds(0, 190, 100, 40);
        bclr.setBounds(100, 190, 100, 40);
        f.add(jTextField);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(bdiv);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(bmul);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(bsub);
        f.add(bdec);
        f.add(b0);
        f.add(beq);
        f.add(badd);
        f.add(bdel);
        f.add(bclr);
        f.setLayout(null);
        f.setSize(200, 260);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        badd.addActionListener(this);
        bdiv.addActionListener(this);
        bmul.addActionListener(this);
        bsub.addActionListener(this);
        bdec.addActionListener(this);
        beq.addActionListener(this);
        bdel.addActionListener(this);
        bclr.addActionListener(this);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            jTextField.setText(jTextField.getText().concat("1"));
            return;
        }
        if (e.getSource() == b2) {
            jTextField.setText(jTextField.getText().concat("2"));
            return;
        }
        if (e.getSource() == b3) {
            jTextField.setText(jTextField.getText().concat("3"));
            return;
        }
        if (e.getSource() == b4) {
            jTextField.setText(jTextField.getText().concat("4"));
            return;
        }
        if (e.getSource() == b5) {
            jTextField.setText(jTextField.getText().concat("5"));
            return;
        }
        if (e.getSource() == b6) {
            jTextField.setText(jTextField.getText().concat("6"));
            return;
        }
        if (e.getSource() == b7) {
            jTextField.setText(jTextField.getText().concat("7"));
            return;
        }
        if (e.getSource() == b8) {
            jTextField.setText(jTextField.getText().concat("8"));
            return;
        }
        if (e.getSource() == b9) {
            jTextField.setText(jTextField.getText().concat("9"));
            return;
        }
        if (e.getSource() == b0) {
            jTextField.setText(jTextField.getText().concat("0"));
            return;
        }
        if (e.getSource() == bdec) {
            jTextField.setText(jTextField.getText().concat("."));
            return;
        }

        if (e.getSource() == badd) {
            operator = "\\+";
            jTextField.setText(jTextField.getText().concat("+"));
            return;
        }

        if (e.getSource() == bsub) {

            operator = "-";
            jTextField.setText(jTextField.getText().concat("-"));
            return;
        }

        if (e.getSource() == bmul) {

            operator = "\\*";
            jTextField.setText(jTextField.getText().concat("*"));
            return;
        }

        if (e.getSource() == bdiv) {
            operator = "/";
            jTextField.setText(jTextField.getText().concat("/"));
            return;
        }


        if (e.getSource() == beq) {
            String[] numbers = jTextField.getText().split(operator);
            System.out.println(Arrays.toString(numbers));
            a = Double.parseDouble(numbers[0]);
            b = Double.parseDouble(numbers[1]);
            System.out.println(a);
            System.out.println(b);
            switch (operator) {
                case "\\+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "\\*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
            }
            jTextField.setText("" + result);
            return;
        }

        if (e.getSource() == bclr) {
            jTextField.setText("");
            return;
        }
        if (e.getSource() == bdel) {
            String s = jTextField.getText();
            jTextField.setText("");
            for (int i = 0; i < s.length() - 1; i++)
                jTextField.setText(jTextField.getText() + s.charAt(i));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }


}
