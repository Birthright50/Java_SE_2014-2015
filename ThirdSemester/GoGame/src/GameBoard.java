import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Birthright on 04.12.2015.
 */
public class GameBoard extends JPanel {

    public static final int SIZE = 19;

    public static final int NUMBER_OF_TILES = SIZE - 1;
    public static final int TILE_SIZE = 40;
    public static final int BORDER_SIZE = TILE_SIZE;


    private StoneColor current_player;
    private Grid grid;
    private Point lastMove;

    public GameBoard() {
        this.setBackground(Color.ORANGE);
        grid = new Grid(SIZE);

        current_player = StoneColor.BLACK;

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {

                int row = Math.round((float) (e.getY() - BORDER_SIZE)
                        / TILE_SIZE);
                int col = Math.round((float) (e.getX() - BORDER_SIZE)
                        / TILE_SIZE);
                System.out.println(String.format("y: %d, x: %d", row, col));

                if (row >= SIZE || col >= SIZE || row < 0 || col < 0) {
                    return;
                }
                if (grid.isOccupied(row, col)) {
                    return;
                }
                grid.addStone(row, col, current_player);
                lastMove = new Point(col, row);

                if (current_player == StoneColor.BLACK) {
                    current_player = StoneColor.WHITE;
                } else {
                    current_player = StoneColor.BLACK;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        for (int i = 0; i < SIZE; i++) {
            g2.drawLine(BORDER_SIZE, i * TILE_SIZE + BORDER_SIZE, TILE_SIZE
                    * NUMBER_OF_TILES + BORDER_SIZE, i * TILE_SIZE + BORDER_SIZE);
        }
        for (int i = 0; i < SIZE; i++) {
            g2.drawLine(i * TILE_SIZE + BORDER_SIZE, BORDER_SIZE, i * TILE_SIZE
                    + BORDER_SIZE, TILE_SIZE * NUMBER_OF_TILES + BORDER_SIZE);
        }
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                StoneColor state = grid.getState(row, col);
                if (state != null) {
                    if (state == StoneColor.BLACK) {
                        g2.setColor(Color.BLACK);
                    } else {
                        g2.setColor(Color.WHITE);
                    }
                    g2.fillOval(col * TILE_SIZE + BORDER_SIZE - TILE_SIZE / 2,
                            row * TILE_SIZE + BORDER_SIZE - TILE_SIZE / 2,
                            TILE_SIZE, TILE_SIZE);
                }
            }
        }
        if (lastMove != null) {
            g2.setColor(Color.RED);
            g2.drawOval(lastMove.x * TILE_SIZE + BORDER_SIZE - TILE_SIZE / 2,
                    lastMove.y * TILE_SIZE + BORDER_SIZE - TILE_SIZE / 2,
                    TILE_SIZE, TILE_SIZE);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(NUMBER_OF_TILES * TILE_SIZE + BORDER_SIZE * 2,
                NUMBER_OF_TILES * TILE_SIZE + BORDER_SIZE * 2);
    }
}
