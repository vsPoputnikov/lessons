package lesson10.shop;

public class User {
    String login;
    String pwd;
    double balance;

    public Cart getCart() {
        return cart;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private Cart cart;

    public void regCart(Cart cart){
        this.cart = cart;
    }

    public User(String login, String pwd, double balance) {
        this.login = login;
        this.pwd = pwd;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        User user = (User) object;

        if (Double.compare(user.balance, balance) != 0) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return pwd != null ? pwd.equals(user.pwd) : user.pwd == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public double getBalance() {
        return balance;
    }
}
