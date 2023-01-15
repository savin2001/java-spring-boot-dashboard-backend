package com.osukatech.adminDashboard.Service;

import com.osukatech.adminDashboard.DTO.EmployeeUpdateDTO;
import com.osukatech.adminDashboard.EmployeeRepo.EmployeeRepo;
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
    private EmployeeRepo employeeRepo;

    // This method adds new customers
    @Override
    public String addEmployee(EmployeeSaveDTO employeeSaveDTO) {
        Employee employee = new Employee(
                employeeSaveDTO.getEmployee_name(),
                employeeSaveDTO.getEmployee_email(),
                employeeSaveDTO.getEmployee_mobile()
        );
        employeeRepo.save(employee);
        return employee.getEmployee_name() + " added!";
    }

    // This method fetches all customer records from the database
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> getEmployees = employeeRepo.findAll();
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

    // This method updates customer records in the database
    @Override
    public String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
        if (employeeRepo.existsById(employeeUpdateDTO.getEmployee_id())) {
            Employee employee = employeeRepo.getById(employeeUpdateDTO.getEmployee_id());

            //  Update the existing customer details with the values from the update function
           employee.setEmployee_name(employeeUpdateDTO.getEmployee_name());
           employee.setEmployee_email(employeeUpdateDTO.getEmployee_email());
           employee.setEmployee_mobile(employeeUpdateDTO.getEmployee_mobile());

            //  Write the customer updated details to the database
            employeeRepo.save(employee);
            return "Records updated!";

        } else {
            return "Customer ID does not exist!";
        }

    }

    // This method deletes a customer's record from the database
    @Override
    public boolean deleteEmployee(int id) {
        if (employeeRepo.existsById(id)){
            employeeRepo.deleteById(id);
            return true;
        } else {
            System.out.println("Customer ID not found!");
            return false;
        }

    }

}
