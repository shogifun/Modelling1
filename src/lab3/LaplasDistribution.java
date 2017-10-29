package lab3;

import java.util.Random;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 29.10.2017
 */
public class LaplasDistribution extends AbstractDistribution {
    private double a;
    private Random r = new Random(System.currentTimeMillis());

    public LaplasDistribution(double a) {
        this.a = a;
    }

    @Override
    public double getNext() {
        double y = r.nextDouble();
        if (y < 0.5) {
            return 1 / a * Math.log(2 * y);
        } else {
            return -1 / a * Math.log(2 * (1 - y));
        }
    }

    @Override
    public double getE() {
        return 0;
    }

    @Override
    public double getD() {
        return 2 / (a * a);
    }
}
