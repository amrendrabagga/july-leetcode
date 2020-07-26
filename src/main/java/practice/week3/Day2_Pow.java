package practice.week3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Day2_Pow {
    public double myPow(double x, int n) {
        BigDecimal bd = BigDecimal.valueOf(Math.pow(x, n));
        bd.setScale(5, RoundingMode.FLOOR);
        return bd.doubleValue();
    }
}
