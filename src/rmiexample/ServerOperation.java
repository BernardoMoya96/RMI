package rmiexample;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.util.Date;


public class ServerOperation extends UnicastRemoteObject implements RMIInterface{

    private static final long serialVersionUID = 1L;

    protected ServerOperation() throws RemoteException {

        super();

    }

    @Override
    public String helloTo(String name) throws RemoteException{
        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        
        System.err.println(name + " is trying to contact!"+" "+ts);
        return "Server says hello to " +name +" "+ts;
      

    }

    public static void main(String[] args){
        
        try {

            Naming.rebind("//localhost/MyServer", new ServerOperation());            
            System.err.println("Server ready");

        } catch (MalformedURLException | RemoteException e) {

            System.err.println("Server exception: " + e.toString());

        }

    }

}
