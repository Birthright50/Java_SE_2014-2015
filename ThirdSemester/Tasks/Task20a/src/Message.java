import java.io.Serializable;
import java.util.Date;

/**
 * Created by Birthright on 15.11.2015.
 */
public class Message implements Serializable {
    private String message;
    private String date;
    private String name;
    private int count;

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message1 = (Message) o;

        return !(message != null ? !message.equals(message1.message) : message1.message != null) && !(date != null ? !date.equals(message1.date) : message1.date != null) && !(name != null ? !name.equals(message1.name) : message1.name != null);

    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return date + " " + name + ": " + message;
    }

    public Message(String name, String message, int count) {
        this.name = name;
        this.message = message;
        this.count = count;
        date = Server.simpleDateFormat.format(new Date());
    }
}
