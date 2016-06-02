package actor.test.remote;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.kernel.Bootable;
import com.typesafe.config.ConfigFactory;

/**
 * 客户端启动类
 * Created by linjs on 2016/4/1.
 */
public class ClientActorSystem implements Bootable {

    private LoggingAdapter log = null;
    private ActorSystem system;
    private ActorRef actor;
    private ActorRef remoteActor;

    public ClientActorSystem() {
        system = ActorSystem.create("ClientSys", ConfigFactory.load().getConfig("ClientSys"));
        log = Logging.getLogger(system,this);
    }

    public void remoteActorRef(){
        log.info("Createing a reference to remote actor");
        //creating a reference to the remote ServerActor
        //by passing the complete remote actor path
        remoteActor = system.actorFor("akka://ServerSys@127.0.0.1:2552/user/serverActor");
        log.info("ServerActor with hashcode #" + remoteActor.hashCode());
        // create a local actor and pass the reference of the remote actor
//        actor = system.actorOf(new Props(new UntypedActorFactory() {
//            public Actor create() throws Exception {
//                return new ClientActor(remoteActor);
//            }
//        }));
        // send a message to the local client actor
        actor.tell("Start-RemoteActorRef",ActorRef.noSender());

    }
    public void startup() {
        log.info("ClientActorSystem startup...");
    }

    public void shutdown() {
        log.info("ClientActorSystem shutdown...");
    }
}
