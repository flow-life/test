package actor.test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by linjs on 2016/3/30.
 */
public class Hello1 {

    static class Message{
        private String message;

        public Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
    static class Message2{
        private String message;

        public Message2(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
    static class Hello extends UntypedActor{
        String mes = "";
        public void onReceive(Object message) throws Exception {

            if(message instanceof String){
                System.out.println("single Hello " + message);
            }else if(message instanceof Message){
                System.out.println("pre =[ " + mes + "],latter = " + ((Message) message).getMessage());
                mes = ((Message) message).getMessage();
            }else if(message instanceof  Message2){
                System.out.println(((Message2) message).getMessage());
            }else{
                this.unhandled(message);
            }
        }
    }
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("actor-demo-hello");
        ActorRef hello = system.actorOf(Props.create(Hello.class));
        hello.tell("Bob!",ActorRef.noSender());
        hello.tell(new Message("message"),ActorRef.noSender());
        hello.tell(new Message2("message2"),ActorRef.noSender());
        hello.tell("Bob!",ActorRef.noSender());
        hello.tell(new Message("message-1"),ActorRef.noSender());
        hello.tell(new Message2("message2"),ActorRef.noSender());
        hello.tell("Bob!",ActorRef.noSender());
        hello.tell(new Message("message-2"),ActorRef.noSender());
        hello.tell(new Message2("message2"),ActorRef.noSender());
        hello.tell("Bob!",ActorRef.noSender());
        hello.tell(new Message("message-3"),ActorRef.noSender());
        hello.tell(new Message2("message2"),ActorRef.noSender());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        system.shutdown();
    }
}
