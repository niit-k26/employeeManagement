/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author Lrandom
 */
public class EmployeeDAL {
    public static final String PATH="employee";
    
    FileOutputStream fos;
    FileInputStream fis;
    
    public EmployeeDAL(){
        if(!fileExist(PATH)){
           File file = new File(PATH);
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public ArrayList<EmployeeModel> readEmployee(){
        ArrayList<EmployeeModel> employees=new ArrayList<EmployeeModel>();
        try {
              File file = new File(PATH);
              if(file.length()!=0){
                fis = new FileInputStream(new File(PATH));
                ObjectInputStream obt = new ObjectInputStream(fis);
                employees=(ArrayList<EmployeeModel>)obt.readObject();
              }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
              if(fis!=null){
                  try {
                      fis.close();
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
              }  
        }    
        return employees;
    }
    
    public void saveEmployee(ArrayList<EmployeeModel> employees){
        try {
              fos = new FileOutputStream(new File(PATH));
              ObjectOutputStream fot = new ObjectOutputStream(fos);
              fot.writeObject(employees);
        } catch (Exception e) {
              e.printStackTrace();
        }finally{
              if(fos!=null){
                  try {
                      fos.close();
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
              }
              
        }
    }
    
    public Boolean fileExist(String path){
       File file = new File(path);
       if(file.exists() && !file.isDirectory()){
          return true;
       }
       return false;
    }
}
