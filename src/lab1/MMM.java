package lab1;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 06.09.2017
 */
public class MMM extends Generator {
    private MKM b;
    private MKM c;
    private ArrayList<Double> values = new ArrayList<>();
    private int K;

    public MMM(MKM b, MKM c, int k)
    {
        this.b = b;
        this.c = c;
        K = k;
    }

    @Override
    public void generate(int n) {
        values.clear();
        b.generate(n);
        c.generate(n);
        ArrayList<Double> v = new ArrayList<>();
        for(int i = 0; i< K; i++)
        {
            v.add(b.getElement(i));
        }

        for(int i = 0; i<= n; i++)
        {
            int s =(int)Math.floor(c.getElement(i) * K / 4294967296L);
            values.add(v.get(s));
            v.set(s, b.getElement(i));
        }
    }

    @Override
    public double getElement(int i) {
        return values.get(i);
    }

    public double getAverage()
    {
        double res = 0;
        for (int i = 1; i<= 1000; i++)
        {
            res+= values.get(i);
        }
        return res/1000;
    }
}
