package com.mrudul;

import com.mrudul.dao.ExpenseDAO;
import com.mrudul.model.Expense;
import com.mrudul.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

          Connection connection = DBConnection.getConnection();//woah nigg
//        Rule of thumb:
//        If a class only contains helper methods and no per-object data, make them static and avoid creating instances.

        if(connection!=null)
            System.out.println("Connection to DB done!");
        else System.out.println("Failed to connect");

//        Expense expense1 = new Expense();
//        expense1.setId(1);
//        expense1.setTitle("Veggies");
//        expense1.setCategory("Groceries");
//        expense1.setAmount(100);
//        expense1.setLocalDate(new Date());


//        Expense expense2 = new Expense();
//        expense2.setId(3);
//        expense2.setTitle("Condoms");
//        expense2.setCategory("Safety");
//        expense2.setAmount(90);
//        expense2.setLocalDate(new Date());





        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.println("##############Expense Menu################");
        System.out.println("1. Add Expense");
        System.out.println("2. Get Expense");
        System.out.println("3. Get All Expenses");
        System.out.println("4. Update Expense");
        System.out.println("5. Delete Expense");
        ExpenseDAO expenseDAO = new ExpenseDAO();

        switch (choice){
            case 1:
                Expense expense = new Expense();
                expense.setId(Integer.parseInt(scanner.nextLine()));
                expense.setTitle(scanner.nextLine());
                expense.setAmount(Double.parseDouble(scanner.nextLine()));
                expense.setCategory(scanner.nextLine());
                expense.setLocalDate(new Date());
                expenseDAO.addExpense(expense);
                break;

            case 2:
                System.out.println("Enter id to find: ");
                int id = Integer.parseInt(scanner.nextLine());

                ExpenseDAO expenseDAO1 = new ExpenseDAO();
                Expense expense2 =  expenseDAO1.getExpenseByID(id);
                System.out.println(expense2);
                break;
            case 3:
                ExpenseDAO expenseDAO2 = new ExpenseDAO();
                System.out.println("All expenses are: ");
                List<Expense> expenseList = expenseDAO2.getAllExpenses();

                for (Expense e : expenseList){
                    System.out.println(e);
                }
                break;
            case 4:
                System.out.println("Enter amount to change: ");
                double amount = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter id where to change: ");
                int id_up = Integer.parseInt(scanner.nextLine());

                ExpenseDAO expenseDAO3 = new ExpenseDAO();
                expenseDAO3.updateExpense(amount,id_up);
                break;
            case 5:
                ExpenseDAO expenseDAO4 = new ExpenseDAO();
                System.out.println("Enter id to delete: ");
                int id_del = Integer.parseInt(scanner.nextLine());
                expenseDAO4.deleteExpense(id_del);
                break;
        }


    }
}