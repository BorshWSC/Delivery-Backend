package ru.tpu.clouddelivery.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.tpu.clouddelivery.dao.UserDao;
import ru.tpu.clouddelivery.exceptions.NotFoundException;
import ru.tpu.clouddelivery.exceptions.SameUserException;
import ru.tpu.clouddelivery.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserDao userDao;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Iterable<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUserById(String id) {
        return userDao.findById(Integer.parseInt(id)).orElseThrow(NotFoundException::new);
    }

    public Optional<User> getUserByEmail(String email) {
        return userDao.findByEmail(email.trim());
    }

    public User createUser(User user) {
        User userFromDB = getUserByEmail(user.getEmail()).orElse(null);

        if (userFromDB != null) {
            throw new SameUserException("Пользователь с таким email уже существует");
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }

    public User updateUser(User userFromDb, User newUser) {
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        BeanUtils.copyProperties(newUser, userFromDb, "id");
        return userDao.save(userFromDb);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }
}
