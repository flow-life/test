package quasar.test;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.Channels;

/**
 * Created by linjs on 2016/5/14.
 * 使用Quasar库实现协程
 * 连续数字的平方
 * {@link <b>http://www.tuicool.com/articles/fMbiyeM</b>}
 */
public class Example {

    private static void printer(Channel<Integer> in) throws InterruptedException, SuspendExecution {
        Integer v;
        while( (v = in.receive()) != null){
            System.out.println(v);
        }
    }

    public static void main(String[] args) throws SuspendExecution, InterruptedException {
        //定义2个channel
        Channel<Integer> naturals = Channels.newChannel(-1);
        Channel<Integer> squares = Channels.newChannel(-1);

        //运行两个Fiber实现
        new Fiber<>(() -> {
            for(int i = 0; i < 10; i++){
                naturals.send(i);
            }
            naturals.close();
        }).start();

        new Fiber<>(() -> {
            Integer v;
            while((v = naturals.receive()) != null){
                squares.send(v*v);
            }
            squares.close();
        }).start();

        System.out.println("结束");
        printer(squares);
    }

}
