package pcodes.jpaproject.ems.model;

import pcodes.jpaproject.ems.entity.Department;

public class EmployeeAddRequest {
    private String name;
    private  Long departmentId;
    private Double salary;


    public EmployeeAddRequest() {
    }

    public EmployeeAddRequest(String name, Long departmentId, Double salary) {
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
