package quasar.test;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.strands.Strand;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by linjs on 2016/5/14.
 */
public class ExampleOutOfMemory {
    //1百万个线程
    private static void javaThredMethod(){
        for(int i = 0; i < 1_000_000; i++) {
            System.out.println(i);
            new Thread(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    //Quasar 建立百万个 Fiber
    public static void parsar() throws InterruptedException {
        int fiberNumber = 1_000_100;
        CountDownLatch latch = new CountDownLatch(1);
        AtomicInteger counter = new AtomicInteger(0);

        for(int i = 0; i < fiberNumber;i++){
            new Fiber<>(()->{
                System.out.println(counter.incrementAndGet());
                if(counter.get() == fiberNumber){
                    System.out.println("donw");
                }
                Strand.sleep(100000);
            }).start();
        }
        //加了latch，阻止程序跑完就关闭， Strand.sleep 其实跟 Thread.sleep 一样，只是这里针对的是 Fiber
        latch.await();
    }
    public static void main(String[] args) throws InterruptedException {
//        javaThredMethod();
        //cpu 伤不起
        parsar();
    }
}
