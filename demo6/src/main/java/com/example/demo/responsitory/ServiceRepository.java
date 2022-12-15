package com.example.demo.responsitory;

import com.example.demo.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Integer> {

    @Query(nativeQuery = true,value="select  * from Service s order by s.amount DESC Limit 0, 5")
    List<Service> top5Sevice();

    @Modifying
    @Transactional
    @Query("update Service s set s.status='Deleted' where s.stt=?1")
    void deletDVBySTT(int stt);

    @Query("select s from Service s where s.status='Active'")
    List<Service> getServiceActive();
}
