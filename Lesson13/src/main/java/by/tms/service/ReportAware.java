package by.tms.service;

import by.tms.model.Employee;

import java.util.List;

public interface ReportAware {

    String generateReport(List<Employee> employees);
}
