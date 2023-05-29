package com.javarush.entities.films;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


@Entity
@Table(name = "film_category")

@Getter
@Setter
@ToString

public class Film_category {

    @Id
    @OneToOne
    @JoinColumn(name="category_id")
    public Category category_id;

    @Id
    @OneToOne
    @JoinColumn(name="film_id")
    public Film film_id;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;


}
