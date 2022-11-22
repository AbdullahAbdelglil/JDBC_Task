package org.example;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserMenu {
    static Scanner in = new Scanner(System.in);

    public static void displayMenu() {
        int option;
        displayUserGuid();
        while (true) {
            System.out.print("Please Enter The Operation Number You Want : ");
            option = in.nextInt();
            split();
            switch (option) {
                case 1:
                    addEmployee();
                    split();
                    break;

                case 2:
                    search();
                    split();
                    break;

                case 3:
                    update();
                    split();
                    break;

                case 4:
                    delete();
                    split();
                    break;

                case 5:
                    displayAll();
                    break;

                case 6:
                    deleteAll();
                    split();
                    break;

                case 0:
                    System.out.println("Good Bye ❤");
                    return;

                default:
                    System.out.println("Invalid Choice , Please Select Your Option From The Menu");
            }
        }
    }
    public static void split() {
        System.out.println("-----------------------------------------------");
    }

    public static void displayUserGuid(){
        System.out.println("Hello\nThis Is Employee Management System");
        split();
        System.out.println("⬜ System Operations : ");
        System.out.println("   ◻ 1 : Add New Employee");
        System.out.println("   ◻ 2 : Search By Id");
        System.out.println("   ◻ 3 : Update Employee Info");
        System.out.println("   ◻ 4 : Delete Employee");
        System.out.println("   ◻ 5 : Get All Employees From DataBase");
        System.out.println("   ◻ 6 : Delete All Employees From DataBase");
        System.out.println("   ◻ 0 : Exit");
        split();
    }
    //Add Employee Method
    public static boolean addEmployee() {
        System.out.print("Please Enter Employee ID : ");
        int id = in.nextInt();
        System.out.print("\nPlease Enter Employee Name : ");
        in.nextLine();
        String name = in.nextLine();
        System.out.print("\nPlease Enter Employee Phone Number : ");
        String phNum = in.nextLine();
        System.out.print("\nPlease Enter Employee Email : ");
        String email = in.nextLine();
        System.out.println();
        boolean added = Employee.addEmployee(id, name, phNum, email);
        return added;
    }

    //Search Method
    public static void search() {
        System.out.print("Please Enter The ID : ");
        int id = in.nextInt();
        String empData = Employee.searchById(id);
        System.out.println("Employee With Id : "+id+" -> | "+empData);
    }

    //Update Method
    public static void update() {
        int newID,oldId;
        String newName, newPhNum, newEmail;
        System.out.println("⬜ Update Options : ");
        System.out.println("   ◻ 1 : Update All Data");
        System.out.println("   ◻ 2 : Update Only Employee Id");
        System.out.println("   ◻ 3 : Update Only Employee Name");
        System.out.println("   ◻ 4 : Update Only Employee Phone number");
        System.out.println("   ◻ 5 : Update Only Employee Email");
        System.out.println("   ◻ 0 : Exit");
        System.out.print("\n Please Enter The Option Number You Want : ");
        int option = in.nextInt();
        if(option!=0) {
            System.out.println();
            System.out.print("Please Enter The Id : ");
            oldId = in.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    System.out.print("Please Enter New ID : ");
                    newID = in.nextInt();
                    System.out.print("\nPlease Enter New Name : ");
                    in.nextLine();
                    newName = in.nextLine();
                    System.out.print("\nPlease Enter New Phone Number : ");
                    newPhNum = in.nextLine();
                    System.out.print("\nPlease Enter New Email : ");
                    newEmail = in.nextLine();
                    System.out.println();
                    Employee.updateEmpInfo(oldId, newID, newName, newPhNum, newEmail);
                    break;

                case 2:
                    System.out.print("Please Enter New ID : ");
                    newID = in.nextInt();
                    System.out.println();
                    Employee.updateEmpId(oldId, newID);
                    break;

                case 3:
                    System.out.print("Please Enter New Name : ");
                    newName = in.nextLine();
                    System.out.println();
                    Employee.updateEmpName(oldId, newName);
                    break;

                case 4:
                    System.out.print("Please Enter New Phone Number : ");
                    newPhNum = in.nextLine();
                    System.out.println();
                    Employee.updateEmpPhNum(oldId, newPhNum);
                    break;

                case 5:
                    System.out.print("Please Enter New Email : ");
                    newEmail = in.nextLine();
                    System.out.println();
                    Employee.updateEmpEmail(oldId, newEmail);
                    break;
            }
        }
    }

    public static void delete(){
        System.out.print("Please Enter The Id : ");int id=in.nextInt();
        System.out.println();
        boolean result  = Employee.deleteEmployee(id);
        if (result==true)
            System.out.println("The Employee Deleted Successfully");
        else
            System.out.println("Invalid Id , Please try Again");

    }

    public static void deleteAll(){
            String confirm = "";
            System.out.println("Relly ? , Are You Want To Delete All Data ?\nenter 'Yes' To Confirm OR 'No' To Back To Menu : ");
            in.nextLine();
            confirm=in.nextLine();
            confirm=confirm.toLowerCase();
        if (confirm.equals("yes") {
            Employee.deleteAllEmp();
            System.out.println("All Data Deleted Successfully");
        }
    }

    public static void displayAll(){
        ResultSet result = Employee.getAll();
        int id;
        String name,phNum,email,formatOutput;
        try{
            System.out.println();
            System.out.println(" -----------------------------------------------------------------------------------------------");
            System.out.println("|     ID     |               Name               |     Phone Number     |          Email          |");
            System.out.println(" ------------------------------------------------------------------------------------------------");
            while(result.next()){
                id = result.getInt(1);
                name = result.getString(2);
                phNum = result.getString(3);
                email = result.getString(4);
                formatOutput = String.format("|  %-8d  |  %-30s  |  %-18s  |  %-21s  |",id,name,phNum,email);
                System.out.println(formatOutput);
            }
            System.out.println("-----------------------------------------------------------------------------------------------\n");
            split();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
