package kyc_company;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private Gender gender;
    private Employee manager;
    private List<Employee> directReports;

    public Employee(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.directReports = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void assignManager(Employee manager) {
        this.manager = manager;
        if (manager != null) {
            manager.addDirectReport(this);
        }
    }

    public Employee getManager() {
        return manager;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    private void addDirectReport(Employee employee) {
        this.directReports.add(employee);
    }

    public List<Employee> getTeamMates() {
        List<Employee> teamMates = new ArrayList<>();
        if (manager != null) {
            // Get all direct reports of the manager
            teamMates.add(manager);
            teamMates.addAll(manager.getDirectReports());
            // Remove the current employee from the list
//            teamMates.remove(this);
        }
        return teamMates;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", gender=" + gender + "]";
    }
}
