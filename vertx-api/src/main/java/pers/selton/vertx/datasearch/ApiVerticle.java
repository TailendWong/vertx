package pers.selton.vertx.datasearch;

import com.typesafe.config.Config;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jboss.resteasy.plugins.server.vertx.VertxRequestHandler;
import org.jboss.resteasy.plugins.server.vertx.VertxResteasyDeployment;
import pers.selton.vertx.commons.config.ConfigUtils;
import pers.selton.vertx.datasearch.resource.UserResource;

@Slf4j
public class ApiVerticle extends AbstractVerticle {

    private VertxResteasyDeployment resteasyDeployment;

    private int serverPort;

    private Config config;

    @Override
    public void start(Future<Void> startFuture) throws Exception {

        config = ConfigUtils.getConfig();
        serverPort = config.getInt("server.port");

        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        resteasyDeployment = new VertxResteasyDeployment();

        resteasyDeployment.start();

        resteasyDeployment.getRegistry().addPerInstanceResource(UserResource.class);

        VertxRequestHandler vertxRequestHandler = new VertxRequestHandler(vertx, resteasyDeployment);
        router.route().handler(context -> vertxRequestHandler.handle(new Router2ResteasyRequestAdapter(context)));
        listenHttpServer(vertx, router, startFuture);
    }

    private void listenHttpServer(Vertx vertx, Router router, Future<Void> future){
        HttpServerOptions httpServerOptions = new HttpServerOptions().setCompressionSupported(true).setDecompressionSupported(true);
        vertx.createHttpServer(httpServerOptions)
                .requestHandler(router::accept)
                .listen(serverPort, httpServerAsyncResult -> {
                    if (httpServerAsyncResult.succeeded()) {
                        log.info("Server started on port {}", httpServerAsyncResult.result().actualPort());
                        future.complete();
                    } else {
                        log.error("Server started fail result {}", ExceptionUtils.getStackTrace(httpServerAsyncResult.cause()));
                        future.fail(httpServerAsyncResult.cause());
                    }
                });
    }
}
