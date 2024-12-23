package split_wise;

import java.util.List;

public class UnEqualExpense extends Expense {
    public UnEqualExpense(double amount, User paidBy, List<Split> splits, String description) {
        super(amount, paidBy, splits, description);
    }

    @Override
    public boolean validate(){
        return getSplits().stream().allMatch(s -> s instanceof UnEqualSplit);
    }
}
