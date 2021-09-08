package com.iopayrollpackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollServiceTest {

    EmployeePayrollService employee_1 = new EmployeePayrollService();
    EmployeePayrollService employee_2 = new EmployeePayrollService();
    EmployeePayrollService employee_3 = new EmployeePayrollService();
    Employee e1 = new Employee("Sampriti",1,"40000");
    Employee e2 = new Employee("Tony",1,"30000");
    Employee e3 = new Employee("Tania",1,"45000");

    String directory,file;
    @Test
    public void toCheck_3EmployeeDetails() {
        employee_1.display_EmployeeDetails();
        employee_2.display_EmployeeDetails();
        employee_3.display_EmployeeDetails();
    }

    @Test
    public void toCheck_FileExistsOrNot() {
        employee_1.checkExists(String directory, String file);
        employee_2.checkExists(String directory, String file);
        employee_3.checkExists(String directory, String file);
    }

    @Test
    public void toCheck_EmployeePayrollDataStoredInFile() {
        employee_1.storeObject(e1);
        employee_1.displayObjects();
        employee_2.storeObject(e2);
        employee_2.displayObjects();
        employee_3.storeObject(e3);
        employee_3.displayObjects();
    }
}