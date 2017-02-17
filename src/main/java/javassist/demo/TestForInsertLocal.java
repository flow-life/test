package javassist.demo;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.expr.ExprEditor;
import javassist.expr.FieldAccess;
import javassist.expr.MethodCall;
import javassist.expr.NewExpr;

/**
 * Created by pine on 2016/12/2.
 */
public class TestForInsertLocal {

    public static void main(String[] args) throws Exception{
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("javassist.demo.InsertLocal");
        CtMethod m3 = cc.getDeclaredMethod("run3");
        m3.instrument(new ExprEditor() {
            public void edit(NewExpr n) throws CannotCompileException {
                n.replace("{ i++; $_ = $proceed($$); }");
            }

            public void edit(FieldAccess f) throws CannotCompileException {
                f.replace("{ i++; $_ = $proceed($$); }");
            }

            public void edit(MethodCall m) throws CannotCompileException {
                m.replace("{ i++; $_ = $proceed($$); }");
            }
        });
        InsertLocal oo = (InsertLocal)cc.toClass().newInstance();
        System.out.println(oo.run3());
    }
}
