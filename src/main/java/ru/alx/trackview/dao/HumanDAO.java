package ru.alx.trackview.dao;

import ru.alx.trackview.model.Human;

import java.util.List;

public interface HumanDAO {
    Human findById(int id);
    void create(Human human);
    void remove(int id);
    void update(Human human);
    List<Human> findByUserId(int userid);

}
