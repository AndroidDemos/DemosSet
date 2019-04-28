package djc.myj;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by pl on 2017-08-14 10:13.
 */

public class MathUtils {

    public static String addArray(String[] strings) {
        BigDecimal bigDecimal = new BigDecimal("0");
        for (String str : strings) {
            BigDecimal bigDecimal1 = new BigDecimal(str);
            bigDecimal = bigDecimal.add(bigDecimal1);
        }
        return bigDecimal.toString();
    }

    public static String add(String s1, String s2) {
        return new BigDecimal(s1).add(new BigDecimal(s2)).toString();
    }

    public static String subtract(String s1, String s2) {
        return new BigDecimal(s1).subtract(new BigDecimal(s2)).toString();
    }

    public static String multiply(String s1, String s2) {
        return new BigDecimal(s1).multiply(new BigDecimal(s2)).toString();
    }

    public static String divide(String s1, String s2) {
        return new BigDecimal(s1).divide(new BigDecimal(s2), RoundingMode.HALF_EVEN).toString();
    }

    /**
     * 四舍五入
     *
     * @param value
     * @return
     */
    public static long round(double value) {
        if (value >= 0) {
            return (long) (value + 0.5);
        } else {
            return 0 - (long) (Math.abs(value) + 0.5);
        }
    }
}
