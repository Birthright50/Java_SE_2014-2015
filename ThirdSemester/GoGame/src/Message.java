import java.io.Serializable;

/**
 * Created by Birthright on 04.12.2015.
 */
public class Message implements Serializable {
    private boolean pass;
    private int x;
    private int y;

    public Message(boolean pass, int x, int y) {
        this.pass = pass;
        this.x = x;
        this.y = y;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
