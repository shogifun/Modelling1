package lab3;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 29.10.2017
 */
public class Utils {
    //private static List<Double> values = new LinkedList<>();
    public static <T extends AbstractDistribution> double calculateE(int iterations, T generator) {
        double sum = 0;
        for (int i = 0; i < iterations; i++) {
            sum += generator.getNext();
        }
        return sum / (double) iterations;
    }

    public static <T extends AbstractDistribution> void calculateDispersionAndE(int iterations, T generator) {
        double sum = 0;
        List<Double> values = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            double tmp = generator.getNext();
            sum += tmp;
            values.add(tmp);
        }
        double e = sum / (double) iterations;
        System.out.println("Practice");
        System.out.println("E = " + e);
        double res = 0;
        for (double i : values) {
            res += (e - i) * (e - i);
        }
        System.out.println("D = " + res / (iterations - 1));
    }

    public static double[] composeNormal(int n) {
        Random random = new Random();
        double[] result = new double[n];
        for (int i = 0; i < n / 2; i++) {
            double phi = random.nextDouble();
            double r = random.nextDouble();
            result[2 * i] = Math.cos(2 * Math.PI * phi) * Math.sqrt(-2 * Math.log(r));
            result[2 * i + 1] = Math.sin(2 * Math.PI * phi) * Math.sqrt(-2 * Math.log(r));
        }
        return result;
    }

    public static void calculateDispersionAndE(int n) {
        double[] values = composeNormal(n);
        double e = 0;
        for (int i = 0; i < values.length; i++) {
            e += values[i];
        }
        e /= values.length;
        System.out.println("E = " + e);
        double d = 0;
        for (int i = 0; i < values.length; i++) {
            d += (values[i] - e) * (values[i] - e);
        }
        d /= values.length - 1;
        System.out.println("D = " + d);
    }

    public static void showTeorethical(AbstractDistribution distribution) {
        System.out.println("Teory: ");
        System.out.println("E = " + distribution.getE());
        System.out.println("D = " + distribution.getD());
    }

    public static void showCorrelation(int n) {
        double[] all = composeNormal(n * 2);
        double[] first = new double[n];
        double[] second = new double[n];
        double firstE = 0;
        double secondE = 0;
        double firstD = 0;
        double secondD = 0;
        for (int i = 0; i < n; i++) {
            first[i] = all[2 * i];
            firstE += all[2 * i];
            second[i] = all[2 * i + 1];
            secondE += all[2 * i + 1];
        }
        firstE /= first.length;
        secondE /= second.length;
        double sum = 0;
        for (int i = 0; i < first.length; i++) {
            double tmp = (first[i] - firstE) * (second[i] - secondE);
            sum += tmp;
            firstD += (first[i] - firstE) * (first[i] - firstE);
            secondD += (second[i] - secondE) * (second[i] - secondE);
        }
        firstD /= first.length - 1;
        secondD /= second.length - 1;
        System.out.println("Correlation " + sum / Math.sqrt(firstD) / Math.sqrt(secondD) / n);
    }
}
