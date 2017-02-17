package classloader.test.bean;

/**
 * Created by pine on 2016/9/23.
 */
public class Foo implements IFoo {

    @Override
    public void hello() {
        System.out.println("I'm Foo");
    }
}
