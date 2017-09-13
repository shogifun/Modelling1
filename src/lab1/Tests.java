package lab1;

import org.apache.commons.math3.special.Erf;

import java.util.Random;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 07.09.2017
 */
public class Tests {
    public static <T extends Generator> boolean momentsTest(T generator, int n, double eps)
    {
        generator.generate(n);
        double m = 0;
        double s = 0;
        for (int i = 1;i<= n; i++)
        {
            m += generator.getElement(i);
        }
        m /= n;
        for (int i = 0; i <= n; i++)
        {
            s += (generator.getElement(i) - m) * (generator.getElement(i) - m);
        }
        s /= n - 1;
        double xi1 = Math.abs(m - 0.5);
        double xi2 = Math.abs(s - (1 / 12));
        double p1 = 2 * (1 - fi(c1(n) * xi1));
        double p2 = 2 * (1 - fi(c2(n) * xi2));
        boolean r1 = eps < p1;
        boolean r2 = eps < p2;
        return r1 && r2;
    }

    private static double fi(double x)
    {
        return 0.5 * (1 + Erf.erf(x / Math.sqrt(2)));
    }

    private static double c1(int n)
    {
        return Math.sqrt(12 * n);
    }

    private static double c2(int n)
    {
        return (n - 1) / n / Math.sqrt(0.0056 / n + 0.0028 / n /n - 0.0083 / n / n / n);
    }
}
