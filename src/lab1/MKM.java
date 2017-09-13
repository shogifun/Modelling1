package lab1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem Pesetsky
 * @sinse 06.09.2017
 */
public class MKM extends Generator {
    private final long M = 2147483648L;
    private List<Double> values = new ArrayList<>();
    private List<Long> tmpValues = new ArrayList<>();
    private long a0;
    private long beta;

    public MKM(long a0, long c1)
    {
        this.a0 = a0;
        beta = Math.max(c1, M - c1);
    }

    @Override
    public void generate(int n)
    {
        tmpValues.clear();
        values.clear();
        tmpValues.add(a0);
        double f = (double) a0 / M;
        values.add((double) a0 / M);
        for(int i = 1; i<=n;i++)
        {
            tmpValues.add((tmpValues.get(i - 1) * beta) % M);
            values.add((double) tmpValues.get(i) / M);
        }
    }

    @Override
    public double getElement(int n)
    {
        return values.get(n);
    }

    public double getAverage()
    {
        double res = 0;
        for (int i = 1; i<= 1000000; i++)
        {
            res+= values.get(i);
        }
        return res/1000000;
    }

    public List<Double> getValues() {
        return values;
    }
}
