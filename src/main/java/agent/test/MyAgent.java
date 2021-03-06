package agent.test;

import java.lang.instrument.Instrumentation;

/**
 * Created by pine on 2016/8/17.
 */
public class MyAgent {

    /**
     * 该方法在main方法运行之前运行,与main方法运行在同一个JVM中
     * 并被同一个System ClassLoader装载
     * 被统一的安全策略(security policy)和上下文(context)管理
     * @param agentOps
     * @param inst
     */
    public static void premain(String agentOps,Instrumentation inst){
        System.out.println("=========premain方法执行========");
        System.out.println(agentOps);
    }

    /**
     * 如果不存在premain(String agentOps,Instrumentation inst)
     * 则执行premain(String agentOps)
     * @param agentOps
     */
    public static void premain(String agentOps){
        System.out.println("=========premain方法执行2======");
        System.out.println(agentOps);
    }
}
