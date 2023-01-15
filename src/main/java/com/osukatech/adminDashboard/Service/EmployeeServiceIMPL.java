package com.osukatech.adminDashboard.Service;

import com.osukatech.adminDashboard.CustomerRepo.CustomerRepo;
import com.osukatech.adminDashboard.DTO.EmployeeDTO;
import com.osukatech.adminDashboard.DTO.EmployeeSaveDTO;
import com.osukatech.adminDashboard.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
    @Autowired
    private CustomerRepo customerRepo;

    // This method adds new customers
    @Override
    public String addEmployee(EmployeeSaveDTO employeeSaveDTO) {
        Employee employee = new Employee(
                employeeSaveDTO.getEmployee_name(),
                employeeSaveDTO.getEmployee_email(),
                employeeSaveDTO.getEmployee_mobile()
        );
        customerRepo.save(employee);
        return employee.getEmployee_name();
    }

    // This method fetches all customer records from the database
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> getEmployees = customerRepo.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for(Employee a: getEmployees)
        {
            EmployeeDTO employeeDTO = new EmployeeDTO(

                    a.getEmployee_id(),
                    a.getEmployee_name(),
                    a.getEmployee_email(),
                    a.getEmployee_mobile()
            );
            employeeDTOList.add(employeeDTO);
        }

        return employeeDTOList;
    }
}
