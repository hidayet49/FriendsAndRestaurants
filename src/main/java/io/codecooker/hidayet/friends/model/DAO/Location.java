package io.codecooker.hidayet.friends.model.DAO;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(	name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double longitude;
    private Double latitude;

    public Location(Double longitude,Double latitude){
        this.longitude=longitude;
        this.latitude=latitude;
    }
}
