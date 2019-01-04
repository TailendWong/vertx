package pers.selton.vertx.service.impl;

import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import pers.selton.vertx.model.data.User;
import pers.selton.vertx.service.IUserService;

@Slf4j
@Singleton
public class UserServiceImpl implements IUserService {
    @Override
    public void addUser(User user) {
        log.info("success add user {}", user);
    }

    @Override
    public User getUser(long id) {
        User user = new User();
        user.setId(id);
        user.setAge((int) id);
        user.setName("testUserGet" + id);
        log.info("user message get {}", user);
        return user;
    }
}
