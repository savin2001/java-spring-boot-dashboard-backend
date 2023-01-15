package com.osukatech.adminDashboard.EmployeeController;

import com.osukatech.adminDashboard.DTO.EmployeeDTO;
import com.osukatech.adminDashboard.DTO.EmployeeSaveDTO;
import com.osukatech.adminDashboard.DTO.EmployeeUpdateDTO;
import com.osukatech.adminDashboard.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //  New employees are registered using this url
    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeSaveDTO employeeSaveDTO) {
        String id = employeeService.addEmployee(employeeSaveDTO);
                return id;
    }

    //  List of the employees
    @GetMapping(path = "/get-all-customers")
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }
    //  Details of existing employees are updated using this url
    @PostMapping(path = "/update")
    public String updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        String id = employeeService.updateEmployee(employeeUpdateDTO);
        return id;
    }

    //  Existing employees can be deleted using this url
    @DeleteMapping(path = "/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int id) {
        boolean deleteEmployee = employeeService.deleteEmployee(id);
        if (deleteEmployee == true) {
            return "Customer deleted!";
        } else {
            return "Customer ID not found!";
        }

    }
}
