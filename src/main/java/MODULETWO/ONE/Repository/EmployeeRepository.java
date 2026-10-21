package MODULETWO.ONE.Repository;

import MODULETWO.ONE.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity deleteById(EmployeeEntity getid);
}
