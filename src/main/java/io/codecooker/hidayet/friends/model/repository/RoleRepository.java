package io.codecooker.hidayet.friends.model.repository;

import java.util.Optional;

import io.codecooker.hidayet.friends.model.ERole;
import io.codecooker.hidayet.friends.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}