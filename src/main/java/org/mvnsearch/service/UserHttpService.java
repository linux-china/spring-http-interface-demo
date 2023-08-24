package org.mvnsearch.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;


@HttpExchange("/user")
public interface UserHttpService {

    record User(String nick, String email) {
    }

    @GetExchange("/{nick}")
    Mono<User> show(@PathVariable String nick);
}
