package lab2;

import java.util.Random;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 08.10.2017
 */
public class BernuliGenerator extends DiscreteGenerator {
    private double p;
    private Random r;

    public BernuliGenerator(double p) {
        this.p = p;
        r = new Random(System.currentTimeMillis());
    }

    public double getNext() {
        double a = r.nextDouble();
        return a < p ? 1 : 0;
    }
}
