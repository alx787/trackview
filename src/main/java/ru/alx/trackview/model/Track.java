package ru.alx.trackview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tracks", schema = "trackviewdb")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;

    // долгота
    //  для полей lon lat нужно будет после создания таблиц в базе установить тип DECIMAL(9,6)
    //    @Column(nullable = false, columnDefinition = "DECIMAL", precision = 9, scale = 6)
    @Column(nullable = false, columnDefinition = "DECIMAL", precision = 9)
    private double lon;
//    private BigDecimal lon;

    // широта
    //    @Column(nullable = false, columnDefinition = "DECIMAL", precision = 9, scale = 6)
    @Column(nullable = false, columnDefinition = "DECIMAL", precision = 9)
    private double lat;
//    private BigDecimal lat;

    @Column(nullable = false)
    private LocalDateTime datetime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_id")
    private Human human;

    public Track(double lon, double lat, LocalDateTime datetime, Human human) {
        this.lon = lon;
        this.lat = lat;
        this.datetime = datetime;
        this.human = human;
    }
}
