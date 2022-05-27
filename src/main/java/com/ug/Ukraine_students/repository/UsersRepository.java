package com.ug.Ukraine_students.repository;

import com.ug.Ukraine_students.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsersName(String usersName);
}
