package org.mvnsearch.web.rest;

import org.mvnsearch.service.UserHttpService;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController implements UserHttpService {
    @Override
    public Mono<User> show(String nick) {
        return Mono.just(new User(nick, "demo@example.com"));
    }
}
