package com.mrudul;

import com.mrudul.dao.ExpenseDAO;
import com.mrudul.exception.DatabaseOperationException;
import com.mrudul.exception.ExpenseNotFoundException;
import com.mrudul.model.Expense;
import com.mrudul.service.ReportService;
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

        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while (choice!=9) {

            System.out.println("##############Expense Menu################");
            System.out.println("1. Add Expense");
            System.out.println("2. Get Expense");
            System.out.println("3. Get All Expenses");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Get Total Expenses");
            System.out.println("7. Expenses by Category");
            System.out.println("8. Get monthly report");
            System.out.println("9. Tschüss");
            System.out.println("Choice bitte: ");
            choice = Integer.parseInt(scanner.nextLine());
            ExpenseDAO expenseDAO = new ExpenseDAO();

            switch (choice) {
                case 1:
                    Expense expense = new Expense();
                    expense.setId(Integer.parseInt(scanner.nextLine()));
                    expense.setTitle(scanner.nextLine());
                    expense.setAmount(Double.parseDouble(scanner.nextLine()));
                    expense.setCategory(scanner.nextLine());
                    expense.setLocalDate(new Date());
                    try {
                        expenseDAO.addExpense(expense);
                    } catch (DatabaseOperationException e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("Enter id to find: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    ExpenseDAO expenseDAO1 = new ExpenseDAO();
                    Expense expense2 = null;
                    try {
                        expense2 = expenseDAO1.getExpenseByID(id);
                    } catch (ExpenseNotFoundException e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                    //System.out.println(expense2);
                    break;
                case 3:
                    ExpenseDAO expenseDAO2 = new ExpenseDAO();
                    System.out.println("All expenses are: ");
                    List<Expense> expenseList = null;
                    try {
                        expenseList = expenseDAO2.getAllExpenses();
                    } catch (ExpenseNotFoundException e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }

                    for (Expense e : expenseList) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Enter amount to change: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter id where to change: ");
                    int id_up = Integer.parseInt(scanner.nextLine());

                    ExpenseDAO expenseDAO3 = new ExpenseDAO();
                    expenseDAO3.updateExpense(amount, id_up);
                    break;
                case 5:
                    ExpenseDAO expenseDAO4 = new ExpenseDAO();
                    System.out.println("Enter id to delete: ");
                    int id_del = Integer.parseInt(scanner.nextLine());
                    expenseDAO4.deleteExpense(id_del);
                    break;
                case 6:
                    ReportService reportService = new ReportService();
                    double totalExpenses = reportService.getTotalExpenses();
                    System.out.println("Total Expenses: " + totalExpenses);
                    break;

                case 7:
                    ReportService reportService1 = new ReportService();
                    String category = scanner.nextLine();
                    double expensesByCategory = reportService1.getExpensesByCategory(category);
                    System.out.println("Expense by " + category + " "+ expensesByCategory);
                    break;

            }

        }
    }
}