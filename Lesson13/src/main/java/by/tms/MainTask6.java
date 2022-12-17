package by.tms;

import by.tms.model.Employee;
import by.tms.service.ReportService;

import java.util.ArrayList;

public class MainTask6 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Petr Petrov", 1200.50));
        employees.add(new Employee("Ivan Ivanov", 1300.20));
        employees.add(new Employee("Yuri Sidorov", 1250.55));
        employees.add(new Employee("Elena Golopupenko", 1155.30));
        ReportService employeeService = new ReportService();
        System.out.println(employeeService.generateReport(employees));
    }
}
