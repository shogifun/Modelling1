package lab3;

/**
 * Created by Artem Pesetsky
 *
 * @sinse 29.10.2017
 */
public class Start {
    public static void main(String[] args) {
        /*AbstractDistribution xiDistirbution = new XiDistirbution(4);
        AbstractDistribution laplasDistribution = new LaplasDistribution(2);
        AbstractDistribution normal = new NormalDistribution(0, 8, 192);
        System.out.println("Normal");
        Utils.showTeorethical(normal);
        Utils.calculateDispersionAndE(1000, normal);
        System.out.println("xi");
        Utils.showTeorethical(xiDistirbution);
        Utils.calculateDispersionAndE(1000, xiDistirbution);
        System.out.println("laplass");
        Utils.showTeorethical(laplasDistribution);
        Utils.calculateDispersionAndE(1000, laplasDistribution);
        System.out.println("combine");
        CombineDisturbution<AbstractDistribution, AbstractDistribution> combineDisturbution = new CombineDisturbution<>(xiDistirbution, laplasDistribution, 0.5);
        Utils.showTeorethical(combineDisturbution);
        Utils.calculateDispersionAndE(100000, combineDisturbution);
        Utils.calculateDispersionAndE(1000);*/
        Utils.showCorrelation(5000);
    }
}
