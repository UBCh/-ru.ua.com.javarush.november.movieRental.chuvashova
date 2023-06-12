package com.javarush.entitie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "store")
public class Store {

    @Id
    @Column(name = "store_id", columnDefinition = "tinyint UNSIGNED not null")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

    @Column(name = "staff_id")
    private Long staffId;

}