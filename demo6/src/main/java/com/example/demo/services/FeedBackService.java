package com.example.demo.services;

import com.example.demo.model.Feedback;
import com.example.demo.responsitory.BookingRepository;
import com.example.demo.responsitory.FeedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class FeedBackService {
    @Autowired
    FeedBackRepository feedBackRepository;

    @Autowired BookingService bookingService;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired UserService userService;

    public List<Feedback> listFeedBackByIDHotel(String idHotel)
    {
        return feedBackRepository.listFeedbackByIdHotel(idHotel);
    }

    public boolean saveFeedback(Feedback feedback)
    {
        feedBackRepository.save(feedback);
        bookingService.updateStatusReview(bookingRepository.getBookinghotelByID(feedback.getIdbooking()));
        return true;
    }

    public List<Feedback> feedbackListByStar(String idhotel, int star)
    {
        if(star==0)
            return feedBackRepository.listFeedbackByIdHotel(idhotel);
        else if(star ==21)
            return feedBackRepository.listFeedbackByStar21();
        else
            return feedBackRepository.listFeedbackByStar(idhotel,star);
    }

    public HashMap<String,String> iduser_name(String idhotel)
    {
        HashMap<String,String> hashMap = new HashMap<>();
        for(int i = 0; i<listFeedBackByIDHotel(idhotel).size();i++)
        {
            hashMap.put(listFeedBackByIDHotel(idhotel).get(i).getIduser(),
                    userService.getUserByID(listFeedBackByIDHotel(idhotel).get(i).getIduser()).getTen());
        }
        return hashMap;
    }
    public HashMap<String,String> iduser_img(String idhotel)
    {
        HashMap<String,String> hashMap = new HashMap<>();
        for(int i = 0; i<listFeedBackByIDHotel(idhotel).size();i++)
        {
            hashMap.put(listFeedBackByIDHotel(idhotel).get(i).getIduser(),
                    userService.getUserByID(listFeedBackByIDHotel(idhotel).get(i).getIduser()).getAvatar());
        }
        return hashMap;
    }
}
