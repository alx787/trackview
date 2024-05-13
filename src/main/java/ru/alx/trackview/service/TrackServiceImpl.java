package ru.alx.trackview.service;

import ru.alx.trackview.dao.TrackDAO;
import ru.alx.trackview.model.Track;

import java.time.LocalDateTime;
import java.util.List;

public class TrackServiceImpl implements TrackService {

    private final TrackDAO trackDAO;

    public TrackServiceImpl(TrackDAO trackDAO) {
        this.trackDAO = trackDAO;
    }

    @Override
    public Track getTrackById(int id) {
        return trackDAO.findById(id);
    }

    @Override
    public List<Track> findTrackByHumanIdAndPeriod(int humanid, LocalDateTime datebeg, LocalDateTime dateend) {
        return trackDAO.findByHumanIdAndPeriod(humanid, datebeg, dateend);
    }

    @Override
    public void addTrack(Track track) {
        trackDAO.create(track);
    }
}
