package ru.tpu.clouddelivery.dao;

import org.springframework.data.repository.CrudRepository;
import ru.tpu.clouddelivery.model.User;

public interface UserDao extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
