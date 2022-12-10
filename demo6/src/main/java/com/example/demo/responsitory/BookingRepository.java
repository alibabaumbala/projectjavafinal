package com.example.demo.responsitory;

import com.example.demo.API.RestAPI;
import com.example.demo.model.Bookinghotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface BookingRepository extends JpaRepository<Bookinghotel,String>
{
    @Query("select s from Bookinghotel s where s.statusbooking = ?1 and s.iduser = ?2 order by s.datebooking desc")
    public List<Bookinghotel> listHotelByStatus(String statusBooking, String iduser);

    @Query("select s from Bookinghotel s where s.idbooking = ?1")
    public Bookinghotel getBookinghotelByID(String idbooking);


    @Query("select s from Bookinghotel s where s.statusbooking =?1")
    List<Bookinghotel> getBookingHotelByStatus(String status);

    @Modifying
    @Transactional
    @Query("update Bookinghotel s set s.statusbooking=?2 where s.idbooking=?1")
    void setBooking(String idbooking,String status);

}
