package com.example.demo.responsitory;

import com.example.demo.model.Messagebycustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface MessageRepository extends JpaRepository<Messagebycustomer,Integer> {

    @Query("select s from Messagebycustomer s order by s.datesend desc ")
    List<Messagebycustomer> listMessageDESC();

    @Modifying
    @Transactional
    @Query("update Messagebycustomer s set s.rep='1' where s.stt=?1")
    void updateRepAfterAdminRep(int stt);

    @Query("select s from Messagebycustomer s where s.rep=?1 order by s.datesend desc ")
    List<Messagebycustomer> listMessByStatusRep(int rep);

    @Query("select s.stt from Messagebycustomer s where s.iduser=?1 and s.rep=1")
    List<Integer> getSTTMessageByIDUser(String iduser);

    @Query("select s from Messagebycustomer s where s.iduser=?1")
    List<Messagebycustomer> listMessageByIDUser(String iduser);

    @Query("select s.stt from Messagebycustomer s where s.iduser=?1")
    List<Integer> getAllSTTYourQuestion(String iduser);

    @Modifying
    @Transactional
    @Query("delete from Messagebycustomer s where s.stt=?1")
    void deleteQuestion(int stt);

}
