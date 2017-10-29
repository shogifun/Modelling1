package lab3;

import java.util.Random;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 29.10.2017
 */
public class NormalDistribution extends AbstractDistribution {
    private double mu;
    private double sigma;
    private int N;
    private Random r = new Random(System.currentTimeMillis());

    public NormalDistribution(double mu, double sigma, int n) {
        this.mu = mu;
        this.sigma = sigma;
        N = n;
    }

    private double getNormalValue() {
        double a = 0;
        for (int i = 0; i < N; i++) {
            a += r.nextDouble();
        }
        a -= (double) N / 2.0;
        return a * Math.sqrt(12.0 / (double) N);
    }

    public double getNext() {
        double normal = getNormalValue();
        return mu + normal * sigma;
    }

    @Override
    public double getE() {
        return mu;
    }

    @Override
    public double getD() {
        return sigma * sigma;
    }
}
