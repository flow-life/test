package classloader.test;

import classloader.test.bean.IFoo;
import sun.misc.PerfCounter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by pine on 2016/9/23.
 */
public class RunTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        System.out.println(PerfCounter.getFindClasses().get());
        TestLoader loader = new TestLoader();
        Class c = loader.loadClass("classloader.test.bean.Foo3");
        System.out.println("-->" + IFoo.class.getClassLoader());
        //erro.IFoo classLoader is Launcher$AppClassLoader and Foo3 classLoader is TestLoader. ClassCastException
//        IFoo foo3 = (IFoo) loader.loadClass("classloader.test.bean.Foo3").newInstance();
//        foo3.hello();
//        Method[] methods = c.getMethods();
        System.out.println(PerfCounter.getFindClasses().get());
        Object ss = c.newInstance();
//        for(Method method : methods){
//            if("hello".equals(method.getName())){
//                method.setAccessible(true);
//                method.invoke(ss);
//            }
//        }
        Method method = c.getMethod("hello");
        method.setAccessible(true);
        method.invoke(ss);
    }
}
