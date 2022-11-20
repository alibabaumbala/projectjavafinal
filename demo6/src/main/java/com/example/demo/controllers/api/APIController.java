package com.example.demo.controllers.api;

import com.example.demo.Request.BookingRequest;
import com.example.demo.model.Bookinghotel;
import com.example.demo.model.Feedback;
import com.example.demo.model.Users;
import com.example.demo.responsitory.BookingRepository;
import com.example.demo.responsitory.FeedBackRepository;
import com.example.demo.responsitory.UserRepository;
import com.example.demo.services.BookingService;
import com.example.demo.services.FeedBackService;
import com.example.demo.services.UserService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class APIController {
    private ConcurrentHashMap<String,Bookinghotel> books = new ConcurrentHashMap<>();
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    BookingService bookingService;

    @Autowired
    FeedBackRepository feedBackRepository;
    @Autowired
    FeedBackService feedBackService;


    @GetMapping("/data/api/security/userlist")
    public List<String> getListUserAPI()
    {
        return userService.getAPIEmail();
    }
    @RequestMapping(value = {"data/api/bookinglist"},method = {RequestMethod.GET},produces = "application/json")
    public List<Bookinghotel> bookinghotelList(Bookinghotel bookinghotel)
    {
        bookingService.addBooking(bookinghotel);
        return bookingRepository.findAll();
    }

    @GetMapping("data/api/bookinglist/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable String id)
    {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }
    @RequestMapping(value="/booking",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public int BookingHotel (@RequestBody Bookinghotel bookinghotel)
    {
        return bookingService.addBooking(bookinghotel);
    }
    public String randomIdBooking()
    {
        String SALTCHARS = "0123456789012304785412478213985479341230";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

//    @PostMapping(value = {"data/api/bookinglist"})
//    public Bookinghotel newBooking(@RequestBody BookingRequest bookinghotel)
//    {
//        String uuid = UUID.randomUUID().toString();
//        String uid = randomIdBooking();
//
//        String iduser = bookinghotel.iduser();
//        String idhotel = bookinghotel.idhotel();
//        String idroom = bookinghotel.idroom();
//        String location = bookinghotel.location();
//        String checkin = bookinghotel.checkin();
//        String checkout = bookinghotel.checkout();
//        int adult = bookinghotel.adult();
//        int child = bookinghotel.child();
//        String totalprice = bookinghotel.totalprice();
//        String representative = bookinghotel.representative();
//        String phonecontact = bookinghotel.phonecontact();
//        String emailcontact = bookinghotel.emailcontact();
//
//        Bookinghotel u  = new Bookinghotel();
//        u.setIdbooking(uid);
//        u.setIduser(iduser);
//        u.setIdhotel(idhotel);
//        u.setLocation(location);
//        u.setIdroom(idroom);
//        u.setCheckin(checkin);
//        u.setCheckout(checkout);
//        u.setAdult(adult);
//        u.setChild(child);
//        u.setTotalprice(totalprice);
//        u.setRepresentative(representative);
//        u.setPhonecontact(phonecontact);
//        u.setEmailcontact(emailcontact);
//
//        bookingService.addBooking(u);
//        books.put(uuid,u);
//
//        return u;
//    }

    @GetMapping(value = {"api/api/booking"})
    public ResponseEntity<Iterable<Bookinghotel>> findAllBooking()
    {
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = {"api/api/booking"})
    public ResponseEntity add(@RequestBody Bookinghotel bookinghotel)
    {
        bookingService.addBooking(bookinghotel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = {"api/api/feedback"})
    public ResponseEntity<Iterable<Feedback>> findAllFeedback()
    {
        return new ResponseEntity<>(feedBackRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = {"api/api/feedback"})
    public ResponseEntity addFeedback(@RequestBody Feedback feedback)
    {
        feedBackService.saveFeedback(feedback);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
