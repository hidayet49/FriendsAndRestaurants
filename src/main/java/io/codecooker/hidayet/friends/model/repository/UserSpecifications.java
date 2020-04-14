package io.codecooker.hidayet.friends.model.repository;

import io.codecooker.hidayet.friends.model.entity.Location;
import io.codecooker.hidayet.friends.model.entity.User;
import io.codecooker.hidayet.friends.util.DistanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {
    @Autowired
    DistanceUtil distanceUtil;
    public static Specification<User> userIsInMyCirdle(Double longitude,Double latitude,Double distanceInKm) {


        return (root, query, cb) ->{
            Location location=(Location)root.get("location");
            return null;// cb.lessThan(DistanceUtil.distance(latitude,longitude,location.getLatitude(),location.getLongitude(),'K'), distanceInKm);
        };
    }
//    public static Specification<User> userIsInMyCirdle(Double longitude,Double latitude,Double distanceInKm) {
//
//
//        return (root, query, cb) ->{
//
//            return cb.lessThan(distance(latitude,longitude,root.get("latitude"),root.get("longitude"),'K'), distanceInKm);
//        };
//    }

}
