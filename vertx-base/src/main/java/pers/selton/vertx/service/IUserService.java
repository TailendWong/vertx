package pers.selton.vertx.service;

import pers.selton.vertx.model.data.User;

public interface IUserService {

    void addUser(User user);

    User getUser(long id);
}
