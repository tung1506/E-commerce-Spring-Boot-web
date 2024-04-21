package com.springserver.server.repository;

import com.springserver.server.domain.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Integer> {
    Optional<SiteUser> findByUsername (String Email);

}