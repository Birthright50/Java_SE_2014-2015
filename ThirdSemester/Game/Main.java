import javax.swing.*;
import java.awt.*;

/**
 * Created by Birthright on 21.11.2015.
 */
public class Main {
    private JLabel black, white;

    public static void main(String[] args) {
        new Main().init();
    }

    private void init() {
        JFrame f = new JFrame();

        JPanel container = new JPanel();
        container.setBackground(Color.ORANGE);
        container.setLayout(new BorderLayout(50, 50));
        JButton btnPass = new JButton("Pass");

        btnPass.setBackground(Color.RED);
        btnPass.addActionListener(e -> {
            //TODO
        });
        container.add(btnPass, BorderLayout.PAGE_START);
        black = new JLabel("Black points (enemy) : 0.0");
        white = new JLabel("White points (you) : 5.5");
        container.add(black, BorderLayout.LINE_START);
        container.add(white, BorderLayout.LINE_END);
        f.add(container);

        GameBoard board = new GameBoard();
        container.add(board);


        f.pack();
        f.setResizable(false);
        f.setVisible(true);
    }
}
