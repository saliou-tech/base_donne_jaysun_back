package com.anbiko.anbiko.Repository;

import com.anbiko.anbiko.Entity.Membre;
import com.anbiko.anbiko.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Membrerepository extends JpaRepository<Membre, Long> {
    Optional<Membre> findByTelephone(String username);
}
