package org.example;
import java.sql.*;
public class Employee {
    //Connect DataBase
    private static SingleToneConnection instance = SingleToneConnection.getInstance();
    private static Connection connection = instance.connectToDatabase();

    //Creat Statements
    private static PreparedStatement preparedStatement = null;
    private static Statement statement = null;
    private static ResultSet result = null;

    //Insert New Employee
    public static boolean addEmployee(int Id, String empName, String phNum, String empEmail) {
        try {
            preparedStatement = connection.prepareStatement("insert into employee " + "(ID,emp_name ,emp_phNum,emp_email)" + "values " + "(?,?,?,?)");
            preparedStatement.setInt(1, Id);
            preparedStatement.setString(2, empName);
            preparedStatement.setString(3, phNum);
            preparedStatement.setString(4, empEmail);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //Search By ID
    public static String searchById(int id) {
        try {
            String sql = "select * from employee where ID=" + id;
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            result.next();
            String empData = result.getString(2)+" | "+result.getString(3)+" | "+ result.getString(4)+" |";
            return empData;
        } catch (SQLException e) {
            return "This Emp_Id Not Founded In DataBase!";
        }
    }

    //Delete Employee By Passing His id
    public static boolean deleteEmployee(int id) {
        if (searchById(id) != "This Emp_Id Not Founded In DataBase!") {
            try {
                String sql = "delete from employee where ID=" + id;
                preparedStatement = connection.prepareStatement(sql);
                int row = preparedStatement.executeUpdate();
                return true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    //Delete All Employees
    public static int deleteAllEmp(){
        String sql="truncate table employee";
        try{
            statement=connection.createStatement();
            int row = statement.executeUpdate(sql);
            return row;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    //Update Employee Information by Passing His id
    public static boolean updateEmpInfo(int id, int newId, String newName, String newPhNum, String newEmail) {
        if (searchById(id) != "This Emp_Id Not Founded In DataBase!") {
            try {
                preparedStatement = connection.prepareStatement("update employee set ID=?,emp_name=? , emp_phNum=? , emp_email=? where ID=" + id);
                preparedStatement.setInt(1, newId);
                preparedStatement.setString(2, newName);
                preparedStatement.setString(3, newPhNum);
                preparedStatement.setString(4, newEmail);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    //Update Only Employee ID
    public static boolean updateEmpId(int id, int newId) {
        if (searchById(id) != "This Emp_Id Not Founded In DataBase!") {
            try {
                preparedStatement = connection.prepareStatement("update employee set ID=?where ID=" + id);
                preparedStatement.setInt(1, newId);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    //update Only Employee Name
    public static boolean updateEmpName(int id, String newName) {
        if (searchById(id) != "This Emp_Id Not Founded In DataBase!") {
            try {
                preparedStatement = connection.prepareStatement("update employee set emp_name=?where ID=" + id);
                preparedStatement.setString(1, newName);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    //Update Only Employee Phone Number
    public static boolean updateEmpPhNum(int id, String newPhNum) {
        if (searchById(id) != "This Emp_Id Not Founded In DataBase!") {
            try {
                preparedStatement = connection.prepareStatement("update employee set emp_phNum=?where ID=" + id);
                preparedStatement.setString(1, newPhNum);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    //Update Only Employee Email
    public static boolean updateEmpEmail(int id, String newEmail) {
        if (searchById(id) != "This Emp_Id Not Founded In DataBase!") {
            try {
                preparedStatement = connection.prepareStatement("update employee set emp_email=?where ID=" + id);
                preparedStatement.setString(1, newEmail);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    //Get All Employees From Database
    public static ResultSet getAll() {
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("select * from employee");
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
