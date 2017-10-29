package lab2;

import org.apache.commons.math3.special.Beta;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 12.10.2017
 */
public class Utils {
    public static <T extends DiscreteGenerator> double[] countF(int numberOfIterations, int maxCount, T generator) {
        double[] res = new double[maxCount + 1];
        double probabilityForOne = 1.0 / numberOfIterations;
        int overrKill = 0;
        for (int i = 0; i < numberOfIterations; i++) {
            int value = generator.getNext();
            if (value > maxCount) {
                overrKill++;
                continue;
            }
            for (int j = value; j <= maxCount; j++) {
                res[j] += probabilityForOne;
            }
        }
        System.out.println("Overlill " + overrKill);
        return res;
    }

    public static <T extends DiscreteGenerator> double calculateE(int iterations, T generator) {
        double sum = 0;
        for (int i = 0; i < iterations; i++) {
            sum += generator.getNext();
        }
        return sum / (double) iterations;
    }

    public static <T extends DiscreteGenerator> double calculateDispersion(int iterations, T generator) {
        double sum = 0;
        List<Double> values = new LinkedList<>();
        for (int i = 0; i < iterations; i++) {
            double tmp = generator.getNext();
            sum += tmp;
            values.add(tmp);
        }
        double e = sum / (double) iterations;
        double res = 0;
        for (double i : values) {
            res += (e - i) * (e - i);
        }
        return res / iterations;
    }

    public static double reverseBinomoalE(double r, double p) {
        return r * (1 - p) / p;
    }

    public static double reverseBinomialD(double r, double p) {
        return reverseBinomoalE(r, p) / p;
    }

    public static int[] composeDataForDiagrams(int n, DiscreteGenerator generator) {
        Map<Integer, Integer> values = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int v = generator.getNext();
            if (values.containsKey(v)) {
                values.put(v, 1 + values.get(v));
            } else {
                values.put(v, 0);
            }
        }
        int[] res = new int[20];
        values.forEach((key, value) ->
        {
            if (key < 20) {
                res[key] = value;
            }
        });
        return res;
    }

    public static int[] composeTeoreticalForDiagrams(double p, double r, int n) {
        int[] res = new int[20];
        double q = Beta.regularizedBeta(p, r, 1);
        res[0] = (int) (q * n);
        for (int i = 1; i < 20; i++) {
            res[i] = (int) ((Beta.regularizedBeta(p, r, i + 1) - Beta.regularizedBeta(p, r, i)) * n);
        }
        return res;
    }
}
