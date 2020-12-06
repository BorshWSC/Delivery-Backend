package ru.tpu.clouddelivery.dao;

import org.springframework.data.repository.CrudRepository;
import ru.tpu.clouddelivery.model.User;

import java.util.Optional;

public interface UserDao extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
