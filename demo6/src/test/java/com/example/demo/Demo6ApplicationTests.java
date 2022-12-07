package com.example.demo;

import com.example.demo.API.API;
import com.example.demo.API.RestAPI;
import com.example.demo.model.Bookinghotel;

import com.example.demo.model.Users;
import com.example.demo.responsitory.BookingRepository;
import com.example.demo.responsitory.UserRepository;
import com.example.demo.services.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootTest
class Demo6ApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService ;

    @Autowired
    VoucherService voucherService;

    @Autowired
    BookingService bookingService;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    FeedBackService feedBackService;

    @Autowired API api;



    @Test
    void contextLoads() throws JSONException
    {
        RestAPI restAPI = new RestAPI();
//        System.out.println(restAPI.findIndexKey(0,"phuquoc","id","pq-hotel-2"));
//        String info = restAPI.restAPIString(0,"phuquoc","pq-hotel-1","list_room");
//        System.out.println(info);
//        System.out.println(restAPI.findInfoRoom(0,"phuquoc","pq-hotel-1","pq-hotel-1-room-1","nameroom"));

//        String roomList = restAPI.restAPIString(0,"phuquoc","pq-hotel-1","list_room");
//        JSONArray array = new JSONArray(roomList);
//
//        int findIndexByIdRoom = -1;
//        String result="";
//
//        for(int i=0; i < array.length(); i++)
//        {
//
//            JSONObject object = array.getJSONObject(i);
//            if(object.getString("idroom").equals("pq-hotel-1-room-1")==true)
//            {
//                findIndexByIdRoom=i;
//            }
//        }
//        System.out.println(array.getJSONObject(findIndexByIdRoom).getString("nameroom"));
//        System.out.println(restAPI.findInfoRoom(0,"phuquoc","pq-hotel-1","pq-hotel-1-room-1","adult"));
//        System.out.println(voucherService.valueDiscount("vc1"));
//        bookingService.addBooking()
        Bookinghotel u = new Bookinghotel();
        u.setIdbooking("3512478");
        u.setIduser("AC7wvkbb");
        u.setIdhotel("pq-hotel-1");
        u.setIdroom("pq-hotel-1-room-2");
        u.setCheckin("11-26-2022");
        u.setCheckout("11-28-2022");
        u.setAdult(2);
        u.setChild(0);
        u.setTotalprice("4000000");
        u.setRepresentative("Anh Thư");
        u.setPhonecontact("0927874444");
        u.setEmailcontact("athu@gmail.com");
        u.setStatusbooking("Chờ xác nhận");
        u.setLocation("phuquoc");
//        bookingService.addBooking(u);
//        System.out.println(bookingService.listHotelByStatus("'Chờ xác nhận'").size());
//        System.out.println(userService.getUserByID(feedBackService.listFeedBackByIDHotel("pq-hotel-1").get(0).getIduser()).getTen());
//        bookingService.updateStatusReview(bookingRepository.getBookinghotelByID("03883343"));
//        System.out.println(feedBackService.iduser_name("pq-hotel-1").get("AC7wvkbb"));
//        System.out.println(restAPI.restAPIString(0,"phuquoc","qp-hotel-1","img_hotel"));
//        API api = new API();
//        System.out.println(api.webclient());
//        System.out.println(userRepository.findAll().size());
//        userRepository.updateKHNotPass("Huy","Huy","Male","123456789","LyrbUXfi");
//        System.out.println(userRepository.findAllByEmail("vanhuy161u9@gmail.com"));

        Users i = new Users();
        i.setHo("Nguyễn");
        i.setTen("Nguyễn");
        i.setPhone("0145217869");
        i.setEmail("nguyennguyen@gmail.com");
        i.setGender("Male");
        i.setPassword("123456");
        userService.addUser(i);

    }


}
