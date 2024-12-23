package split_wise;

import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(double amount, User paidBy, List<Split> splits, String description) {
        super(amount, paidBy, splits, description);
    }

    @Override
    public boolean validate() {
        return getSplits().stream().allMatch(s -> s instanceof EqualSplit);
    }
}
