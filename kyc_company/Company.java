package kyc_company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {
    private Map<String, Employee> employees;

    public Company() {
        this.employees = new HashMap<>();
    }

    public void registerEmployee(String employeeName, Gender gender) {
        if (!employees.containsKey(employeeName)) {
            employees.put(employeeName, new Employee(employeeName, gender));
        }
    }

    public Employee getEmployee(String employeeName) {
        return employees.get(employeeName);
    }

    public void deleteEmployee(String employeeName) {
        Employee employee = employees.get(employeeName);
        if (employee != null) {
            // Remove the employee from their manager's direct reports
            if (employee.getManager() != null) {
                employee.getManager().getDirectReports().remove(employee);
            }
            // Remove employee from the company
            employees.remove(employeeName);
        }
    }

    public void assignManager(String employeeName, String managerName) {
        Employee employee = employees.get(employeeName);
        Employee manager = employees.get(managerName);
        if (employee != null && manager != null) {
            employee.assignManager(manager);
        }
    }

    public List<Employee> getDirectReports(String managerName) {
        Employee manager = employees.get(managerName);
        if (manager != null) {
            return manager.getDirectReports();
        }
        return new ArrayList<>();
    }

    public List<Employee> getTeamMates(String employeeName) {
        Employee employee = employees.get(employeeName);
        if (employee != null) {
            return employee.getTeamMates();
        }
        return new ArrayList<>();
    }

    public List<List<Employee>> getEmployeeHierarchy(String managerName) {
        Employee manager = employees.get(managerName);
        List<List<Employee>> hierarchy = new ArrayList<>();
        if (manager != null) {
            buildHierarchy(manager, hierarchy, 0);
        }
        return hierarchy;
    }

    private void buildHierarchy(Employee manager, List<List<Employee>> hierarchy, int level) {
        if (hierarchy.size() <= level) {
            hierarchy.add(new ArrayList<>());
        }
        hierarchy.get(level).add(manager);
        for (Employee report : manager.getDirectReports()) {
            buildHierarchy(report, hierarchy, level + 1);
        }
    }
}
