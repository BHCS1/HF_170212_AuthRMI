package server.controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Department;
import model.Employee;
import model.Job;

public class ModelManager implements ModelInterface {

  @Override
  public ArrayList<Employee> getAllEmployees() throws RemoteException, ClassNotFoundException, SQLException {
    return Employee.getAll();
  }

  @Override
  public ArrayList<Department> getAllDepartments() throws RemoteException, ClassNotFoundException, SQLException {
    return Department.getAll();
  }

  @Override
  public ArrayList<Job> getAllJobs() throws RemoteException, ClassNotFoundException, SQLException {
    return Job.getAll();
  }

  @Override
  public ArrayList<Employee> getManagers(Department department) throws RemoteException, ClassNotFoundException, SQLException {
    return department.getManagers();
  }

  @Override
  public int[] salaryCalculate(Employee employee) throws RemoteException, ClassNotFoundException, SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean update(Employee employee) throws RemoteException, ClassNotFoundException, SQLException {
    return employee.update();
  }

  @Override
  public String checking(Employee employee, int panelnumber) throws RemoteException, ClassNotFoundException, SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean save(Employee employee) throws RemoteException, ClassNotFoundException, SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  public static void main(String[] args) {
    try {
      ModelManager modelManager=new ModelManager();
      ModelInterface server=(ModelInterface)UnicastRemoteObject.exportObject(modelManager,0);
      Registry r=LocateRegistry.getRegistry();
      r.bind("modelinterface", server);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
