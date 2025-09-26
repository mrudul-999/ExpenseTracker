package service;

import com.mrudul.service.ReportService;
import org.junit.Test;

public class ReportServiceTest {

    @Test
    public void getTotal_Expenses()
    {
        ReportService reportService = new ReportService();
        double test_total = reportService.getTotalExpenses();
        System.out.println(test_total);
    }

    @Test
    public void getTotalExpenseByCategory()
    {
        ReportService reportService = new ReportService();
        double cat_wise_total = reportService.getExpensesByCategory("Stationary");
        System.out.println(cat_wise_total);
    }

    @Test
    public void getTotalExpense_NoExpenses()
    {
        ReportService reportService = new ReportService();
        double zero_expenses = reportService.getExpensesByCategory("nill");
        System.out.println("No expenses: " + zero_expenses);
    }
}
