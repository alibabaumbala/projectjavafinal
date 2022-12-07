package com.example.demo.controllers.api;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.Request.BookingRequest;
import com.example.demo.cloudinary.CloudinaryConfig;
import com.example.demo.model.Bookinghotel;
import com.example.demo.model.Employee;
import com.example.demo.model.Feedback;
import com.example.demo.model.Users;
import com.example.demo.responsitory.BookingRepository;
import com.example.demo.responsitory.EmployeeRepository;
import com.example.demo.responsitory.FeedBackRepository;
import com.example.demo.responsitory.UserRepository;
import com.example.demo.services.BookingService;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.FeedBackService;
import com.example.demo.services.UserService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CloudinaryConfig cloudinaryConfig;

    @Autowired
    Cloudinary cloudinary;

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

    @GetMapping(value = {"api/api/booking"})
    public ResponseEntity<Iterable<Bookinghotel>> findAllBooking()
    {
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = {"api/api/booking/add"})
    public ResponseEntity add(@RequestBody Bookinghotel bookinghotel,@RequestParam Map<String,String> requestParam)
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

    //LẤY DANH SÁCH FEEDBACK
    @GetMapping("api/listfeedback")
    public ResponseEntity listFeedbackAll(@RequestParam Map<String,String> requestParam)
    {
        String idhotel = requestParam.get("idhotel");
        int star = Integer.parseInt(requestParam.get("star"));

        if(star==0)
        {
            return new ResponseEntity(feedBackRepository.listFeedbackByIdHotel(idhotel),HttpStatus.OK);
        }
        else
            return new ResponseEntity(feedBackRepository.listFeedbackByStar(idhotel,star),HttpStatus.OK);
    }

    //XÓA NHÂN VIÊN
    @DeleteMapping("admin/quanly/employee/delete/{idemp}")
    public ResponseEntity Delete(@PathVariable String idemp)
    {
        employeeRepository.deleteEmployeeByID(idemp);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //SỬA THÔNG TIN NHÂN VIÊN
    @GetMapping( "admin/quanly/employee/edit/{idemp}")
    public Employee getInfoEmp(@PathVariable String idemp)
    {
        return employeeRepository.getEmployeeByID(idemp);
    }

    //UPDATE THÔNG TIN NHÂN VIÊN
    @RequestMapping(value="admin/quanly/employee/edit/success",method = RequestMethod.POST)
    public Employee editInfoEmp(@RequestParam Map<String,String> requestParam)
    {
        String idemp = requestParam.get("idemp");
        String tenemp = requestParam.get("tenemp");
        String email = requestParam.get("emailemp");
        String position = requestParam.get("positionemp");
        String sdtemp = requestParam.get("sdtemp");
        String genderemp = requestParam.get("genderemp");

        employeeRepository.updateEmployee(tenemp,email,sdtemp,position,genderemp,idemp);
        return employeeRepository.getEmployeeByID(idemp);
    }

}
