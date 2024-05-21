package ru.alx.trackview.service;

import ru.alx.trackview.dao.AppUserDAO;
import ru.alx.trackview.model.AppUser;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final AppUserDAO appUserDAO;

    public UserServiceImpl(AppUserDAO appUserDAO) {
        this.appUserDAO = appUserDAO;
    }

    public AppUser getUserById(int id) {
        return appUserDAO.findById(id);
    }

    @Override
    public void addUser(AppUser user) {
        appUserDAO.create(user);
    }

    @Override
    public void removeUser(int id) {
        appUserDAO.remove(id);
    }

    @Override
    public void updateUser(AppUser user) {
        appUserDAO.update(user);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUserDAO.getAll();
    }
}
