package org.example.app.controllers.employees;

import org.example.app.services.employees.EmployeeReadService;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.views.employees.EmployeeReadView;

public class EmployeeReadController {

    EmployeeReadService service;
    EmployeeReadView view;

    public EmployeeReadController(EmployeeReadService service, EmployeeReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readEmployee() {
        String str = service.readEmployees();
        if (str.equals(Constants.WRONG_MSG)) {
            view.getOutput(str);
            System.exit(0);
        } else {
            view.getOutput("\n_ Employees ___________\n" + str);
            AppStarter.startApp();
        }
    }
}