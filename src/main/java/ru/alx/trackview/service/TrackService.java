package ru.alx.trackview.service;

import ru.alx.trackview.model.Track;

import java.time.LocalDateTime;
import java.util.List;

public interface TrackService {
    Track getTrackById(int id);
    List<Track> findTrackByHumanIdAndPeriod(int humanid, LocalDateTime datebeg, LocalDateTime dateend);
    void addTrack(Track track);
}
