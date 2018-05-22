/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lrandom
 */
public class EmployeeManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice;
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please select menu");
            System.out.println("1. List all employee");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Delete employee");
            System.out.println("5. Find a employee");
            System.out.println("6. Sort employees");
            System.out.println("7. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You choice list employees");
                    employeeManager.listAllEmployees();
                    break;

                case 2:
                    System.out.println("You choice add new employees");
                    System.out.println("ID:");
                    int id = scanner.nextInt();

                    scanner.nextLine();
                    System.out.println("FullName:");
                    String fullName = scanner.nextLine();

                    System.out.println("Age:");
                    int age = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Position");
                    String position = scanner.nextLine();

                    System.out.println("Salary");
                    float salary = scanner.nextFloat();

                     {
                        try {
                            employeeManager.addNewEmployee(id, fullName, age, position, salary);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("Add successfully !!!!");
                    break;

                case 3:
                    System.out.println("Please input employee id: ");
                    int id1 = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("FullName:");
                    String fullName1 = scanner.nextLine();

                    System.out.println("Age:");
                    int age1 = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Position: ");
                    String position1 = scanner.nextLine();

                    System.out.println("Salary: ");
                    float salary1 = scanner.nextFloat();
                    Boolean canEdit = employeeManager.editEmployee(id1, fullName1, age1, salary1, position1);
                    if (canEdit) {
                        System.out.println("Edit successfully !!!");
                    } else {
                        System.out.println("Employee not found. Edit failed !!!");
                    }
                    break;

                case 4:
                    System.out.println("Type an id to delete");
                    int id2 = scanner.nextInt();
                    Boolean deleted = employeeManager.deleteEmployee(id2);
                    if (deleted) {
                        System.out.println("Deleted successfully!!!");
                    } else {
                        System.out.println("Not found");
                    }
                    break;

                case 5:
                    System.out.println("Type an id to find");
                    int id3 = scanner.nextInt();
                    EmployeeModel employee = employeeManager.findEmployeeById(id3);
                    if (employee != null) {
                        System.out.println("Found: ");
                        System.out.println(employee.getId());
                        System.out.println(employee.getFullName());
                        System.out.println(employee.getAge());
                        System.out.println(employee.getSalary());
                        System.out.println(employee.getPosition());
                    } else {
                        System.out.println("Not found !!! ");
                    }
                    break;

                case 6:
                    ArrayList<EmployeeModel> tmp = employeeManager.sortEmployees();
                    employeeManager.listAllEmployees(tmp);
                    break;

                default:
                    break;

            }
        } while (choice != 7);
    }

}
