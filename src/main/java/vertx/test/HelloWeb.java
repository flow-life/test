package vertx.test;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

/**
 * Created by linjs on 2016/4/14.
 */
public class HelloWeb {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        Route r1 = router.route("/s").blockingHandler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response.putHeader("content-type", "text/plain");
            response.setChunked(true);
            response.write("Hello World from Vert.x-Web!");

            routingContext.vertx().setTimer(5000, tid -> routingContext.next());

        });
        Route r2 = router.route("/s").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response.putHeader("content-type", "text/plain");

            response.end("text");
        });

        server.requestHandler(router::accept).listen(8080);
    }
}
