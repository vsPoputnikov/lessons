package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("qwe",34,"Russia");
        User user2 = new User("asd",56,"Canada");
        User user3 = new User("sdf",34,"Germany");
        User user4 = new User("dgh",22,"China");
        User user5 = new User("xcv",33,"Russia");
        User user6 = new User("zxc",55,"Russia");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        Listeners listeners = new Listeners(users);
        System.out.println(listeners.getRussianUsers());

        List<User> russianUsers = listeners.getFilterUsers(user -> user.getCountry().equals("Russia"));
        System.out.println(russianUsers);

        Predicate<User> russiaFilter = user -> user.getCountry().equals("Russia");

    }


}

class User{
    private String login;
    private int age;
    private String country;

    public User(String login, int age, String country) {
        this.login = login;
        this.age = age;
        this.country = country;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        User user = (User) object;

        if (age != user.age) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return country != null ? country.equals(user.country) : user.country == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
class Listeners{
    private List<User> userList;

    public Listeners(List<User> userList) {
        this.userList = userList;
    }
    public List<User> getRussianUsers(){
        List<User> list = new ArrayList<>();
        for(User user: userList){
            if("Russia".equals(user.getCountry())){
                list.add(user);
            }
        }
        return list;
    }

    public List<User> ageAfter45Users(){
        List<User> list = new ArrayList<>();
        for(User user: userList){
            if(user.getAge()>45){
                list.add(user);
            }
        }
        return list;
    }

    public List<User> getCanadaAfter45Users(){
        List<User> list = new ArrayList<>();
        for(User user: userList){
            if("Canada".equals(user.getCountry())&&user.getAge()>45){
                list.add(user);
            }
        }
        return list;
    }

    // с использованием Predicate
    public List<User> getFilterUsers(Predicate<User> filter){
        List<User> list = new ArrayList<>();
        for(User user: userList){
            if(filter.test(user))
            list.add(user);
        }
        return list;
    }
 }