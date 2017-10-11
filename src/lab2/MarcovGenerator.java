package lab2;

import java.util.Random;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 08.10.2017
 */
public class MarcovGenerator {
    private double[][] q;
    private int current;
    private Random r;

    public MarcovGenerator(double[] pi, double[][] p) {
        r = new Random();
        double a = r.nextDouble();
        for (int i = 1; i < pi.length; i++) {
            if ((pi[i] > a) && (pi[i - 1] <= a)) {
                current = i - 1;
            }
        }
        q = new double[p.length][p.length + 1];
        for (int i = 0; i < p.length; i++) {
            q[i][0] = 0;
            for (int j = 1; j <= q.length; j++) {
                q[i][j] = q[i][j - 1] + p[i][j - 1];
            }
        }
    }

    public int getCurrent() {
        return current;
    }

    public int getNext() {
        double a = r.nextDouble();
        for (int i = 0; i < q.length; i++) {
            if ((q[current][i] <= a) && (q[current][i + 1] > a)) {
                current = i;
            }
        }
        return current;
    }
}
