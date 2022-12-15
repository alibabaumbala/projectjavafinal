package com.example.demo.responsitory;

import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<Users,Integer>
{
    @Query("select s from Users s where s.email =?1")
    public Users findAllByEmail(String email);

    @Query("select s from Users s where s.iduser =?1")
    public Users findUsersByID(String id);

    @Query("select s from Users s where s.phone =?1")
    Users findUserByPhone (String phone);

    @Modifying
    @Transactional
    @Query("update Users s set s.ho=?1,s.ten=?2,s.gender=?3,s.phone=?4 where s.iduser=?5")
    void updateKHNotPass(String ho,String ten, String gender, String phone, String id);

    @Modifying
    @Transactional
    @Query("update Users s set s.ho =?1, s.ten =?2,s.gender =?3,s.phone=?4,s.password=?5 where s.iduser = ?6")
    void updateKHWithPass(String ho, String ten, String gender,String phone,String pass,String id);

    @Modifying
    @Transactional
    @Query("update Users s set s.point=s.point+?1 where s.iduser=?2")
    void updatePointAfterCheckout(int point,String iduser);

    @Modifying
    @Transactional
    @Query("update Users s set s.ho=?1, s.ten=?2, s.phone=?3, s.email=?4, s.gender=?5, s.level=?6 where s.iduser=?7")
    void updateUserByAdmin(String ho, String ten, String phone, String email, String gender, String level, String iduser);

    @Modifying
    @Transactional
    @Query("update Users s set s.status=?1 where s.iduser=?2")
    void updateStatusAfterDelete(String status, String iduser);

    @Query("select s from Users s where s.status=?1 order by s.creactAccount ASC ")
    List<Users> getListUserByStatus(String status);
}
