package ru.alx.trackview.dao;

import ru.alx.trackview.model.AppUser;

import java.util.List;

public interface AppUserDAO {
    AppUser findById(int id);
    AppUser findByName(String username);
    void create(AppUser appuser);
    void remove(int id);
    void update(AppUser appuser);
    List<AppUser> getAll();
}
