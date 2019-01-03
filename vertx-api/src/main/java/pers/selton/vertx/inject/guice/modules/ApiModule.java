package pers.selton.vertx.inject.guice.modules;

import com.google.inject.Binder;
import com.google.inject.Module;
import pers.selton.vertx.service.IUserService;
import pers.selton.vertx.service.impl.UserServiceImpl;

public class ApiModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(IUserService.class).to(UserServiceImpl.class);
    }
}
