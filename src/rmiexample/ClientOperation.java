package rmiexample;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;




public class ClientOperation {

	private static RMIInterface look_up;

	public static void main(String[] args) 
		throws MalformedURLException, RemoteException, NotBoundException {
                    
                    look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");                    
                    //System.out.println("Please indicate the number of servers: ");                    
                    int i = 0;
                    String txt = " "; 
                    String txt2 = "";                   
                    String[] nombre = new String [100];
                                    
                          do{
                                nombre[i] = JOptionPane.showInputDialog("What is your name?"); 
                                txt = nombre[i];
                                if (txt.equals(txt2)){                          
                                    JOptionPane.showMessageDialog(null, "Please write another one"); 
                                    
                                }
                                else{                            
                                txt2 = txt;
                                System.out.println("Hola:  "+txt);     
                                String response = look_up.helloTo(txt);
                                JOptionPane.showMessageDialog(null, response);
                                }
                             i++;
                           }while(txt.equals(txt2));
                       
                     
         
                    //String txt = JOptionPane.showInputDialog("What is your name?");                                                             
                    
                    
                                                                                                                                                
    }
}
