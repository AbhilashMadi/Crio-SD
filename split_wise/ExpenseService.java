package split_wise;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private final List<Expense> expenses;

    public ExpenseService() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        if (expense.validate()) {
            expenses.add(expense);
            System.out.println("Expense successfully added!");
        } else {
            System.out.println("Invalid expense. Check the splits");
        }
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
