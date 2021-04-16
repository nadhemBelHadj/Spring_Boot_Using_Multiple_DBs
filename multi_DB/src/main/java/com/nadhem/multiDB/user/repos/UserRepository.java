package com.nadhem.multiDB.user.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nadhem.multiDB.entities.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
