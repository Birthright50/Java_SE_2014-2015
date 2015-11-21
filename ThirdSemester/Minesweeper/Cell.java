import javax.swing.*;

/**
 * Created by Birthright on 20.11.2015.
 */
public class Cell {
    private int mineCount;
    private JButton button;

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public Cell() {
        mineCount = 0;
        isFlagged = false;
        isOpen = false;
        isMine = false;
        button = new JButton();
    }

    private boolean isMine;
    private boolean isFlagged;
    private boolean isOpen;

    public int getMineCount() {
        return mineCount;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setIsFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
}
