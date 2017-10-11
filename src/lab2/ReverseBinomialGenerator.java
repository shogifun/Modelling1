package lab2;

import org.apache.commons.math3.special.Beta;

import java.util.Random;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 08.10.2017
 */
public class ReverseBinomialGenerator extends DiscreteGenerator {
    private Random random;
    private int r;
    private double p;

    public ReverseBinomialGenerator(int r, double p) {
        random = new Random();
        this.r = r;
        this.p = p;
    }

    public double getNext() {
        double a = random.nextDouble();
        double tmp1 = 0;
        int i = 1;
        double tmp2 = Beta.regularizedBeta(p, r, i + 1);
        while (true) {
            if ((a >= tmp1) && (a < tmp2)) {
                return i;
            } else {
                i++;
                tmp1 = tmp2;
                tmp2 = Beta.regularizedBeta(p, r, i + 1);
            }
        }
    }
}
