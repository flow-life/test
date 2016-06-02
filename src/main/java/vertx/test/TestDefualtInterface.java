package vertx.test;

/**
 * Created by linjs on 2016/4/18.
 */
public interface TestDefualtInterface {
    default void say(String t){
        System.out.println("hello"+t);
    };
}
