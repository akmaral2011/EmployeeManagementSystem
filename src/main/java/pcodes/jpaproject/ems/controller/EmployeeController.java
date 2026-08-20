package pcodes.jpaproject.ems.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pcodes.jpaproject.ems.entity.Department;
import pcodes.jpaproject.ems.entity.Employee;
import pcodes.jpaproject.ems.model.EmployeeAddRequest;
import pcodes.jpaproject.ems.model.EmployeeAddResponse;
import pcodes.jpaproject.ems.service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/check")
    public String check(){
        return "Server is running...";
    }

    @PostMapping("/add")
    public Map<String,EmployeeAddResponse> addEmployee(@RequestBody EmployeeAddRequest data){
        return Map.of("data",service.addEmployee(data));
    }

    @GetMapping("/all")
    public List<EmployeeAddResponse> getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/id/{id}")
    public  EmployeeAddResponse getEmployeeById(@PathVariable Long id){
        return service.getEmployee(id);
    }

    @GetMapping("/dept/{departmentId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable  Long departmentId){
        return service.getAllEmployeesOfDepartment(departmentId);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody EmployeeAddRequest request,@PathVariable Long id){
        return service.updateEmployee(request,id);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,String> deleteEmployee(@PathVariable Long id){
        service.removeEmployee(id);

        return Map.of("status","Employee has been deleted");
    }

    @DeleteMapping("/delete/all")
    public Map<String,String> deleteAllEmployees(){
        service.removeAllEmployees();

        return Map.of("status","Deleted all Employees");
    }
}
