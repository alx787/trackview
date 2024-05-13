package ru.alx.trackview.service;

import ru.alx.trackview.model.Human;

public interface HumanService {
    Human getHumanById(int id);
    void addHuman(Human human);
    void updateHuman(Human human);
}
