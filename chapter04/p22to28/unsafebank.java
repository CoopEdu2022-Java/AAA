
public class unsafebank {
    public static void main(String[] args) {
        Account account = new Account(100, "cash");
        Drawing you = new Drawing(account, 50, "You");
        Drawing gf = new Drawing(account, 100, "gf");
        you.start();
        gf.start();
    }
}

class Account {
    int Money;
    String name;

    public Account(int Money, String name) {
        this.Money = Money;
        this.name = name;
    }
}

class Drawing extends Thread {

    public void run() {
        synchronized (account) {
            if (account.Money < drawingMoney) {
                System.out.println("Not enough money");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            account.Money = account.Money - drawingMoney;
            nowMoney += drawingMoney;
            System.out.println(account.name + ":" + account.Money);
            System.out.println(currentThread().getName() + ":" + nowMoney);
        }
    }

    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
}
