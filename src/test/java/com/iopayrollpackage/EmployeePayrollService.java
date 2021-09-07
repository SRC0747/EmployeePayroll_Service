package com.iopayrollpackage;

import java.util.*;

public class EmployeePayrollService {
    int id;
    String name;
    double salary;
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
    public static void main(String[] args){
        System.out.println("Welcome to Employee Payroll Service System");
        EmployeePayrollService employeePayrollService_1 = new EmployeePayrollService();
        EmployeePayrollService employeePayrollService_2 = new EmployeePayrollService();
        EmployeePayrollService employeePayrollService_3 = new EmployeePayrollService();
        employeePayrollService_1.display_EmployeeDetails();
        employeePayrollService_2.display_EmployeeDetails();
        employeePayrollService_3.display_EmployeeDetails();
    }
}