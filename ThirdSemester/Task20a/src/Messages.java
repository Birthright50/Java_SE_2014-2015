import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by birthright on 18.11.15.
 */
public class Messages implements Serializable {
    ArrayList<Message> messages = new ArrayList<>();

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public Messages(ArrayList<Message> messages) {

        this.messages = messages;
    }
}
