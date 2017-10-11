package lab2;

import java.util.ArrayList;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 08.10.2017
 */
public class Start {
    public static void main(String... arg) {
        /*double [] pi = {0.5, 0, 0.5};
        double [][] p = {
                {0.75, 0, 0.25},
                {0.3, 0.5, 0.2},
                {0.2, 0.2, 0.6}
        };
        MarcovGenerator chain = new MarcovGenerator(pi, p);
        System.out.println(chain.getCurrent());
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i< 1000; i++)
        {
            values.add(chain.getNext());
        }
        long zero = values.stream()
                .filter(i-> i==0)
                .count();
        long one = values.stream()
                .filter(i-> i==1)
                .count();
        long two = values.stream()
                .filter(i-> i==2)
                .count();

        System.out.println(zero);
        System.out.println(one);
        System.out.println(two);*/
        ReverseBinomialGenerator generator = new ReverseBinomialGenerator(6, 0.75);
        int sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum += generator.getNext();
        }
        System.out.println((double) sum / 100000);
    }
}
