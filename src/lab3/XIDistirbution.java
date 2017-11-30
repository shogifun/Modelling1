package lab3;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 29.10.2017
 */
public class XiDistirbution extends AbstractDistribution {
    private int m;
    private NormalDistribution distribution = new NormalDistribution(0, 1, 192);

    public XiDistirbution(int m) {
        this.m = m;
    }


    @Override
    public double getNext() {
        double res = 0;
        for (int i = 0; i < m; i++) {
            double tmp = distribution.getNext();
            res += tmp * tmp;
        }
        return res;
    }

    @Override
    public double getE() {
        return m;
    }

    @Override
    public double getD() {
        return 2 * m;
    }
}
