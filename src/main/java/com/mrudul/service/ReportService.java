package com.mrudul.service;

import com.mrudul.dao.ExpenseDAO;
import com.mrudul.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportService {

    public double getTotalExpenses() {
        ExpenseDAO expenseDAO = new ExpenseDAO();
        String sql_getTotalExpense = "Select SUM(amount) as total from expense.expenses";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql_getTotalExpense);
            ResultSet rs = preparedStatement.executeQuery();
            double amount = 0;
            if (rs.next())
            {
                return rs.getDouble("total");
            }
            return amount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public double getExpensesByCategory(String category)
    {
        String sql_getExpenseByCategory = "Select SUM(amount) as total_cat from expense.expenses where category = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql_getExpenseByCategory);
            preparedStatement.setString(1,category);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                return rs.getDouble("total_cat");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    double getMonthlyReport(int month, int year)
    {
        return 0;
    }
}
