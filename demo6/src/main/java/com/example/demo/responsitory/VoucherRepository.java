package com.example.demo.responsitory;

import com.example.demo.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher,String>
{
    @Query("select s.discount from Voucher s where s.idvoucher=?1")
    String getDiscountByIdv(String idvoucher);

    @Modifying
    @Transactional
    @Query("delete from Voucher s where s.idvoucher=?1")
    void deleteVoucherByID(String idvoucher);

    @Modifying
    @Transactional
    @Query("update Voucher s set s.discount=?1,s.soluong=?2 where s.idvoucher=?3")
    void updateVoucher(String discount,int soluong, String idvoucher);

    @Query("select s from Voucher s where s.idvoucher=?1")
    Voucher getVoucherByID(String idvoucher);

    @Modifying
    @Transactional
    @Query("update Voucher s set s.sudung=s.sudung+1 where s.idvoucher=?1")
    void updateAmount(String idvoucher);
}
