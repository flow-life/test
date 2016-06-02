package vertx.test;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by linjs on 2016/4/7.
 */
@RunWith(VertxUnitRunner.class)
public class MyFirstVerticleTest {

    private Vertx vertx;

    //@Before
    public void setUp(TestContext context){
        vertx = Vertx.vertx();
        int port = 8081;
        DeploymentOptions options = new DeploymentOptions()
                .setConfig(new JsonObject().put("http.port", port));
        vertx.deployVerticle(MyFirstVerticle.class.getName(),options,
                context.asyncAssertSuccess());
    }

    //@After
    public void tearDown(TestContext context){
        vertx.close(context.asyncAssertSuccess());
    }

    //@Test
    public void testMyApplication(TestContext context){
        final Async async = context.async();

        vertx.createHttpClient().getNow(8080, "localhost", "/",
                response -> {
                    response.handler(body -> {
                        context.assertTrue(body.toString().contains("Hello"));
                        async.complete();
                    });
                });
    }

    @Test
    public void testPort() throws Exception{
//        ServerSocket socket = new ServerSocket(0);
//
//        System.out.println("-->" + socket.getLocalPort());
//
//        socket.close();
//        vertx.setPeriodic(1000,s -> {
//            System.out.println("test");
//        });

        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
