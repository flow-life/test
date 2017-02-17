package rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by pine on 2016/12/9.
 */
public interface HelloInterface extends Remote {
    /**
     * the method must throw RemoteException
     * @return
     * @throws RemoteException
     */
    String say() throws RemoteException;
}
