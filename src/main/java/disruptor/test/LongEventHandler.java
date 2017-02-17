package disruptor.test;

import com.lmax.disruptor.EventHandler;

/**
 * Created by pine on 2016/9/5.
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event:" + event);
    }
}
