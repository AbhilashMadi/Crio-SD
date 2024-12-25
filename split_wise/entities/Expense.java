package split_wise.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Expense {
    private String id;
    private final String description;
    private final double amount;
    private final String paidBy;
    private final List<Split> splits;
    private final String groupId;

    public Expense(String description, double amount, String paidBy, List<Split> splits, String groupId) {
        this.id = null;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.groupId = groupId;
    }

    public Expense(String id, Expense other) {
        this.id = id;
        this.description = other.description;
        this.amount = other.amount;
        this.paidBy = other.paidBy;
        this.splits = other.splits;
        this.groupId = other.groupId;
    }

    public Map<String, Double> calculateSplits() {
        Map<String, Double> splitShares = new HashMap<>();
        splits.forEach((Split s) -> splitShares.put(s.getUserId(), s.calculateShare(amount)));

        return splitShares;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", paidBy='" + paidBy + '\'' +
                ", splits=" + splits +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
