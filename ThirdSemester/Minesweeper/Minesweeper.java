import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Created by Birthright on 20.11.2015.
 */
public class Minesweeper extends JFrame {
    private int size;
    private int minesNumber;
    private final int buttonSize = 50;
    private Cell[][] cells;
    final int messageType = JOptionPane.QUESTION_MESSAGE;
    String[] options = {"OK"};
    private int cellsOpen = 0;
    private int cellsFlagged = 0;

    public Minesweeper(int s, int i1) {
        size = s;
        minesNumber = i1;
        setLayout(new GroupLayout(getContentPane()));
        generateField();


        setBounds(0, 0, buttonSize * size + 50, buttonSize * size + 50);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private int countMinesAround(int x, int y) {
        int s = 0;
        for (int i = -1; i <= 1; i++) {
            if (x + i >= 0 && x + i < size) {
                for (int j = -1; j <= 1; j++) {
                    if (y + j >= 0 && y + j < size) {
                        if (cells[x + i][y + j].isMine()) {
                            s++;
                        }
                    }
                }
            }
        }
        return s;
    }

    public void findEmptyCells(int i, int j) {

        if (i >= 0 && j >= 0 && i <= 9 && j <= 9) {
            if (cells[i][j].getMineCount() == 0 && !cells[i][j].isMine() && !cells[i][j].isFlagged() && cells[i][j].getButton().isEnabled()) {
                JButton jb = cells[i][j].getButton();
                jb.setText(0 + "");
                jb.setEnabled(false);
                if (!cells[i][j].isOpen()) {
                    cellsOpen++;
                    cells[i][j].setIsOpen(true);
                }
                findEmptyCells(i - 1, j);
                findEmptyCells(i + 1, j);
                findEmptyCells(i, j + 1);
                findEmptyCells(i, j - 1);
                findEmptyCells(i - 1, j + 1);
                findEmptyCells(i + 1, j + 1);
                findEmptyCells(i - 1, j - 1);
                findEmptyCells(i + 1, j - 1);


            } else {
                if (cells[i][j].getMineCount() > 0) {
                    JButton jb = cells[i][j].getButton();
                    jb.setText(cells[i][j].getMineCount() + "");
                    jb.setEnabled(false);
                    if (!cells[i][j].isOpen()) {
                        cellsOpen++;
                        cells[i][j].setIsOpen(true);
                    }

                }
            }
        }
    }

    private void removeButtons() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                remove(cells[i][j].getButton());
            }
        }
    }

    private void openMines() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                JButton jButton = cells[i][j].getButton();
                jButton.setEnabled(false);
                if (cells[i][j].isMine()) {
                    jButton.setText("X");
                }
            }
        }
    }

    private void restart() {
        setVisible(false);
        removeButtons();
        generateField();
        cellsOpen = 0;
        cellsFlagged = 0;
        setVisible(true);
    }

    private void generateField() {
        cells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
                JButton jButton = cells[i][j].getButton();

                jButton.setBounds(j * buttonSize, i * buttonSize, buttonSize, buttonSize);
                jButton.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            JButton jb1 = (JButton) e.getSource();
                            int x = jb1.getX() / buttonSize;
                            int y = jb1.getY() / buttonSize;
                            if (!jb1.getText().equals("P")) {
                                if (cells[y][x].isMine()) {
                                    jb1.setText("X");
                                    openMines();
                                    int code = JOptionPane.showOptionDialog(Minesweeper.this, "Game Over", "You lose!", 0, messageType, null, options, "");
                                    if (code == 0) {
                                        restart();
                                        return;
                                    }
                                } else {
                                    int count = cells[y][x].getMineCount();
                                    cells[y][x].setMineCount(count);
                                    jb1.setText(count + "");
                                    if (count == 0) {
                                        findEmptyCells(y, x);
                                    } else {
                                        cellsOpen++;
                                        cells[y][x].setIsOpen(true);
                                    }

                                }
                                jb1.setEnabled(false);
                                if (cellsOpen == size * size - minesNumber && cellsFlagged == minesNumber) {
                                    int code = JOptionPane.showOptionDialog(Minesweeper.this, "Congratulations!", "You won!", 0, messageType, null, options, "");
                                    if (code == 0) {
                                        restart();
                                        return;
                                    }
                                }
                            }
                        }
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            JButton jButton1 = (JButton) e.getSource();
                            if (jButton1.isEnabled()) {
                                if (jButton1.getText().equals("P")) {
                                    jButton1.setText("");
                                    cellsFlagged--;
                                } else {
                                    jButton1.setText("P");
                                    cellsFlagged++;
                                    if (cellsOpen == size * size - minesNumber && cellsFlagged == minesNumber) {
                                        int code = JOptionPane.showOptionDialog(Minesweeper.this, "Congratulations!", "You won!", 0, messageType, null, options, "");
                                        if (code == 0) {
                                            restart();
                                        }
                                    }
                                }
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                add(jButton);
            }
        }

        Random r = new Random();
        int k = 0;
        while (k < minesNumber) {
            int i = r.nextInt(size);
            int j = r.nextInt(size);
            if (!cells[i][j].isMine()) {
                cells[i][j].setIsMine(true);
                k++;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j].setMineCount(countMinesAround(i, j));
            }
        }
    }

    public static void main(String[] args) {
        new Minesweeper(10, 10);
    }
}
