package com.osukatech.adminDashboard.Service;

import com.osukatech.adminDashboard.DTO.EmployeeDTO;
import com.osukatech.adminDashboard.DTO.EmployeeSaveDTO;

import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeSaveDTO employeeSaveDTO);

    List<EmployeeDTO> getAllEmployees();

}
