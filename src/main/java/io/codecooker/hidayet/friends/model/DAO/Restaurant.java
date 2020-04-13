package io.codecooker.hidayet.friends.model.DAO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(	name = "restaurant",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        })
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max=100)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "restaurant_types",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    private Set<Types> types = new HashSet<>();

    @OneToOne
    private Location location;
}
