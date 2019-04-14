package patterns.dao;

import java.util.List;

public class TXTFileUserDao implements UserDao {
    @Override
    public void addUser(User user) {
        System.out.println("добавление нового пользоватея:  "+ user);
    }

    @Override
    public User getUserByID(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
