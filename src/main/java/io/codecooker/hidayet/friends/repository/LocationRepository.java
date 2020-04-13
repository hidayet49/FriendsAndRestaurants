package io.codecooker.hidayet.friends.repository;

import io.codecooker.hidayet.friends.model.DAO.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}
