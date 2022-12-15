package com.example.demo.responsitory;

import com.example.demo.model.Totalbill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TotalBillRepository extends JpaRepository<Totalbill,Integer> {
    @Query("select s from Totalbill s where s.idbooking =?1")
    Totalbill checkFinishByIdBooking(String idbooking);
}
