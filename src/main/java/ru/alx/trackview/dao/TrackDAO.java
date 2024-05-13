package ru.alx.trackview.dao;

import ru.alx.trackview.model.Track;

import java.time.LocalDateTime;
import java.util.List;

public interface TrackDAO {
    Track findById(int id);
    List<Track> findByHumanIdAndPeriod(int humanid, LocalDateTime datebeg, LocalDateTime dateend);
    void create(Track track);

}
