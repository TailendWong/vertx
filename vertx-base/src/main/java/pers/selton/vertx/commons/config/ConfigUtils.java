package pers.selton.vertx.commons.config;

import com.google.common.base.Strings;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

public class ConfigUtils {



    private static Config config;

    public static Config getConfig(String path){
        if (null == config) {
            synchronized (ConfigUtils.class){
                if (null == config) {
                    config = Strings.isNullOrEmpty(path) ? ConfigFactory.load()
                            : ConfigFactory.parseFile(new File(path));
                }
            }
        }
        return config;
    }

    public static Config getConfig(){
        return getConfig("conf/application.conf");
    }
}
