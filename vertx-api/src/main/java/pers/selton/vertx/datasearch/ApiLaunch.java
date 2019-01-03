package pers.selton.vertx.datasearch;

import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiLaunch {

    public static void main(String[] args) {

        Vertx.vertx().deployVerticle(ApiVerticle.class.getName(), result -> {
            if (result.succeeded()) {
                log.info("Deployment Verticle success. id [{}]", result.result());
            } else {
                log.info("Deployment Verticle failed. id [{}]", result.result());
            }
        });
    }
}
