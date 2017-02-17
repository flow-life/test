package rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by pine on 2016/12/9.
 */
public class Hello extends UnicastRemoteObject implements HelloInterface {

    private String message;

    public Hello(String src) throws RemoteException {
        this.message = src;
    }

    @Override
    public String say() throws RemoteException {
        System.out.println("remote method called.");
        return message;
    }
}
