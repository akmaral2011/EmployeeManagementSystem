package pcodes.jpaproject.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pcodes.jpaproject.ems.entity.Department;
import pcodes.jpaproject.ems.model.DepartmentRequest;
import pcodes.jpaproject.ems.model.DepartmentResponse;
import pcodes.jpaproject.ems.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    public DepartmentResponse addDepartment(DepartmentRequest request){
        Department department = new Department();
        department.setName(request.getName());
        department.setDescription(request.getDescription());

        Department storedDepartment = repository.save(department);
        return new DepartmentResponse(storedDepartment.getId(),storedDepartment.getName(),storedDepartment.getDescription());
    }

    public List<DepartmentResponse> getAllDepartments(){
        List<Department> dbDepartments = repository.findAll();
        List<DepartmentResponse> departments = new ArrayList<>();

        for(Department d : dbDepartments){
            DepartmentResponse dep = new DepartmentResponse();
            dep.setDescription(d.getDescription());
            dep.setName(d.getName());
            dep.setId(d.getId());

            departments.add(dep);

        }
        return departments;
    }

    public DepartmentResponse getDepartmentById(Long id){
        if(id==null) return null;

        Department dbDepartment = repository.findById(id).orElse(null);
        return dbDepartment != null?new DepartmentResponse(dbDepartment.getId(), dbDepartment.getName(), dbDepartment.getDescription()) : null;
    }

    public DepartmentResponse updateDepartment(DepartmentRequest request,Long id){
        if(request == null || id == null) return null;
        Department dbDepartment = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("Department not found"));
        if(request.getName()!=null)dbDepartment.setName(request.getName());
        if (request.getDescription()!=null)dbDepartment.setDescription(request.getDescription());


        Department updatedDepartment = repository.save(dbDepartment);

        return new DepartmentResponse(
                updatedDepartment.getId(),
                updatedDepartment.getName(),
                updatedDepartment.getDescription()
        );

    }

    public void removeDepartment(Long id){

        repository.deleteById(id);
    }

    public void removeAllDepartments(){

        repository.deleteAll();
    }
}
