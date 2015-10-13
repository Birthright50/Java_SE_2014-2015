/**
 * Created by Birthright on 13.10.2015.
 */
public class CustomsCalculatorHelper {
    public static Double getInfo(String cm, String year, String price) {
        Integer capacity = Integer.parseInt(cm);
        if (price != null && year.equals("1")) {
            Integer prc = Integer.parseInt(price);
            if (prc < 8500) {
                return 2.5 * capacity;
            } else {
                if (prc < 16700) {
                    return 3.5 * capacity;
                } else {
                    if (prc < 42300) {
                        return 5.5 * capacity;
                    } else {
                        if (prc < 84500) {
                            return 7.5 * capacity;
                        } else {
                            if (prc < 169000) {
                                return 15.0 * capacity;
                            } else {
                                return 20.0 * capacity;
                            }
                        }
                    }
                }
            }
        }
        if (capacity < 1000) {
            switch (year) {
                case "2":
                    return 1.5 * capacity;

                case "3":
                    return 3.0 * capacity;

            }
        }
        if (capacity < 1500) {
            switch (year) {
                case "2":
                    return 1.7 * capacity;

                case "3":
                    return 3.2 * capacity;

            }
        }
        if (capacity < 1800) {
            switch (year) {
                case "2":
                    return 2.5 * capacity;

                case "3":
                    return 3.5 * capacity;

            }
        }
        if (capacity < 2300) {
            switch (year) {
                case "2":
                    return 2.7 * capacity;

                case "3":
                    return 4.8 * capacity;

            }
        }
        if (capacity < 3000) {
            switch (year) {
                case "2":
                    return 3.0 * capacity;

                case "3":
                    return 5.0 * capacity;

            }
        }
        switch (year) {
            case "2":
                return 3.6 * capacity;
            case "3":
                return 5.7 * capacity;
            default:
                return null;
        }


    }
}
