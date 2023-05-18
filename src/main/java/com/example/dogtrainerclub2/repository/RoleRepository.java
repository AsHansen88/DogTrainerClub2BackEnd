package com.example.dogtrainerclub2.repository;


import java.util.Optional;

import com.example.dogtrainerclub2.model.ERole;
import com.example.dogtrainerclub2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
