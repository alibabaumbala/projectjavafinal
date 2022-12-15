package com.example.demo.responsitory;

import com.example.demo.model.Repmessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepmessageRepository extends JpaRepository<Repmessage,Integer> {
    @Query("select s from Repmessage s where s.sttmessagesend=?1")
    Repmessage getMessReplied(int sttmessagesend);
}
