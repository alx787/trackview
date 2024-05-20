package ru.alx.trackview.dao;

import ru.alx.trackview.model.AppUser;

import java.util.List;

public interface AppUserDAO {
    AppUser findById(int id);
    void create(AppUser appUser);
    void remove(int id);
    void update(AppUser appUser);
    List<AppUser> getAll();
}
