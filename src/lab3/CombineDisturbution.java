package lab3;

import java.util.Random;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 29.10.2017
 */
public class CombineDisturbution<T1 extends AbstractDistribution, T2 extends AbstractDistribution> extends AbstractDistribution {
    private T1 distribution1;
    private T2 distribution2;
    private double pi;
    private Random r = new Random();

    public CombineDisturbution(T1 distribution1, T2 distribution2, double pi) {
        this.distribution1 = distribution1;
        this.distribution2 = distribution2;
        this.pi = pi;
    }


    @Override
    public double getNext() {
        double a = r.nextDouble();
        return a < pi ? distribution1.getNext() : distribution2.getNext();
    }

    @Override
    public double getE() {
        return pi * distribution1.getE() + (1 - pi) * distribution2.getE();
    }

    @Override
    public double getD() {
        return pi * ((distribution1.getE() - getE()) * (distribution1.getE() - getE()) + distribution1.getD()) +
                (1 - pi) * ((distribution2.getE() - getE()) * (distribution2.getE() - getE()) + distribution2.getD());
    }
}
