package lab2;

import org.apache.commons.math3.special.Beta;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 08.10.2017
 */
public class Start {
    public static void main(String... arg) {
        double[] pi = {0.5, 0, 0.5};
        double [][] p = {
                {0.75, 0, 0.25},
                {0.3, 0.5, 0.2},
                {0.2, 0.2, 0.6}
        };
        MarcovGenerator chain = new MarcovGenerator(pi, p);
        System.out.println("Start element " + chain.getCurrent());
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
        ReverseBinomialGenerator reverseBinomialGenerator = new ReverseBinomialGenerator(6, 0.75);

        System.out.println("0 -  " + zero);
        System.out.println("1 - " + one);
        System.out.println("2 - " + two);
        BernuliGenerator bernuliGenerator = new BernuliGenerator(0.3);
        System.out.println(Utils.calculateE(1000, bernuliGenerator));
        System.out.println(Utils.calculateDispersion(1000, bernuliGenerator));
        System.out.println(Utils.reverseBinomoalE(6, 0.75));
        System.out.println(Utils.reverseBinomialD(6, 0.75));
        System.out.println(Utils.calculateE(1000, reverseBinomialGenerator));
        System.out.println(Utils.calculateDispersion(10000, reverseBinomialGenerator));
        System.out.println("Practical distribution function" + Arrays.toString(Utils.countF(100, 10, reverseBinomialGenerator)));
        System.out.println("Teoretical");
        for (int i = 0; i < 10; i++) {
            System.out.print(Beta.regularizedBeta(0.75, 6, i + 1) + " , ");
        }
        System.out.println(Arrays.toString(Utils.composeDataForDiagrams(1000, reverseBinomialGenerator)));
        System.out.println(Arrays.toString(Utils.composeTeoreticalForDiagrams(0.75, 6, 1000)));
    }
}
