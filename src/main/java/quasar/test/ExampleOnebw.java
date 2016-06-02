package quasar.test;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableRunnable;
import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.Channels;

/**
 * Created by linjs on 2016/5/14.
 * 生成百万actor/Fiber的开销 skynet 。

 大致的逻辑是先生成10个Fiber，每个Fiber再生成10个Fiber，直到生成1百万个Fiber，
 然后每个Fiber做加法累积计算，并把结果发到channel里，这样一直递归到根Fiber。
 后将最终结果发到channel。如果逻辑没有错的话结果应该是499999500000。
 我们搞个Quasar版的，来测试一下性能
 */
public class ExampleOnebw {

    private static final int RUNS = 4;
    private static final int BUFFER = 1000;

    public static void skynet(Channel<Long> c,long num,int size,int div) throws InterruptedException, SuspendExecution {
        if(size == 1){
            c.send(num);
            return;
        }

        Channel<Long> rc = Channels.newChannel(BUFFER);
        long sum = 0L;
        for(int i = 0; i < div; i++){
            long subNum = num + i * (size / div);
            new Fiber<>(() -> skynet(rc,subNum,size/div,div)).start();
        }
        for(int i = 0; i < div;i++){
            sum += rc.receive();
        }
        c.send(sum);
    }

    public static void main(String[] args) throws InterruptedException, SuspendExecution {
        //这里跑4次，是为了让JVM预热好做优化，所以我们以最后一个结果为准。
        for (int i = 0; i < RUNS; i++) {
            long start = System.nanoTime();

            Channel<Long> c = Channels.newChannel(BUFFER);
            new Fiber((SuspendableRunnable) () -> skynet(c, 0l, 1_000_000, 10)).start();
            long result = c.receive();

            long elapsed = (System.nanoTime() - start) / 1_000_000;
            System.out.println((i + 1) + ": " + result + " (" + elapsed + " ms)");
        }
    }
}
