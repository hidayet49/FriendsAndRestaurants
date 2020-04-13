package io.codecooker.hidayet.friends.repository;

import java.util.Optional;

import io.codecooker.hidayet.friends.model.ERole;
import io.codecooker.hidayet.friends.model.DAO.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}