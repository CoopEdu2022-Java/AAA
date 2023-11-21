
public class CoinTester
{
    public static void main(String[] args) {

       
       int quarters=3;
       int dimes=2;
       int nickels=1;
       int pennies=4;
       Coins wallet= new Coins(quarters, dimes, nickels, pennies);
       
       
       wallet.bankValue();
       wallet.addQuarter();
       System.out.println(wallet.getQ());
       quarters = wallet.getQ();
       System.out.println(quarters);
    }
}
