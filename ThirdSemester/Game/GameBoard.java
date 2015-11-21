import javax.swing.*;
import java.awt.*;

/**
 * Created by Birthright on 21.11.2015.
 */
public class GameBoard extends JPanel {

    public static final int SIZE = 19;

    public static final int N_OF_TILES = SIZE - 1;
    public static final int TILE_SIZE = 40;
    public static final int BORDER_SIZE = TILE_SIZE;

    public GameBoard() {
        this.setBackground(Color.ORANGE);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        for (int i = 0; i < SIZE; i++) {
            g2.drawLine(BORDER_SIZE, i * TILE_SIZE + BORDER_SIZE, TILE_SIZE
                    * N_OF_TILES + BORDER_SIZE, i * TILE_SIZE + BORDER_SIZE);
        }

        for (int i = 0; i < SIZE; i++) {
            g2.drawLine(i * TILE_SIZE + BORDER_SIZE, BORDER_SIZE, i * TILE_SIZE
                    + BORDER_SIZE, TILE_SIZE * N_OF_TILES + BORDER_SIZE);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(N_OF_TILES * TILE_SIZE + BORDER_SIZE * 2,
                N_OF_TILES * TILE_SIZE + BORDER_SIZE * 2);
    }

}
