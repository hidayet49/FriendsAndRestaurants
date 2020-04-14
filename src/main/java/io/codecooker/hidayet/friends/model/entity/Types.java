package io.codecooker.hidayet.friends.model.entity;

import io.codecooker.hidayet.friends.model.ERestaurantTypes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(	name = "types",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        })
public class Types {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERestaurantTypes name;
}
