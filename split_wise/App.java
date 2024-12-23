package split_wise;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create Users
        User user1 = new User("alice@example.com");
        User user2 = new User("bob@example.com");
        User user3 = new User("charlie@example.com");

        // Expense Service
        ExpenseService expenseService = new ExpenseService();

        // Balance Manager
        BalanceManager balanceManager = new BalanceManager();

        // Create and Add Equal Expense
        List<Split> equalSplits = Arrays.asList(new EqualSplit(user1), new EqualSplit(user2), new EqualSplit(user3));
        Expense equalExpense = new EqualExpense(300, user1, equalSplits, "Dinner");
        expenseService.addExpense(equalExpense);
        balanceManager.updateBalance(user1.getId(), equalSplits, 300);

        // Show Balances
        balanceManager.showBalances();
    }
}
