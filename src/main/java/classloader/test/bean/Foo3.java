package classloader.test.bean;

/**
 * Created by pine on 2016/9/23.
 */
public class Foo3 implements IFoo {

    public void hello(){
        Class<?> clazz = Foo.class;
        Foo foo2 = Foo4.foo2;
    }
}
