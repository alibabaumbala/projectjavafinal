package com.example.demo.responsitory;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    @Query("select s from Employee s where s.idemp =?1 and s.passemp =?2")
    Employee getEmployeeByIDAndPass(String id,String pass);

    @Query("select s from Employee s where s.idemp =?1")
    Employee getEmployeeByID(String id);

    @Query("select s.idemp from Employee s where s.positionemp = ?1")
    List<String> countPosition(String position);

    @Modifying
    @Transactional
    @Query("delete from Employee s where s.idemp =?1")
    void deleteEmployeeByID(String id);

    @Modifying
    @Transactional
    @Query("update Employee s set s.tenemp =?1,s.emailemp =?2, s.sdtemp=?3, s.positionemp=?4,s.genderemp=?5 where s.idemp =?6")
    void updateEmployee(String name, String email, String sdt, String position,String gender ,String id);

}
