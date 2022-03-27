package com.example.songr.Repositories;

import com.example.songr.domain.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users,Integer> {
    Users findByUsername(String username);
}
