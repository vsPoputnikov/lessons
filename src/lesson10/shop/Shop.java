package lesson10.shop;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;

public class Shop {
    static HashMap<String, User> users = new HashMap<>();
    static HashMap<String, Good> storage= new HashMap<>();

    public boolean doTransaction(User user){
        double price = user.getCart().getSumm();
      if((user.getBalance()-price)<0){
          return false;
      }
      user.setBalance(user.getBalance()-price);
      return true;
    }



    public static void main(String[] args) {
        User user1 = new User("qwe", "111", 4000);
        User user2 = new User("asd", "222", 400);
        User user3 = new User("sdf", "333", 40000);
        User user4 = new User("dfg", "444", 4050);

        Good car = new Good("car", 2000);
        Good phone = new Good("phone",  1500);
        Good book = new Good("book", 100);

        users.put(user1.getLogin(),user1);
        users.put(user2.getLogin(),user2);
        users.put(user3.getLogin(),user3);
        users.put(user4.getLogin(),user4);

        storage.put(car.getTitle(), car);
        storage.put(phone.getTitle(), phone);
        storage.put(book.getTitle(), book);

        Cart cart = new Cart();
        cart.addGood(car);
        cart.addGood(phone);
        user1.regCart(cart);


    }
}
