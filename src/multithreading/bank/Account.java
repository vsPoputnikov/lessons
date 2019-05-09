package multithreading.bank;

public class Account {
    //id
    private int id;
    //user
    private String user;
    //money
    private int money;

    public Account(int id, String user, int money) {
        this.id = id;
        this.user = user;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
//Bank
//transferMoney(Account src, Account dst, int money)
//Transaction.start();
// Transaction(поток)


