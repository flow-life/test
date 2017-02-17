package javassist.demo;

import javassist.*;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by pine on 2016/12/2.
 */
public class Test {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("javassist.demo.Hello");
        CtMethod m = cc.getDeclaredMethod("say");
        m.insertBefore("System.out.println(\"Hello.say()\");");
        Class c = cc.toClass();
        Hello h = (Hello)c.newInstance();
        h.say();
        System.out.println(Arrays.toString(cc.toBytecode()));
        System.out.println(-1 >> 8);
    }
}
