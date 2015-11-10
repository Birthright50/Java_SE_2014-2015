package ru.kpfu.itis.peter_kozlovsky.helpers;

/**
 * Created by Birthright on 13.10.2015.
 */
public class CustomsCalculatorHelper {
    public static Double getInfo(String cm, String year, String price) {
        Integer capacity = Integer.parseInt(cm);
        if (year.equals("1")) {
            Double prc = Double.parseDouble(price);
            if (prc < 8500) {
                return HPCalculatorInfo.round(69.1515386 * 2.5 * capacity, 2);
            } else {
                if (prc < 16700) {
                    return HPCalculatorInfo.round(69.1515386 * 3.5 * capacity, 2);
                } else {
                    if (prc < 42300) {
                        return HPCalculatorInfo.round(69.1515386 * 5.5 * capacity, 2);
                    } else {
                        if (prc < 84500) {
                            return HPCalculatorInfo.round(69.1515386 * 7.5 * capacity, 2);
                        } else {
                            if (prc < 169000) {
                                return HPCalculatorInfo.round(69.1515386 * 15.0 * capacity, 2);
                            } else {
                                return HPCalculatorInfo.round(69.1515386 * 20.0 * capacity, 2);
                            }
                        }
                    }
                }
            }
        }
        if (capacity < 1000) {
            switch (year) {
                case "2":
                    return HPCalculatorInfo.round(69.1515386 * 1.5 * capacity, 2);
                case "3":
                    return HPCalculatorInfo.round(69.1515386 * 3.0 * capacity, 2);
            }
        }
        if (capacity < 1500) {
            switch (year) {
                case "2":
                    return HPCalculatorInfo.round(69.1515386 * 1.7 * capacity, 2);
                case "3":
                    return HPCalculatorInfo.round(69.1515386 * 3.2 * capacity, 2);

            }
        }
        if (capacity < 1800) {
            switch (year) {
                case "2":
                    return HPCalculatorInfo.round(69.1515386 * 2.5 * capacity, 2);
                case "3":
                    return HPCalculatorInfo.round(3.5 * capacity * 69.1515386, 2);

            }
        }
        if (capacity < 2300) {
            switch (year) {
                case "2":
                    return HPCalculatorInfo.round(69.1515386 * 2.7 * capacity, 2);
                case "3":
                    return HPCalculatorInfo.round(69.1515386 * 4.8 * capacity, 2);

            }
        }
        if (capacity < 3000) {
            switch (year) {
                case "2":
                    return HPCalculatorInfo.round(69.1515386 * 3.0 * capacity, 2);
                case "3":
                    return HPCalculatorInfo.round(69.1515386 * 5.0 * capacity, 2);
            }
        }
        switch (year) {
            case "2":
                return HPCalculatorInfo.round(69.1515386 * 3.6 * capacity, 2);
            case "3":
                return HPCalculatorInfo.round(69.1515386 * 5.7 * capacity, 2);
            default:
                return null;
        }


    }
}
