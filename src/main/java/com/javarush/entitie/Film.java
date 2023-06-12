package com.javarush.entitie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "film")

public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", columnDefinition = "smallint UNSIGNED not null")
    private Integer id;

    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @OneToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    @Column(name = "rental_duration", columnDefinition = "tinyint UNSIGNED not null")
    private Short rentalDuration;

    @Column(name = "rental_rate", nullable = false, precision = 4, scale = 2)
    private BigDecimal rentalRate;

    @Column(name = "length", columnDefinition = "smallint UNSIGNED")
    private Integer length;

    @Column(name = "replacement_cost", nullable = false, precision = 5, scale = 2)
    private BigDecimal replacementCost;

    @Enumerated(EnumType.STRING)
    @Column(name = "rating")
    Rating rating;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "special_features")
    private Set<String> specialFeatures=new HashSet<>();

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

    @Column(name = "original_language")
    private Long originalLanguage1;

    @OneToMany(mappedBy = "film")
    private Set<FilmActor> filmActors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "film")
    private Set<FilmCategory> filmCategories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "film")
    private Set<Inventory> inventories = new LinkedHashSet<>();

    public Film(String kissGlory, String s, int i, int i1, int i2, double v, int i3, double v1, Rating rating, String s1) {
    }
}