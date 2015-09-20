import java.util.regex.Pattern;

/**
 * Created by Birthright on 17.09.2015.
 */
public class Task01a {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("0|([+-]?[1-9][0-9]*(\\.(([0-9]*[1-9])|([0-9]+([eE][-+]?[0-9]+))|([0-9]*\\([0-9]*[1-9]\\))))?)|" +
                "([+-]?0(\\.(([0-9]*[1-9])|([0-9]+([eE][-+]?[0-9]+))|([0-9]*\\([0-9]*[1-9]\\)))))");
        System.out.println(pattern.matcher("0").matches());
        System.out.println(pattern.matcher("-6").matches());
        System.out.println(pattern.matcher("-0.5").matches());
        System.out.println(pattern.matcher("+2").matches());
        System.out.println(pattern.matcher("0.0(64)").matches());
        System.out.println(pattern.matcher("-0").matches());
        System.out.println(pattern.matcher("001").matches());
        System.out.println(pattern.matcher("0.(35)00").matches());
        System.out.println(pattern.matcher("-3.750").matches());
    }
}
