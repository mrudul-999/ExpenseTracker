package com.mrudul.util.dao;

import com.mrudul.Expense;
import com.mrudul.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ExpenseDAO {

    void addExpense(Expense e)
    {
        //add
        String sql_add = "Insert into expenses.expense values(?,?,?,?,?)";//ok

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql_add);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    Expense getExpenseByID(int id)
    {
        //get
        String sql_getByID = "Select * from expenses.expense where id = ?";
    }

    List<Expense> getAllExpenses()
    {
        //getall
        String sql_getAllExpenses = "Select * from expenses.expense";
    }

    void updateExpense(Expense e)
    {
        //update
        String sql_updateExpense = "Update expenses.expense set";//ok
    }

    void deleteExpense(int id)
    {
        //delete
        String sql_deleteExpense = "Delete expense.expenses where id = ?";
    }
}
