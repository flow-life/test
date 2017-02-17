package msgpack.test;

import org.msgpack.MessagePack;

import java.io.IOException;
import java.util.Date;

/**
 * Created by pine on 2016/7/23.
 */
public class MsgPackTest {

    public static void main(String[] args) throws IOException {
        BeanClass beanClass = new BeanClass("张三",12,new Date());
        MessagePack msgPack = new MessagePack();
        // Serialize
        byte[] raw = msgPack.write(beanClass);
        System.out.println(raw.length + "-->" + raw);
        // Deserialize
        BeanClass dst = msgPack.read(raw, BeanClass.class);
        System.out.println(dst);
    }
}
