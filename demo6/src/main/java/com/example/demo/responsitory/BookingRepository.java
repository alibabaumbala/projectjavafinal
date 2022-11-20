package com.example.demo.responsitory;

import com.example.demo.model.Bookinghotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookingRepository extends JpaRepository<Bookinghotel,String>
{
    @Query("select s from Bookinghotel s where s.statusbooking = ?1 and s.iduser = ?2 order by s.datebooking desc")
    public List<Bookinghotel> listHotelByStatus(String statusBooking, String iduser);

    @Query("select s from Bookinghotel s where s.idbooking = ?1")
    public Bookinghotel getBookinghotelByID(String idbooking);



}
