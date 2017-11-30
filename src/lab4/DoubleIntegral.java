package lab4;

import java.util.Random;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 27.11.2017
 */
public class DoubleIntegral {
    public static void main(String[] args) {
        for (int i = 1000; i < 10000000; i += 1000000) {
            System.out.println(calculateDoubleIntegral(i));
        }
    }

    public static double calculateDoubleIntegral(int n) {
        double sum = 0;
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            double x0 = -1.5 * Math.sqrt(2) + 3 * Math.sqrt(2) * r.nextDouble();
            double y0 = -1.5 * Math.sqrt(2) + 3 * Math.sqrt(2) * r.nextDouble();
            double x = (x0 + y0) / Math.sqrt(2);
            double y = (x0 - y0) / Math.sqrt(2);
            sum += 18 * f1(x, y);
        }
        return sum / (double) n;
    }

    public static double f(double x, double y) {
        return (4 + x) * Math.log(5 + y) / (x * x + y * y + 1);
    }

    private static double f1(double x, double y) {
        return x * y;
    }
}
