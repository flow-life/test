package actor.test.remote;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * client actor to call remote server actor
 * Created by linjs on 2016/4/1.
 */
public class ClientActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(),this);
    //remote actor
    private ActorRef remote;

    public ClientActor(ActorRef remote) {
        this.remote = remote;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof String){
            if(((String) message).startsWith("Start")){
                log.info("Sending message to server - message# Hi there");
                remote.tell("Hi there", getSelf());
            } else {
                log.info("Message received from Server -> " + message);
            }
        }

    }
}
