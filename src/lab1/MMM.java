package lab1;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 06.09.2017
 */
public class MMM extends Generator {
    private MKM b;
    private MKM c;
    private ArrayList<Double> values = new ArrayList<>();
    private int k;

    public MMM(MKM b, MKM c, int k)
    {
        this.b = b;
        this.c = c;
        this.k = k;
    }

    @Override
    public void generate(int n) {
        values.clear();
        b.generate(n + k);
        c.generate(n);
        ArrayList<Double> v = new ArrayList<>();
        b.getValues().remove(0);
        b.getValues().forEach(v::add);
        c.getValues().remove(0);
        for (int i = 0; i < n; i++)
        {
            int s = (int) Math.floor(c.getElement(i) * k);
            values.add(v.get(s));
            v.set(s, b.getElement(i + k));
        }
    }

    @Override
    public double getElement(int i) {
        return values.get(i);
    }

    public double getAverage()
    {
        Optional<Double> res = values.stream().reduce((d1, d2) -> d1 + d2);
        return res.get() / values.size();
    }
}
