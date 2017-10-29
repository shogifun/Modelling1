package lab3;

import java.util.Random;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 29.10.2017
 */
public class ExponentialDistribution extends AbstractDistribution {
    private double lambda;
    private Random r = new Random();

    public ExponentialDistribution(double lambda) {
        this.lambda = lambda;
    }

    @Override
    public double getNext() {
        double y = r.nextDouble();
        return -1 / lambda * Math.log(1 - y);
    }

    @Override
    public double getE() {
        return 1 / lambda;
    }

    @Override
    public double getD() {
        return 1 / (lambda * lambda);
    }
}
