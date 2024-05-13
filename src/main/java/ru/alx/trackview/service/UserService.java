package ru.alx.trackview.service;

import ru.alx.trackview.model.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);
    void addUser(User user);
    void removeUser(int id);
    void updateUser(User user);
    List<User> getAllUsers();



}
