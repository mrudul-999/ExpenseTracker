package com.mrudul;

import com.mrudul.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

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

        Expense expense1 = new Expense();
        Expense expense2 = new Expense();
        Expense expense3 = new Expense();

        expense1.setId(1);
        expense1.setAmount(100);
        expense1.setCategory("Food");
        expense1.setTitle("Kartoffel");
        expense1.setLocalDate(new Date());


        expense2.setId(2);
        expense2.setAmount(200);
        expense2.setCategory("Drink");
        expense2.setTitle("Apfelsaft");
        expense2.setLocalDate(new Date());


        expense3.setId(3);
        expense3.setAmount(300);
        expense3.setCategory("Sweet");
        expense3.setTitle("Kuchen");
        expense3.setLocalDate(new Date());

        System.out.println(expense1);
        System.out.println(expense2);
        System.out.println(expense3);
    }
}