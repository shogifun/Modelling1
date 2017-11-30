package lab4;

import lab2.MarcovGenerator;
import lab3.ExponentialDistribution;
import lab3.Utils;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 23.11.2017
 */
public class MonteCarloUtils {
    public static void main(String[] args) {

        //Utils.calculateDispersionAndE(1000, new ExponentialDistribution(1));
        //System.out.println("real value - " + Math.sqrt(Math.PI) / 2);
        //System.out.println(calculateSecondIntegral(i) -  Math.sqrt(Math.PI) / 2);
        double[][] a = new double[2][2];
        a[0][0] = -0.1;
        a[0][1] = 0.8;
        a[1][0] = 0.4;
        a[1][1] = -0.1;
        double[] f = new double[2];
        f[0] = 0.1;
        f[1] = -0.2;
        solveSLAU(a, f, 100000, 1000);

    }

    public static double calculateFisrtIntegral(int n) {
        Random r = new Random();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += calculateFisrtElement(r);
        }
        return sum / (double) n;
    }

    private static double calculateFisrtElement(Random r) {
        double a = 0;
        double b = Math.PI;
        double psi = r.nextDouble() * b + a;
        return (Math.pow(psi * 2 * Math.sin(psi), 2)) * (b - a);
    }

    public static double calculateSecondIntegral(int n) {
        double sum = 0;
        ExponentialDistribution distribution = new ExponentialDistribution(1);
        for (int i = 0; i < n; i++) {
            double tmp = distribution.getNext();
            sum += Math.pow(Math.E, -1 * tmp * tmp + tmp);
        }
        return sum / (double) n;
    }

    public static void solveSLAU(double[][] a, double[] f, int m, int size) {
        int n = f.length;
        double[] result = new double[n];
        double[] pi = new double[n];
        for (int i = 0; i < n; i++) {
            pi[i] = 1 / (double) n;
        }
        double[][] p = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = 1 / (double) n;
            }
        }
        for (int k = 0; k < n; k++) {
            double res = 0;
            int[] h = new int[n];
            h[k] = 1;
            MarcovGenerator generator = new MarcovGenerator(pi, p);
            for (int i = 0; i < m; i++) {
                int[] chain = generator.getChain(size + 1);
                double[] q = new double[size + 1];
                if (pi[chain[0]] > 0) q[0] = h[chain[0]] / pi[chain[0]];
                else q[0] = 0;
                res += q[0] * f[chain[0]];
                for (int j = 1; j <= size; j++) {
                    if (p[chain[j - 1]][chain[j]] > 0)
                        q[j] = q[j - 1] * a[chain[j - 1]][chain[j]] / p[chain[j - 1]][chain[j]];
                    else q[j] = 0;
                    res += q[j] * f[chain[j]];
                }
            }
            res /= m;
            result[k] = res;
        }
        System.out.println(Arrays.toString(result));
    }

}
