package disruptor.test;

import com.lmax.disruptor.EventFactory;

/**
 * Created by pine on 2016/9/5.
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
