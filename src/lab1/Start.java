package lab1;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 06.09.2017
 */
public class Start {
    public static void main(String ... args)
    {
        MKM generatorB = new MKM(445423, 90474281);
        MKM generatorC = new MKM(275803775, 42062397);
        MMM generator = new MMM(generatorB, generatorC, 160);
        generatorB.generate(1000);
        int [] indexes = {1, 15, 100, 900, 1000};
        System.out.println("MKM generator:");
        for (int i : indexes)
        {
            System.out.println(i + " - " + generatorB.getElement(i));
        }
        System.out.println("Moments test - " + Tests.momentsTest(generatorB, 1000, 0.05));
        generator.generate(1000);
        System.out.println("MMM generator:");
        for (int i : indexes) {
            System.out.println(i + " - " + generator.getElement(i - 1));
        }
        System.out.println("Moments test - " + Tests.momentsTest(generatorB, 1000, 0.05));
        System.out.println(generatorB.getPeriod());
        generatorB.generate(10000);
        System.out.println(generatorB.getDataForDiagramm());
    }
}
