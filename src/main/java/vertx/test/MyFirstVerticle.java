package vertx.test;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;


/**
 * vertx run MyFirstVerticle.java
 * Created by linjs on 2016/4/7.
 */
public class MyFirstVerticle extends AbstractVerticle{

    @Override
    public void start(Future<Void> startFuture) throws Exception {
//        vertx.createHttpServer().requestHandler(req -> {
//            MultiMap headers = req.headers();
//            System.out.println("User agent is " + headers.get("user-agent"));
//            System.out.println("User agent is same " + headers.get("User-Agent"));
//            req.response()
//                    .putHeader("content-type", "text/plain")
////                    .putHeader("Content-Length","10000")
//                    .setChunked(true)
//                    .write("some data")
//                    .write("some data", "UTF-16");
//            Buffer buffer = Buffer.buffer();
//            buffer.appendInt(123).appendLong(2451);
//            req.response().write(buffer);
//            req.response().end("Hello from Vert.x!");
//        }).listen(8080);

//        Router router = Router.router(vertx);
//
//        // Bind "/" to our hello message - so we are still compatible.
//        router.route("/").handler(routingContext -> {
//            HttpServerResponse response = routingContext.response();
//            response
//                    .putHeader("content-type", "text/html")
//                    .end("<h1>Hello from my first Vert.x 3 application</h1>");
//        });
// Create the HTTP server and pass the "accept" method to the request handler.
//        vertx
//                .createHttpServer()
//                .requestHandler(router::accept)
////                .requestHandler(r->router.accept(r))
//                .listen(
//                        // Retrieve the port from the configuration,
//                        // default to 8080.
//                        config().getInteger("http.port", 8080),
//                        result -> {
//                            if (result.succeeded()) {
//                                startFuture.complete();
//                            } else {
//                                startFuture.fail(result.cause());
//                            }
//                        }
//                );

//       vertx.createHttpServer()
//               .requestHandler(r -> {
//                   r.response().end("<h1>Hello from my first " +
//                           "Vert.x 3 application</h1>");
//               }).listen(8080,result -> {
//           if(result.succeeded()){
//               startFuture.complete();
//           }else{
//               startFuture.fail(result.cause());
//           }
//       });

//
//        vertx.deployVerticle("com.foo.OtherVerticle", res -> {
//            if (res.succeeded()) {
//                startFuture.complete();
//            } else {
//                startFuture.fail(res.cause());
//            }
//        });
//
//        //worker verticles
//        DeploymentOptions options = new DeploymentOptions().setWorker(true);
//        vertx.deployVerticle("com.mycompany.MyOrderProcessorVerticle", options);
//        EventBus bus = vertx.eventBus();
//        bus.publish("news.uk.sport", "Yay! Someone kicked a ball");
//        bus.consumer("news.uk.sport",message -> {System.out.println("I have received a message" + message.body());
//            message.reply("how interesting!");
//        });

//        NetServer server = vertx.createNetServer();
//        server.listen(0,r -> {
//           if(r.succeeded()){
//               System.out.println("Server is now listening on actual port: " + server.actualPort());
//           }else{
//               System.out.println("Fail to Bind!");
//           }
//        });
//        server.connectHandler(socket -> {
//            System.out.println("connection:"+socket.localAddress());
//        });


//        SharedData sd = vertx.sharedData();
//        sd.<String,String>getClusterWideMap("mymap", res -> {
//            if (res.succeeded()) {
//                AsyncMap<String, String> map = res.result();
//            } else {
//                // Something went wrong!
//            }
//        });
        vertx.fileSystem().readFile("test.txt", r -> {
            if (r.succeeded()) {
                System.out.println(r.result());
            } else {
                System.out.println("Oh oh ..." + r.cause());
            }
        });
        // Write a file
        vertx.fileSystem().writeFile("test.txt", Buffer.buffer("Hello"), result -> {
            if (result.succeeded()) {
                System.out.println("File written");
            } else {
                System.err.println("Oh oh ..." + result.cause());
            }
        });

        Future future = Future.future();
    }

}
