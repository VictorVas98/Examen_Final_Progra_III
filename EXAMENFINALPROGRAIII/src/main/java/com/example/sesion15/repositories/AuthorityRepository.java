package com.example.sesion15.repositories;

import com.example.sesion15.entities.Authority;
import com.example.sesion15.entities.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    public Authority findByName(AuthorityName name);
}
