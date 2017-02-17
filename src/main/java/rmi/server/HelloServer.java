package rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by pine on 2016/12/9.
 */
public class HelloServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        LocateRegistry.createRegistry(1099);
        HelloInterface hello = new Hello("hello,i'm rmi demo!");
        Naming.rebind("Hello",hello);
    }
}
