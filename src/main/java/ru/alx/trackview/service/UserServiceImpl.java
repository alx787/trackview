package ru.alx.trackview.service;

import ru.alx.trackview.dao.UserDAO;
import ru.alx.trackview.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final ru.alx.trackview.dao.UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public User getUserById(int id) {
        return userDAO.get(id);
    }

    @Override
    public void addUser(User user) {
        userDAO.create(user);
    }

    @Override
    public void removeUser(int id) {
        userDAO.remove(id);
    }

    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }

    @Override
    public List<User> listUsers() {
        return userDAO.getAll();
    }
}
