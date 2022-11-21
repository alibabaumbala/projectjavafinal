package com.example.demo.responsitory;

import com.example.demo.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedBackRepository extends JpaRepository<Feedback,String>
{
    @Query("select f from Feedback f where f.idhotel = ?1 order by f.datefeedback desc ")
    public List<Feedback> listFeedbackByIdHotel(String id);

    @Query("select f from Feedback f where f.idhotel=?1 and f.star = ?2")
    public List<Feedback> listFeedbackByStar(String idhotel, int star);

    @Query("select f from Feedback f where f.star <= 2")
    public List<Feedback> listFeedbackByStar21();

}
