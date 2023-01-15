package com.osukatech.adminDashboard.Service;

import com.osukatech.adminDashboard.DTO.EmployeeDTO;
import com.osukatech.adminDashboard.DTO.EmployeeSaveDTO;
import com.osukatech.adminDashboard.DTO.EmployeeUpdateDTO;

import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeSaveDTO employeeSaveDTO);

    List<EmployeeDTO> getAllEmployees();

    String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO);

    boolean deleteEmployee(int id);
}
