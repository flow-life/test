package vertx.test;

/**
 * Created by linjs on 2016/4/18.
 */
public class TestDefault {
    public static void main(String[] args) {
        class Td implements TestDefualtInterface{}
        Td td = new Td();
        td.say("123");
    }
}
