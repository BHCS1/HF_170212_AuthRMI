package server.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Department;
import model.Employee;
import model.Job;

public interface ModelInterface extends Remote {
  
  // Employee.getAll()
  ArrayList<Employee> getAllEmployees() throws RemoteException, ClassNotFoundException, SQLException;
  
  // Department.getAll()
  ArrayList<Department> getAllDepartments() throws RemoteException, ClassNotFoundException, SQLException;
  
  // Job.getAll()
  ArrayList<Job> getAllJobs() throws RemoteException, ClassNotFoundException, SQLException;
  
  // department.getManagers()
  ArrayList<Employee> getManagers(Department department) throws RemoteException, ClassNotFoundException, SQLException;
  
  // return {minSalary, maxSalary}
  int[] salaryCalculate(Employee employee) throws RemoteException, ClassNotFoundException, SQLException;
  
  // employee.update()
  boolean update(Employee employee) throws RemoteException, ClassNotFoundException, SQLException;
  
  // mondjuk ha üresen, vagy "VALID" jön vissza, akkor OK, egyébként pedig hibaüzenet, amit meg lehet jeleníteni JOptonPane-ben
  String checking(Employee employee, int panelnumber) throws RemoteException, ClassNotFoundException, SQLException;
  
  // employee.save()
  boolean save(Employee employee) throws RemoteException, ClassNotFoundException, SQLException;
  
}
