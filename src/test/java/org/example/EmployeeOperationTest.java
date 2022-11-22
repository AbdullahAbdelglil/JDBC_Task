package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class EmployeeOperationTest {
    @Nested
    @DisplayName("Add Operation Should ")
    class AddOperationTest {
        @Test
        @DisplayName("Return True because The Employee Successfully Added")
        void addEmployeeShouldReturnTrue() {
            assertEquals(true, Employee.addEmployee(1, "ahmed", "ahmed@gamil.com", "01151625051"));
        }
        @Test
        @DisplayName("Return false because This ID Already Exist In DataBase")
        void addEmployeeShouldReturnFalse() {
            assertEquals(false, Employee.addEmployee(1, "ahmed", "ahmed@gamil.com", "01151625051"));
        }
    }
    @Nested
    @DisplayName("Delete Operation Should ")
    class DeleteOperationTest{
        @Test
        @DisplayName("Return True because This Employee Successfully Deleted From First Row")
        void deleteEmployeeShouldReturnOne(){
            assertEquals(true,Employee.deleteEmployee(1));
        }

        @Test
        @DisplayName("Return false because This Employee Not Founded In DataBase")
        void deleteEmployeeShouldReturnZero(){
            assertEquals(false,Employee.deleteEmployee(1));
        }

        @Test
        void deleteAllEmployeesFromDataBase(){
            assertEquals(0,Employee.deleteAllEmp());
        }
    }

    @Nested
    @DisplayName("Search Operation Should ")
    class SearchOperationTest {
        @Test
        @DisplayName("Return Abdullah | 01013803525 | bondokalol22@gamil.com")
        void searchByIdTowShouldReturnAbdelrahman() {
            assertEquals("Abdullah | 01013803525 | bondokalol22@gamil.com",Employee.searchById(2));
        }

        @Test
        @DisplayName("Return This Emp_Id Not Founded In Data Base!")
        void searchByIdTowShouldReturnThisEmployeeNotFounded() {
            assertEquals("This Emp_Id Not Founded In DataBase!",Employee.searchById(7));
        }
    }

    @Nested
    @DisplayName("Update Operation Should ")
    class UpdateOperationTest{
        @Test
        @DisplayName("Return True Because Employee Information Successfully Updated")
        void shouldReturnTow(){
            assertEquals(true,Employee.updateEmpInfo(2,1,"Abdullah","01151625051","bondokalol22@gmail.com"));
        }

        @Test
        @DisplayName("Return False Because This Employee_ID Not Founded In DataBase")
        void shouldReturnZero(){
            assertEquals(false,Employee.updateEmpInfo(5,1,"Abdullah","01151625051","bondokalol22@gmail.com"));
        }
    }

}
