package lab1;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 06.09.2017
 */
public class Start {
    public static void main(String ... args)
    {
        MKM generatorB = new MKM(174549961, 111437935);
        MKM generatorC = new MKM(102312981, 108500169);
        MMM generator = new MMM(generatorB, generatorC, 128);
        generatorB.generate(1000);
        generator.generate(1000);
        int [] indexes = {1, 15, 100, 900, 1000};
        System.out.println("MKM generator:");
        for (int i : indexes)
        {
            System.out.println(i + " - " + generatorB.getElement(i));
        }
        System.out.println("Moments test - " + Tests.momentsTest(generatorB, 1000, 0.05));
        System.out.println("MMM generator:");
        for (int i : indexes) {
            System.out.println(i + " - " + generatorB.getElement(i - 1));
        }
        System.out.println("Moments test - " + Tests.momentsTest(generatorB, 1000, 0.05));
    }
}
