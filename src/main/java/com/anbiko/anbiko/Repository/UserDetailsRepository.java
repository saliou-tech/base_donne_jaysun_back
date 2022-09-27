package com.anbiko.anbiko.Repository;

import com.anbiko.anbiko.Entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetail, Long> {
    Optional<UserDetail> findByUserUsername(String username);
}
