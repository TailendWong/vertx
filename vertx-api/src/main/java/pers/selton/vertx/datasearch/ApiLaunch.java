package pers.selton.vertx.datasearch;

import com.typesafe.config.Config;
import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import pers.selton.vertx.commons.config.ConfigUtils;

@Slf4j
public class ApiLaunch {

    public static void main(String[] args) {

        String confPath = System.getProperty("appConfigPath");
        log.info("get appConfigPath -> {}", confPath);
        if (StringUtils.isNotEmpty(confPath)) {
            ConfigUtils.getConfig(confPath);
        }
        Config config = ConfigUtils.getConfig();
        log.info("config read -> {}", config);

        Vertx.vertx().deployVerticle(ApiVerticle.class.getName(), result -> {
            if (result.succeeded()) {
                log.info("Deployment Verticle success. id [{}]", result.result());
            } else {
                log.info("Deployment Verticle failed. id [{}]", result.result());
            }
        });
    }
}
