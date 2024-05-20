package ru.alx.trackview.service;

import ru.alx.trackview.model.AppUser;

import java.util.List;

public interface UserService {
    AppUser getUserById(int id);
    void addUser(AppUser appUser);
    void removeUser(int id);
    void updateUser(AppUser appUser);
    List<AppUser> getAllUsers();



}
