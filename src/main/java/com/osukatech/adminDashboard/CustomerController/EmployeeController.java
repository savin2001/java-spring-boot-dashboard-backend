package com.osukatech.adminDashboard.CustomerController;

import com.osukatech.adminDashboard.DTO.EmployeeDTO;
import com.osukatech.adminDashboard.DTO.EmployeeSaveDTO;
import com.osukatech.adminDashboard.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //  New customers are registered using this url
    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeSaveDTO employeeSaveDTO) {
        String id = employeeService.addEmployee(employeeSaveDTO);
                return id;
    }

    //  List of the customers
    @GetMapping(path = "/get-all-customers")
    public List<EmployeeDTO> getAllCustomers() {
        List<EmployeeDTO> allCustomers = employeeService.getAllCustomers();
        return allCustomers;
    }
}
