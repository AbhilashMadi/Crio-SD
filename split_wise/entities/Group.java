package split_wise.entities;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String id;
    private String name;
    private String createdBy;
    private List<String> memberIds;
    private List<Expense> expenses;

    public Group(String name, String description, String createdBy) {
        this.id = null;
        this.name = name;
        this.createdBy = createdBy;
        this.memberIds = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public Group(String id, Group other) {
        this.id = id;
        this.name = other.name;
        this.createdBy = other.createdBy;
        this.memberIds = other.memberIds;
        this.expenses = other.expenses;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void addMember(String id){
        memberIds.add(id);
    }

    public void addExpense(Expense expense){
        expenses.add(expense);
    }
}
