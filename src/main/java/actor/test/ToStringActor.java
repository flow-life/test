package actor.test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by linjs on 2016/3/29.
 */
public class ToStringActor extends UntypedActor {

    public void onReceive(Object message) throws Exception {

        System.out.println(Thread.currentThread().getName()+":"+message.toString());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("toStringActor");
        final ActorRef toString = system.actorOf(Props.create(ToStringActor.class),"toString");
        for(int i=0;i<100;i++) {
            toString.tell("test"+i,toString);
        }
        System.out.println("[结束]=======================");
    }
}
