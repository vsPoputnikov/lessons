package patterns.dao;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    User getUserByID(int id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(User user);
}
