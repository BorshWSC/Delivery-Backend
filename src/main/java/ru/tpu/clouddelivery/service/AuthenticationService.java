package ru.tpu.clouddelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.tpu.clouddelivery.exceptions.NotFoundException;
import ru.tpu.clouddelivery.model.SingInInfo;
import ru.tpu.clouddelivery.model.User;

@Service
public class AuthenticationService {

    private UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public AuthenticationService(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User singUp(User user) {
        return userService.createUser(user);
    }

    public User singIn(SingInInfo singInInfo) {
        User user = userService.getUserByEmail(singInInfo.getEmail()).orElseThrow(NotFoundException::new);
        if (!bCryptPasswordEncoder.matches(singInInfo.getPassword(), user.getPassword())) {
            throw new RuntimeException("Неверный пароль");
        }

        return user;
    }
}
