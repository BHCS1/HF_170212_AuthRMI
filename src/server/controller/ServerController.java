package server.controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import server.authentication.AuthInterface;
import server.authentication.Authentication;

public class ServerController {
          
  public static void main(String[] args) {
    try {
      AuthInterface serverAuth=(AuthInterface)UnicastRemoteObject.exportObject(new Authentication(),0);
      Registry r=LocateRegistry.getRegistry();
      r.bind("authentication", serverAuth);
    }
    catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }
  }
  
}
