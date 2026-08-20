package pcodes.jpaproject.ems.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pcodes.jpaproject.ems.model.DepartmentRequest;
import pcodes.jpaproject.ems.model.DepartmentResponse;
import pcodes.jpaproject.ems.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping("/add")
    public Map<String, DepartmentResponse> addDepartment(@RequestBody DepartmentRequest data){
        return Map.of("data" ,service.addDepartment(data));
    }

    @GetMapping("/all")
    public List <DepartmentResponse> getAllDepartments(){return service.getAllDepartments();}

    @GetMapping("/id/{id}")
    public DepartmentResponse getDepartmentById(@PathVariable Long id){return service.getDepartmentById(id);}

    @PutMapping("/update/{id}")
    public DepartmentResponse updateDepartment(@RequestBody DepartmentRequest request,@PathVariable Long id){
        return service.updateDepartment(request,id);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,String> removeDepartment(@PathVariable Long id){
         service.removeDepartment(id);
         return Map.of("status","Department has been deleted");
    }

    @DeleteMapping("/delete/all")
    public Map<String,String> removeAllDepartment(){
        service.removeAllDepartments();
        return Map.of("status","Deleted all Departments");
    }
}

