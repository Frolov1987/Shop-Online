package org.example.app.controllers.employees;

import org.example.app.entities.Employee;
import org.example.app.services.employees.EmployeeCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.employees.EmployeeCreateView;
import org.example.app.utils.Constants;

public class EmployeeCreateController {
    EmployeeCreateView view;
    Employee employee;
    EmployeeCreateService service;

    public EmployeeCreateController(EmployeeCreateService service, EmployeeCreateView view) {
        this.service = service;
        this.view = view;
    }

    public void createEmployee() {

        employee = view.getData();
        String str = service.createEmployee(employee);

        if (str.equals(Constants.WRONG_MSG)) {
            view.getOutput(str);
            System.exit(0);
        } else {
            view.getOutput(str);
            AppStarter.startApp();
        }
    }
}

