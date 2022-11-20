package com.example.demo.responsitory;

import com.example.demo.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher,String>
{
    @Query("select s.discount from Voucher s where s.idvoucher=?1")
    String getDiscountByIdv(String idvoucher);

}
