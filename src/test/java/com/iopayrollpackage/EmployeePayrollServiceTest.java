package com.iopayrollpackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeePayrollServiceTest {

    EmployeePayrollService employee_1 = new EmployeePayrollService();
    EmployeePayrollService employee_2 = new EmployeePayrollService();
    EmployeePayrollService employee_3 = new EmployeePayrollService();

    @Test
    public void toCheck_3EmployeeDetails() {
        employee_1.display_EmployeeDetails();
        employee_2.display_EmployeeDetails();
        employee_3.display_EmployeeDetails();
    }
}