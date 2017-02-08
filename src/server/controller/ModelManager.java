package server.controller;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ModelManager implements Remote{

  public ModelManager() {
  }

//  public ArrayList<? extends model.Model> getAll() {
//    
//  }
  
  public static void main(String[] args) {
    try {
      ModelManager modelManager=new ModelManager();
      ModelManager szervercsonk=(ModelManager)UnicastRemoteObject.exportObject(modelManager,0);
      Registry r=LocateRegistry.getRegistry();
      r.bind("model", szervercsonk);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
}
