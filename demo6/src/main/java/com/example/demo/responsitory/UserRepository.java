package com.example.demo.responsitory;

import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Users,Integer>
{
    @Query("select s from Users s where s.email =?1")
    public Users findAllByEmail(String email);

    @Query("select s from Users s where s.iduser =?1")
    public Users findUsersByID(String id);

}
