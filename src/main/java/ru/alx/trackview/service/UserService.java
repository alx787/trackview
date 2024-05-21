package ru.alx.trackview.service;

import ru.alx.trackview.model.AppUser;

import java.util.List;

public interface UserService {
    AppUser getUserById(int id);
    void addUser(AppUser appuser);
    void removeUser(int id);
    void updateUser(AppUser appuser);
    List<AppUser> getAllUsers();



}
