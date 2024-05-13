package ru.alx.trackview.dao;

import ru.alx.trackview.model.User;

import java.util.List;

public interface UserDAO {
    User findById(int id);
    void create(User user);
    void remove(int id);
    void update(User user);
    List<User> getAll();
}
