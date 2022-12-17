package com.example.demo.responsitory;


import com.example.demo.model.Giftforuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

public interface GiftRepository extends JpaRepository<Giftforuser,Integer> {
    @Query("select s from Giftforuser s where s.foriduser=?1 and s.sudung=0 and s.hansudung >= CURRENT_TIMESTAMP")
    List<Giftforuser> getListGiftByIDNotUsed(String iduser);

    @Query(value = "SELECT s.idgift,s.giatri FROM Giftforuser s where s.sudung=0 and s.foriduser=?1 and s.hansudung >= CURRENT_DATE ", nativeQuery=true)
    List<Object[]> getVC_id_value(String iduser);

    @Modifying
    @Transactional
    @Query("update Giftforuser s set s.sudung=1 where s.idgift=?1")
    void updateDASD(String idgift);

    @Query("select s from Giftforuser s where s.sudung=0 and s.idgift=?1 and s.foriduser=?2 and s.hansudung >= CURRENT_DATE")
    Giftforuser findVoucherBy2ID(String idgift, String iduser);
}
