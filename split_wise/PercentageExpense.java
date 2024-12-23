package split_wise;

import java.util.List;

public class PercentageExpense extends Expense {
    public PercentageExpense(double amount, User paidBy, List<Split> splits, String description) {
        super(amount, paidBy, splits, description);
    }

    @Override
    public boolean validate() {
        double percentage = 0;

        for (Split s : getSplits()) {
            if (!(s instanceof PercentageSplit)) return false;
            percentage += ((PercentageSplit) s).getPercentage();
        }

        return Math.abs(percentage - 100) < 0.01;
    }
}
