package split_wise;

import java.util.List;
import java.util.UUID;

abstract public class Expense {
    private final String id;
    private final double amount;
    private final User paidBy;
    private final List<Split> splits;
    private final String description;

    public Expense(double amount, User paidBy, List<Split> splits, String description) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public String getDescription() {
        return description;
    }

    public abstract boolean validate();
}
