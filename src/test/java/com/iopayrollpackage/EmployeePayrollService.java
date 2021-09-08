package com.iopayrollpackage;

import org.junit.jupiter.engine.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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

    }
}