package pcodes.jpaproject.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pcodes.jpaproject.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
