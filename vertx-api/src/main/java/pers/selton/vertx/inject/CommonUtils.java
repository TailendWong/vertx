package pers.selton.vertx.inject;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.typesafe.config.Config;
import org.mybatis.guice.XMLMyBatisModule;
import pers.selton.vertx.commons.config.ConfigUtils;
import pers.selton.vertx.inject.guice.modules.ApiModule;
import pers.selton.vertx.service.IUserService;
import pers.selton.vertx.service.impl.UserServiceImpl;

public class CommonUtils {

    private static Injector injector;

    private static Injector getInjector(){
        if (null == injector) {
            synchronized (CommonUtils.class){
                if (null == injector) {
                    injector = initGuice();
                }
            }
        }
        return injector;
    }

    public static <T> T getInstance(Class<T> type){
        return getInjector().getInstance(type);
    }

    protected static Injector initGuice(){
        Config config = ConfigUtils.getConfig();
        return Guice.createInjector(Stage.PRODUCTION, new ApiModule());
    }
}
