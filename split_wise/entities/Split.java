package split_wise.entities;

public abstract class Split {
    private final String userId;

    public Split(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public abstract double calculateShare(double totalAmt);
}

class EqualSplit extends Split {
    private final int totalParticipants;

    public EqualSplit(String userId, int totalParticipants) {
        super(userId);
        this.totalParticipants = totalParticipants;
    }

    @Override
    public double calculateShare(double totalAmt) {
        return totalAmt / totalParticipants;
    }
}

class ExactSplit extends Split {
    private final double amount;

    public ExactSplit(String userId, double amount) {
        super(userId);
        this.amount = amount;
    }

    @Override
    public double calculateShare(double totalAmt) {
        return amount;
    }
}

class PercentSplit extends Split{
    private final double percent;

    public PercentSplit(String userId, double percent){
        super(userId);
        this.percent = percent;
    }

    @Override
    public double calculateShare(double totalAmt){
        return (percent/100) * totalAmt;
    }
}