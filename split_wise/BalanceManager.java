package split_wise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceManager {
    private final Map<String, Map<String, Double>> balanceSheet;

    public BalanceManager() {
        this.balanceSheet = new HashMap<>();
    }

    public void updateBalance(String paidBy, List<Split> splits, double amount) {
        balanceSheet.putIfAbsent(paidBy, new HashMap<>());

        for (Split split : splits) {
            String userId = split.getUser().getId();
            balanceSheet.putIfAbsent(userId, new HashMap<>());

            double balance = balanceSheet.get(paidBy).getOrDefault(userId, 0.0);
            balanceSheet.get(paidBy).put(userId, balance + split.getAmount());

            double reverseBalance = balanceSheet.get(userId).getOrDefault(paidBy, 0.0);
            balanceSheet.get(userId).put(paidBy, reverseBalance - split.getAmount());
        }
    }

    public void showBalances() {
        for (String user : balanceSheet.keySet()) {
            for (Map.Entry<String, Double> entry : balanceSheet.get(user).entrySet()) {
                if (entry.getValue() != 0) {
                    System.out.println(user + " owes " + entry.getKey() + ": " + entry.getValue());
                }
            }
        }
    }
}
