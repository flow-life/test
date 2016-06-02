package actor.test.remote;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.kernel.Bootable;
import com.typesafe.config.ConfigFactory;

/**
 * 启动类 启动server actor
 * Created by linjs on 2016/4/1.
 */
public class ServerActorSystem implements Bootable{

    private LoggingAdapter log = null;
    private ActorSystem system;

    //default constructor
    public ServerActorSystem(){
      // load the configuration
        system = ActorSystem.create("ServerSys", ConfigFactory.load().getConfig("ServerSys"));
        log = Logging.getLogger(system,this);
        //create actor
        system.actorOf(Props.create(ServerActor.class),"serverActor");
    }

    public void startup() {
        log.info("ServerActorSystem start");
    }

    public void shutdown() {
        log.info("Shutting down the ServerActorSystem");
    }

    public static void main(String[] args) {
        new ServerActorSystem();
    }
}
