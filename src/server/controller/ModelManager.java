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
    int actualSalary=employee.getSalary();
    int departmentMaxSalaryChange =(int)((employee.getDepartment().getSumSalary())*0.03);
    int employeeMaxSalaryChange= (int) Math.round(actualSalary*0.05);
    
    int salaryMin=actualSalary-(Math.min(departmentMaxSalaryChange,employeeMaxSalaryChange));
    int salaryMax=actualSalary+(Math.min(departmentMaxSalaryChange,employeeMaxSalaryChange));
    return new int[] {salaryMin, salaryMax};
  }

  @Override
  public boolean update(Employee employee) throws RemoteException, ClassNotFoundException, SQLException {
    return employee.update();
  }

  @Override
  public boolean emailExists(String email) throws RemoteException, ClassNotFoundException, SQLException {
    return Employee.emailExists(email);
  }

  @Override
  public int save(Employee employee) throws RemoteException, ClassNotFoundException, SQLException {
    return employee.save();
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
