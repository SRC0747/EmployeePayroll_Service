package com.iopayrollpackage;

import org.junit.jupiter.engine.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class EmployeePayrollService {
    int id;
    String name;
    double salary;
    String directory,file;
    EmployeePayrollService(){
        id =0;
        name =" ";
        salary =0;
    }
    EmployeePayrollService(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public static void display_EmployeeDetails(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Employee id:");
        int id = sc.nextInt();
        System.out.println("Enter Employee Name:");
        String name = sc.next();
        System.out.println("Enter Employee Salary:");
        double salary = sc.nextDouble();
        System.out.println("Employee ID is:"+id);
        System.out.println("Employee Name is:"+name);
        System.out.println("Employee Salary is:"+salary);
    }
    //Checking File exists in that particular Directory or not.
    public static int checkExists(String directory, String file) {
        File dir = new File(directory);
        File[] dir_contents = dir.listFiles();
        String temp = file + ".MOD";
        boolean check = new File(temp).exists();
        System.out.println("Check"+check);  // -->always says false

        for(int i = 0; i<dir_contents.length;i++) {
            if(dir_contents[i].getName() == (file + ".MOD"))
                return Constants.FILE_EXISTS;
        }

        return Constants.FILE_DOES_NOT_EXIST;
    }

    //Checking How Many Lines in the File.
    public static long countLineJava8(String abc.txt) {

        Path path = Paths.get(abc.txt);

        long lines = 0;
        try {

            // much slower, this task better with sequence access
            //lines = Files.lines(path).parallel().count();

            lines = Files.lines(path).count();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;

    }

    //Creating Employee Payroll Service to store Employee Data into File.
    public void storeObject(Employee emp){

        OutputStream ops = null;
        ObjectOutputStream objOps = null;
        try {
            ops = new FileOutputStream("MyEmpFile.txt");
            objOps = new ObjectOutputStream(ops);
            objOps.writeObject(emp);
            objOps.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(objOps != null) objOps.close();
            } catch (Exception ex){

            }
        }

    }

    public void displayObjects(){

        InputStream fileIs = null;
        ObjectInputStream objIs = null;
        try {
            fileIs = new FileInputStream("MyEmpFile.txt");
            objIs = new ObjectInputStream(fileIs);
            Employee emp = (Employee) objIs.readObject();
            System.out.println(emp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(objIs != null) objIs.close();
            } catch (Exception ex){

            }
        }

    }
    public static void main(String[] args){
        System.out.println("Welcome to Employee Payroll Service System");
        String directory,file;
        EmployeePayrollService employeePayrollService_1 = new EmployeePayrollService();
        EmployeePayrollService employeePayrollService_2 = new EmployeePayrollService();
        EmployeePayrollService employeePayrollService_3 = new EmployeePayrollService();
        employeePayrollService_1.display_EmployeeDetails();
        employeePayrollService_2.display_EmployeeDetails();
        employeePayrollService_3.display_EmployeeDetails();
        int result_1 = employeePayrollService_1.checkExists(String directory, String file);
        int result_2 = employeePayrollService_2.checkExists(String directory, String file);
        int result_3 = employeePayrollService_3.checkExists(String directory, String file);

        //Checking How many lines are there in File.
        System.out.println("No. of lines in the File is:"+countLineJava8(String abc.txt));

        //Displaying Employee Details stored into File.
        EmployeePayrollService obj = new EmployeePayrollService();
        Employee e1 = new Employee("Tony",1,"1000");
        obj.storeObject(e1);
        obj.displayObjects();
    }
}

class Employee implements Serializable{

    private String name;
    private int id;
    private String salary;

    public Employee(String name, int id, String salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String toString(){
        return name +"=="+id+"=="+salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}