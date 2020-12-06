package ru.tpu.clouddelivery.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tpu.clouddelivery.model.SingInInfo;
import ru.tpu.clouddelivery.model.User;
import ru.tpu.clouddelivery.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationRest {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationRest(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/singUp")
    public User singUp(@RequestBody User user) {
        return authenticationService.singUp(user);
    }

    @PostMapping("/singIn")
    public User singIn(@RequestBody SingInInfo singInInfo) {
        return authenticationService.singIn(singInInfo);
    }
}
