package javassist.demo;

/**
 * http://www.cnblogs.com/sunfie/p/5154246.html
 * Created by pine on 2016/12/2.
 */
public class Hello {
    public void say(){
        System.out.println("Hello");
    }

//    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
//        //告诉你 classLoader不一样，出错了 可以使用Loader
////        Hello hello = new Hello(); //这句话 有没有是一样的
//        ClassPool cp = ClassPool.getDefault();
////        Loader cl = new Loader(cp);
//        CtClass cc = cp.get("javassist.demo.Hello");
//        cc.setName("x");
//        CtMethod m = cc.getDeclaredMethod("say");
//        m.insertBefore("{ System.out.println(11); }");
//        Class c = cc.toClass();
//        Hello h = (Hello)c.newInstance();
//        h.say();
//    }
}
