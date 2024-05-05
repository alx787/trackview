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

    @Column(nullable = false)
    private LocalDateTime dateTime;

    //  для полей lon lat нужно будет после создания таблиц в базе установить тип DECIMAL(9,6)
    //    @Column(nullable = false, columnDefinition = "DECIMAL", precision = 9, scale = 6)
    @Column(nullable = false, columnDefinition = "DECIMAL", precision = 9)
    private double lon;
//    private BigDecimal lon;

    //    @Column(nullable = false, columnDefinition = "DECIMAL", precision = 9, scale = 6)
    @Column(nullable = false, columnDefinition = "DECIMAL", precision = 9)
    private double lat;
//    private BigDecimal lat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_id")
    private Human human;
}
