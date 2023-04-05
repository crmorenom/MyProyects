package com.enterprise.crudusers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Cristian Moreno
 * @Programadores: Cristian Moreno
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}