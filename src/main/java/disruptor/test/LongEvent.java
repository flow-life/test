package disruptor.test;

/**
 * Created by pine on 2016/9/5.
 */
public class LongEvent {
    private long value;

    public void set(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LongEvent{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
