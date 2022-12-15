package com.example.demo.responsitory;

import com.example.demo.model.Buyservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BuyServiceRepository extends JpaRepository<Buyservice,Integer> {

    @Query("select s from Buyservice s where s.iduser=?1 and s.idbooking=?2")
    List<Buyservice> getListBuyServiceByIdUserAndIdBooking(String iduser, String idbooking);

    @Modifying
    @Transactional
    @Query("update Buyservice s set s.soluong=?1, s.thanhtien=?2 where s.iduser=?3 and s.idbooking=?4")
    void updateSoLuongBuyService(int soluong, String thanhtien, String iduser, String idbooking);

    @Query("select s from Buyservice s where s.iduser=?1 and s.idbooking =?2 and s.sttService=?3")
    Buyservice checkBought(String iduser, String idbooking, String sttservice);

    @Modifying
    @Transactional
    @Query("delete from Buyservice s where s.stt=?1")
    void deleteServiceBought(int stt);
}
