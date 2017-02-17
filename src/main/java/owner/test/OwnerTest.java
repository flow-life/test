package owner.test;

import org.aeonbits.owner.ConfigFactory;

/**
 * Created by linjs on 2016/3/29.
 */
public class OwnerTest {
    public static void main(String[] args) {
        ServerConfig config = ConfigFactory.create(ServerConfig.class);
        System.out.println(config.port());
        System.out.println(1 << 3);
//        while(true){
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(config.port());
//        }
    }
}
