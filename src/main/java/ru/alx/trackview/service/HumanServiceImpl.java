package ru.alx.trackview.service;

import ru.alx.trackview.dao.HumanDAO;
import ru.alx.trackview.model.Human;

public class HumanServiceImpl implements HumanService {

    private final HumanDAO humanDAO;

    public HumanServiceImpl(HumanDAO humanDAO) {
        this.humanDAO = humanDAO;
    }

    @Override
    public Human getHumanById(int id) {
        return humanDAO.findById(id);
    }

    @Override
    public void addHuman(Human human) {
        humanDAO.create(human);
    }

    @Override
    public void updateHuman(Human human) {
        humanDAO.update(human);
    }
}
