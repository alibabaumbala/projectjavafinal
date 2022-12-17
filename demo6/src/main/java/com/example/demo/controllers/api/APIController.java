package com.example.demo.controllers.api;

import com.cloudinary.Cloudinary;
import com.example.demo.API.API;
import com.example.demo.API.RestAPI;
import com.example.demo.cloudinary.CloudinaryConfig;
import com.example.demo.model.*;
import com.example.demo.responsitory.*;

import com.example.demo.services.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    RestAPI restAPI;

    @Autowired
    RepmessageRepository repmessageRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private BuyServiceRepository buyServiceRepository;

    @Autowired TotalBillRepository totalBillRepository;
    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    VoucherService voucherService;



    @Autowired
    API api;
    @Autowired
    private GiftRepository giftRepository;

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

    //ĐẶT PHÒNG
    @PostMapping(value = {"api/api/booking/add"})
    public ResponseEntity add(@RequestBody Bookinghotel bookinghotel,@RequestParam Map<String,String> requestParam)
    {
        bookingService.addBooking(bookinghotel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //CẬP NHẬT SỐ LƯỢNG VOUCHER SAU KHI DÙNG
    @RequestMapping(value="api/api/voucher/amount/update",method = RequestMethod.POST)
    public String updateAmountVoucherAfterUsed(@RequestParam Map<String,String> requestParam)
    {
        String idvoucher = requestParam.get("idvoucher");

        voucherRepository.updateAmountSD(idvoucher);
        return "Đã cập nhật";
    }

    @GetMapping(value = {"api/api/feedback"})
    public ResponseEntity<Iterable<Feedback>> findAllFeedback()
    {
        return new ResponseEntity<>(feedBackRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = {"api/api/feedback/send"})
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

    //LÂY DANH BOOKING THEO STATUS
    @GetMapping(value = {"api/api/bookinglistbystatus"})
    public ResponseEntity getBookingByStatus(@RequestParam Map<String,String> requestParam) throws JSONException {
        List<Bookinghotel> bookinghotelList = bookingRepository.getBookingHotelByStatus(requestParam.get("statusbooking"));
        for(int i = 0;i<bookinghotelList.size();i++)
        {
            String namehotel = restAPI.restAPIString(0,bookinghotelList.get(i).getLocation(),bookinghotelList.get(i).getIdhotel(),"name_hotel");
            String imghotel = restAPI.restAPIString(0,bookinghotelList.get(i).getLocation(),bookinghotelList.get(i).getIdhotel(),"img_hotel");
            String nameroom = restAPI.findInfoRoom(0,bookinghotelList.get(i).getLocation(),bookinghotelList.get(i).getIdhotel(),bookinghotelList.get(i).getIdroom(),"nameroom");
            bookinghotelList.get(i).setIdhotel(bookinghotelList.get(i).getIdhotel()+" * "+namehotel+" * "+imghotel);
            bookinghotelList.get(i).setIdroom(bookinghotelList.get(i).getIdroom()+" * "+nameroom);
        }

        return new ResponseEntity(bookinghotelList,HttpStatus.OK);
    }

    //XÁC NHẬN BOOKING, HỦY, TRẢ PHÒNG, NHẬN PHÒNG
    @RequestMapping(value="api/api/bookinglistbystatus/update",method = RequestMethod.POST)
    public Bookinghotel updateBooking(@RequestParam Map<String,String> requestParam)
    {
        String idbooking = requestParam.get("idbooking");;
        String statusbooking = requestParam.get("statusbooking");

        bookingRepository.setBooking(idbooking,statusbooking);

        int point = Integer.parseInt(bookingRepository.getBookinghotelByID(idbooking).getTotalprice())/1000000;
        if(statusbooking.equals("Đã trả phòng")==true)
        {
            userRepository.updatePointAfterCheckout(point,bookingRepository.getBookinghotelByID(idbooking).getIduser());
            String iduser = requestParam.get("iduser");
            String totalpricebill = requestParam.get("totalpricebill");
            String status = requestParam.get("status");

            Totalbill totalbill = new Totalbill();
            totalbill.setIduser(iduser);
            totalbill.setIdbooking(idbooking);
            totalbill.setTotalpricebill(totalpricebill);
            totalbill.setStatus(status);
            totalBillRepository.save(totalbill);
        }

        return bookingRepository.getBookinghotelByID(idbooking);
    }

    //LẤY THÔNG TIN KHÁCH HÀNG BOOKING
    @RequestMapping(value="api/api/bookinglistbystatus/getinfo",method = RequestMethod.GET)
    public Bookinghotel getInfoCustomerBooking(@RequestParam Map<String,String> requestParam)
    {
        Bookinghotel bk = bookingRepository.getBookinghotelByID(requestParam.get("idbooking"));
        List<Bookinghotel> listBookingSuccess = bookingRepository.listHotelByStatus("Thành công",bk.getIduser());
        //id * hoten * email * sdt * ava * soluongthanhcong
        bk.setIduser(bk.getIduser()+" * "+userRepository.findUsersByID(bk.getIduser()).getHo()+' '+userRepository.findUsersByID(bk.getIduser()).getTen()+
                " * "+userRepository.findUsersByID(bk.getIduser()).getEmail()+
                " * "+userRepository.findUsersByID(bk.getIduser()).getPhone()+
                " * "+userRepository.findUsersByID(bk.getIduser()).getAvatar()+
                " * "+listBookingSuccess.size());

        return bk;
    }

    //LẤY THÔNG TIN KHÁCH HÀNG
    @GetMapping( "api/api/edit/user")
    public Users getInfoKH(@RequestParam Map<String,String> requestParam)
    {
        return userRepository.findUsersByID(requestParam.get("iduser"));
    }

    //CẬP NHẬT KHÁCH HÀNG
    @RequestMapping(value="api/api/edit/user/success",method = RequestMethod.POST)
    public Users editInfoKH(@RequestParam Map<String,String> requestParam)
    {
        String ho = requestParam.get("ho");
        String ten = requestParam.get("ten");
        String phone = requestParam.get("phone");
        String email = requestParam.get("email");
        String gender = requestParam.get("gender");
        String level = requestParam.get("level");
        String iduser = requestParam.get("iduser");
        userRepository.updateUserByAdmin(ho,ten,phone,email,gender,level,iduser);
        return userRepository.findUsersByID(iduser);
    }

    //XÓA KHÁCH HÀNG
    @RequestMapping(value = "api/api/user/delete",method = RequestMethod.POST)
    public String DeleteKH(@RequestParam Map<String,String> requestParam)
    {
        userRepository.updateStatusAfterDelete("Vô hiệu",requestParam.get("iduser"));
        return "ok";
    }

    //TRẢ LỜI CÂU HỎI
    @RequestMapping(value = "api/api/question/reply",method = RequestMethod.POST)
    public ResponseEntity RepMessage(@RequestBody Repmessage rep)
    {
        rep.setUserread(0);
        rep.setDaterep(new Timestamp(System.currentTimeMillis()));
        repmessageRepository.save(rep);
        messageRepository.updateRepAfterAdminRep(rep.getSttmessagesend());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //XÓA CÂU HỎI
    @RequestMapping(value = "api/api/question/delete",method = RequestMethod.POST)
    public String DeleteQuestion(@RequestParam Map<String,String> requestParam)
    {
        messageRepository.deleteQuestion(Integer.parseInt(requestParam.get("stt")));
        return "ok";
    }

    //GỬI CÂU HỎI
    @RequestMapping(value = "api/api/question/send",method = RequestMethod.POST)
    public ResponseEntity SendMessage(@RequestBody Messagebycustomer ms)
    {
        ms.setRep(0);
        ms.setDatesend(new Timestamp(System.currentTimeMillis()));
        messageRepository.save(ms);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //XÓA DỊCH VỤ
    @RequestMapping(value = "api/api/service/delete",method = RequestMethod.POST)
    public String DeleteDichVu(@RequestParam Map<String,String> requestParam)
    {
        serviceRepository.deletDVBySTT(Integer.parseInt(requestParam.get("stt")));
        return "ok";
    }

    //BUY SERVICE
    @RequestMapping(value = "api/api/buyservice",method = RequestMethod.POST)
    public ResponseEntity Buy_Product_Service(@RequestBody Buyservice buyservice)
    {
        buyServiceRepository.save(buyservice);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //XÓA DỊCH VỤ ĐÃ MUA
    @RequestMapping(value = "api/api/buyservice/delete",method = RequestMethod.POST)
    public String DeleteDichVuBought(@RequestParam Map<String,String> requestParam)
    {
        buyServiceRepository.deleteServiceBought(Integer.parseInt(requestParam.get("stt")));
        return "ok";
    }

    //XÓA VOUCHER
    @RequestMapping(value = "api/api/voucher/delete",method = RequestMethod.POST)
    public String DeleteVoucher(@RequestParam Map<String,String> requestParam)
    {
        voucherRepository.deleteVoucherByID(requestParam.get("idvoucher"));
        return "ok";
    }

    //CẬP NHẬT VOUCHER
    @RequestMapping(value="api/api/edit/voucher/success",method = RequestMethod.POST)
    public Voucher editVoucher(@RequestParam Map<String,String> requestParam)
    {
        String idvoucher = requestParam.get("idvoucher");
        String discount = requestParam.get("discount");
        int soluong = Integer.parseInt(requestParam.get("soluong"));
        voucherRepository.updateVoucher(discount,soluong,idvoucher);
        return voucherRepository.getVoucherByID(idvoucher);
    }

    //THÊM VOUCHER
    @RequestMapping(value="api/api/voucher/add",method = RequestMethod.POST)
    public ResponseEntity addVoucher(@RequestBody Voucher voucher)
    {
//        voucherRepository.save(voucher);
        voucherService.addNewVoucher(voucher);
        return new ResponseEntity(HttpStatus.OK);
    }

    //TRẢ KẾT QUẢ HOTEL ĐỂ EDIT
    @RequestMapping(value = "api/hotel/edit/{location}/{index}",method = RequestMethod.GET)
    public ResponseEntity getHotelItem(@PathVariable String location,@PathVariable int index) throws JSONException, IOException {

        return new ResponseEntity(api.webclient2(location).get(index),HttpStatus.OK);
    }


    //TÌM THÔNG TIN KHÁCH HÀNG QUA MÃ KH HOẶC SDT
    @RequestMapping(value = "api/api/user/search",method = RequestMethod.GET)
    public ResponseEntity findUserByPhone(@RequestParam Map<String,String> request)
    {
            return new ResponseEntity(userRepository.findAllByEmail(request.get("email")),HttpStatus.OK);
    }

    //TRẢ VỀ GIFT CỦA KHÁCH HÀNG QUA IDUSER VÀ IDVOUCHER
    @RequestMapping(value = "api/api/user/gift/search",method = RequestMethod.GET)
    public ResponseEntity findGiftIdUser(@RequestParam Map<String,String> request)
    {
        return new ResponseEntity(giftRepository.getVC_id_value(request.get("foriduser")),HttpStatus.OK);
    }

    //TRẢ VỀ GIFT CỦA KHÁCH HÀNG QUA IDUSER VÀ IDVOUCHER
    @RequestMapping(value = "api/api/user/gift/searchbyid",method = RequestMethod.GET)
    public ResponseEntity findListGiftIdUser(@RequestParam Map<String,String> request)
    {
        return new ResponseEntity(giftRepository.getListGiftByIDNotUsed(request.get("foriduser")),HttpStatus.OK);
    }

    //THÊM VOUCHER CHO KHÁCH HÀNG
    @RequestMapping(value = "api/api/user/gift/add",method = RequestMethod.POST)
    public ResponseEntity Add_Gift_For_User(@RequestBody Giftforuser gift)
    {
        giftRepository.save(gift);
        String idgift = gift.getIdgift();
        String iduser = gift.getForiduser();
        return new ResponseEntity<>(giftRepository.findVoucherBy2ID(idgift,iduser),HttpStatus.OK);
    }

    //VOUCHER CỦA KHÁCH HÀNG ĐÃ DÙNG
    @RequestMapping(value = "api/api/user/gift/dasudung",method = RequestMethod.POST)
    public ResponseEntity Add_Gift_For_User(@RequestParam Map<String,String> request)
    {
        String idgift = request.get("idgift");
        giftRepository.updateDASD(idgift);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
