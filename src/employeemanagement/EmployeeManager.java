/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lrandom
 */
public class EmployeeManager {
    ArrayList<EmployeeModel> employees ;

    public EmployeeManager() {
       employees = new ArrayList<EmployeeModel>();
    }
    
   
    public EmployeeManager(ArrayList<EmployeeModel> employees) {
        
    }
    
    
    public ArrayList<EmployeeModel> getEmployees(){
       return employees;
    }
    
    public ArrayList<EmployeeModel> addNewEmployee(int id, String fullName, int age, String position, float salary){
       EmployeeModel employee = new EmployeeModel();
       employee.setId(id);
       employee.setFullName(fullName);
       employee.setSalary(salary);
       employee.setPosition(position);
       employee.setAge(age);
       
       employees.add(employee);
       return employees;
    }
    
    public EmployeeModel findEmployeeById(int id){
        for(int i =0; i < employees.size(); i++){
           if(employees.get(i).getId() == id){
              return employees.get(i);
           }
        }
        return null;
    }
    
    public int findIndexOfEmployeeById(int id){
         for(int i =0; i < employees.size(); i++){
           if(employees.get(i).getId() == id){
              return i;
           }
        }
        return -1;
    }
    
    public Boolean editEmployee(int id, String fullName, int age, float salary, String position){
       int index = findIndexOfEmployeeById(id);
       if(index!=-1){
          EmployeeModel employee = employees.get(index);
          employee.setAge(age);
          employee.setSalary(salary);
          employee.setPosition(position);
          employee.setFullName(fullName);
          employees.set(index, employee);
          return true;
       }
       return false;
    }
    

    public Boolean deleteEmployee(int id){
        int index = findIndexOfEmployeeById(id);
        if(index!=-1){
           employees.remove(index);
           return true;
        }else{
           return false;
        }
    }
    
    public ArrayList<EmployeeModel> sortEmployees(){
       ArrayList<EmployeeModel> tmpList = employees;
       for(int i =0; i < (tmpList.size()-1); i++ ){
          for(int j = i+1; j< tmpList.size(); j++){
             EmployeeModel employee1 = tmpList.get(i);
             EmployeeModel employee2 = tmpList.get(j);
             if(employee1.getId() > employee2.getId()){
                tmpList.set(i,employee2);
                tmpList.set(j,employee1);
             }
          }
       }
       return tmpList;
    }
    
    public void listAllEmployees(){
       for(int i = 0; i <employees.size();i++){
           System.out.println("Id:"+ employees.get(i).getId());
           System.out.println("FullName:"+employees.get(i).getFullName());
           System.out.println("Age:"+employees.get(i).getAge());
           System.out.println("Salary"+employees.get(i).getSalary());
           System.out.println("Position"+employees.get(i).getPosition());
           System.out.println("---------------------------------------");
       }
    }
    
    public void listAllEmployees(ArrayList<EmployeeModel> employees){
       if(employees.isEmpty()){
           System.out.println("Do not have any employee");
       }else{
         for(int i = 0; i <employees.size();i++){
           System.out.println("Id: "+ employees.get(i).getId());
           System.out.println("FullName: "+employees.get(i).getFullName());
           System.out.println("Age: "+employees.get(i).getAge());
           System.out.println("Salary: "+employees.get(i).getSalary());
           System.out.println("Position: "+employees.get(i).getPosition());
           System.out.println("---------------------------------------");
         }
       }
    }
}
