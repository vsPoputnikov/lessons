package lesson10.shop;

public class Good {
    private String title;

    private double price;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Good good = (Good) object;

        if (Double.compare(good.price, price) != 0) return false;
        return title != null ? title.equals(good.title) : good.title == null;
    }

    @Override
    public String toString() {
        return "Good{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getTitle() {
        return title;
    }



    public double getPrice() {
        return price;
    }

    public Good(String title, double price) {
        this.title = title;

        this.price = price;
    }
}
