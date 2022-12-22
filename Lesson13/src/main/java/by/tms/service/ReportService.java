package by.tms.service;

import by.tms.model.Employee;
import lombok.NonNull;

import java.util.List;

public class ReportService implements ReportAware {

    public String getEditedFullName(@NonNull String fullName) {
        if (fullName.matches("([A-Z])([a-z]){2,30} ([A-Z])([a-z]){2,30}")) {
            return fullName.split(" ")[0].charAt(0) + ". " + fullName.split(" ")[1];
        } else {
            return "The full name was entered incorrectly";
        }
    }

    @Override
    public String generateReport(List<Employee> employees) {
        StringBuilder info = new StringBuilder();
        for (Employee employee : employees) {
            info.append(getEmployeeInfo(employee));
        }
        return info.toString();
    }

    public String getEmployeeInfo(@NonNull Employee employee) {
        return String.format("| %-25s | %12.2f | %n",
                getEditedFullName(employee.getFullName()), employee.getSalary());
    }
}

