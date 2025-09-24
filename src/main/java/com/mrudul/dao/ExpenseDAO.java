package com.mrudul.dao;

import com.mrudul.model.Expense;
import com.mrudul.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseDAO {

    public void addExpense(Expense e)
    {
        //add
        String sql_add = "Insert into expense.expenses (id,title,amount,category,date) " +
                "values(?,?,?,?,?)";//ok

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql_add);
            preparedStatement.setInt(1,e.getId());
            preparedStatement.setString(2, e.getTitle());
            preparedStatement.setDouble(3,e.getAmount());
            preparedStatement.setString(4,e.getCategory());
            preparedStatement.setDate(5,new java.sql.Date(e.getLocalDate().getTime()));
            preparedStatement.executeUpdate();


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public Expense getExpenseByID(int id)
    {
        //get
        String sql_getByID = "Select * from expense.expenses where id = ?";
        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql_getByID);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();

            Expense expense = null;
            while(rs.next())
            {
                expense = new Expense();
                expense.setId(rs.getInt("id"));
                expense.setTitle(rs.getString("title"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setCategory(rs.getString("category"));
                expense.setLocalDate(rs.getTimestamp("date"));
            }
            return expense;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Expense> getAllExpenses()
    {
        List<Expense> expenseList = new ArrayList<>();
        //getall
        String sql_getAllExpenses = "Select * from expense.expenses";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql_getAllExpenses);
            ResultSet rs = preparedStatement.executeQuery();

            Expense expense = null;
            while (rs.next())
            {
                expense = new Expense();
                expense.setId(rs.getInt("id"));
                expense.setTitle(rs.getString("title"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setCategory(rs.getString("category"));
                expense.setLocalDate(rs.getTimestamp("date"));
                expenseList.add(expense);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return expenseList;
    }

    public void updateExpense(double amount, int id)
    {
        //update
        String sql_updateExpense = "Update expense.expenses set amount = ? where id = ?";//ok
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql_updateExpense);
            preparedStatement.setDouble(1,amount);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();

            System.out.println("Updated: ");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void deleteExpense(int id)
    {
        //delete
        String sql_deleteExpense = "Delete from expense.expenses where id = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql_deleteExpense);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Deleted!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
