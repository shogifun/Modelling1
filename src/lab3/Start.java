package lab3;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 29.10.2017
 */
public class Start {
    public static void main(String[] args) {
        AbstractDistribution normal1 = new XiDistirbution(4);
        AbstractDistribution normal2 = new LaplasDistribution(2);
        CombineDisturbution<AbstractDistribution, AbstractDistribution> combineDisturbution = new CombineDisturbution<>(normal1, normal2, 0.5);
        Utils.showTeorethical(combineDisturbution);
        Utils.calculateDispersionAndE(10000, combineDisturbution);
    }
}
