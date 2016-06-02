package actor.test.remote;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * server actor / remote actor
 * Created by linjs on 2016/4/1.
 */
public class ServerActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(this.getContext().system(),this);
    private static int instanceCounter = 0;

    @Override
    public void preStart() throws Exception {
        instanceCounter++;
        log.info("Starting ServerActor instance #" + instanceCounter
                + ", hashcode #" + this.hashCode());
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof String){
           getSender().tell(message + " got something", ActorRef.noSender());
        }else if(message instanceof PoisonPill){
            getContext().system().shutdown();
        }
    }

    @Override
    public void postStop() throws Exception {
        log.info("Stopping ServerActor instance #" + instanceCounter
                + ", hashcode #" + this.hashCode());
        instanceCounter--;
    }

    public static class PoisonPill{

    }
}
