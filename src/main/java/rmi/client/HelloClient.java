package rmi.client;

import rmi.server.HelloInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by pine on 2016/12/9.
 */
public class HelloClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        HelloInterface hello = (HelloInterface)Naming.lookup("Hello");
        //HelloInterface hello = (HelloInterface)Naming.lookup("//127.0.0.1:1099/Hello");
        System.out.println(hello.say());
    }
}
