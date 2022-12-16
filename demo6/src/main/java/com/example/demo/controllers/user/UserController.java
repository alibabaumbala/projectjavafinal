package com.example.demo.controllers.user;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.API.RestAPI;
import com.example.demo.cloudinary.CloudinaryConfig;
import com.example.demo.model.Bookinghotel;

import com.example.demo.model.Messagebycustomer;
import com.example.demo.model.Repmessage;
import com.example.demo.model.Users;
import com.example.demo.responsitory.*;
import com.example.demo.services.*;
import com.example.demo.valid.RegisterFormValidator;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Controller
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired HttpSession session;

    @Autowired RegisterFormValidator registerFormValidator;

    @Autowired RestAPI restAPI;

    @Autowired
    VoucherService voucherService;

    @Autowired
    BookingService bookingService;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    FeedBackService feedBackService;

    @Autowired
    FeedBackRepository feedBackRepository;

    @Autowired
    CloudinaryConfig cloudinaryConfig;

    @Autowired
    Cloudinary cloudinary;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RepmessageRepository repmessageRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Autowired GiftRepository giftRepository;


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
//        webDataBinder.setValidator(registerFormValidator);
    }

    public RegisterFormValidator getRegisterFormValidator() {
        return registerFormValidator;
    }

    public void setCustomerValidator(RegisterFormValidator registerFormValidator)
    {
        this.registerFormValidator = registerFormValidator;
    }


    //inforlogin = đăng nhập thành công ->iduser


    @GetMapping("testdate")
    public String testdate()
    {
        return "testdate";
    }
    @GetMapping(value = {"/",""})
    public String HomePage(Model model)
    {
        if(session.getAttribute("inforlogin")!=null)
        {
            String iduser = (String) session.getAttribute("inforlogin");
            model.addAttribute("listnoti",listNoti());
            model.addAttribute("logintrue",true);
            model.addAttribute("user",userService.getUserByID(iduser));
            return "home";
        }
        else
            return "home";
    }


    public List listNoti()
    {
        String iduser = (String) session.getAttribute("inforlogin");
        //Danh sách thông báo phản hồi
        List<Integer> sttMessageSend = messageRepository.getSTTMessageByIDUser(iduser);
        if(sttMessageSend.size()>0)
        {
            List<Repmessage> listRep = new ArrayList<>();
            for(int i=0;i<sttMessageSend.size();i++)
            {
                listRep.add(repmessageRepository.getMessReplied(sttMessageSend.get(i)));
            }
            return listRep;
        }
        return new ArrayList();
    }

    @GetMapping(value = {"/log"})
    public String showLog(Model model)
    {
        model.addAttribute("user", new Users());
        return "log-in-out";
    }

    //Đăng ký
    @PostMapping("/log")
    public String Log (@RequestParam Map<String,String> requestParam, Model model, @Valid Users user,  BindingResult result)
    {
        String ho = requestParam.get("ho");
        String ten = requestParam.get("ten");
        String email = requestParam.get("email");
        String password = requestParam.get("password");
        String phone = requestParam.get("phone");
        String gender = requestParam.get("gender");

        try {
            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type","auto"));
            String avatar= (String) r.get("secure_url");
            user.setAvatar(avatar);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(user.getFile());
        user.setHo(ho);
        user.setTen(ten);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setGender(gender);
//        user.setAvatar(avatar);
        model.addAttribute("user",user);

        if(userRepository.findAllByEmail(email)==null && userRepository.findUserByPhone(phone)==null)
        {
            userService.addUser(user);
            model.addAttribute("errRegist","Đăng ký tài khoản thành công. Vui lòng đăng nhập!");
        }
        else
        {
            model.addAttribute("errRegist","Số điện thoại hoặc email đã được sử dụng");
        }

        return "log-in-out";
    }

    //ĐĂNG NHẬP
    @PostMapping("/login")
    public String Login(@RequestParam Map<String,String> requestParam, Model model, @Valid Users user, BindingResult result)
    {
        String email = requestParam.get("email");
        String password = requestParam.get("password");

        user.setEmail(email);
        user.setPassword(password);

        model.addAttribute("user",user);
        if(userService.checkAccount(email,password)==false)
        {
            model.addAttribute("errLogin","Đăng nhập không thành công");
            return "log-in-out";
        }

        else if(userService.checkAccount(email,password)==true)
        {
            model.addAttribute("user",userService.getUserByEmail(email));
            session.setAttribute("inforlogin",userService.getUserByEmail(email).getIduser());
            model.addAttribute("logintrue",true);
            model.addAttribute("listnoti",listNoti());

            return "home";
        }
        else
            return "log-in-out";
    }

    //LIST HOTEL
    @GetMapping("/list-hotel/{namePlace}")
    public String ListHotelPage(Model model,@PathVariable(value="namePlace") String id,@RequestParam(value = "keywordsearchbynamehotel",required = false,defaultValue = "") String KWSearchByNameHotel)
    {
        model.addAttribute("KWSearchByNameHotel",KWSearchByNameHotel);
        model.addAttribute("namePlace",id);
        model.addAttribute("listnoti",listNoti());
        return "list-hotel";
    }

    //ITEM HOTEL Chi tiết mỗi khách sạn
    @GetMapping("/list-hotel/{namePlace}/{nameHotel}")
    public String DetailHotelPage(Model model,@PathVariable(value="nameHotel") String idhotel, @PathVariable(value="namePlace") String location)
    {
        model.addAttribute("idhotel",idhotel);
        model.addAttribute("idhotel",idhotel);
        model.addAttribute("location",location);
        model.addAttribute("listfeedback",feedBackService.listFeedBackByIDHotel(idhotel));
        model.addAttribute("listnoti",listNoti());
        return "detail";
    }

    //PROFILE
    @GetMapping("/user/profile")
    public String ProfilePage(Model model)
    {
        System.out.println(session.getAttribute("inforlogin"));
        if(session.getAttribute("inforlogin")!=null)
        {
            String iduser = (String) session.getAttribute("inforlogin");
            System.out.println(iduser);
            model.addAttribute("user",userService.getUserByID(iduser));

            List<Bookinghotel> arrMoney = bookingService.listHotelByStatus("Đã trả phòng",iduser);
            int sumMoney = 0;
            DecimalFormat twoPlaces = new DecimalFormat("");
            for(Bookinghotel b:arrMoney)
            {
                sumMoney += Integer.parseInt(b.getTotalprice());
            }
            model.addAttribute("sumMoney",twoPlaces.format(sumMoney));

            model.addAttribute("listnoti",listNoti());

            return "profile";
        }
        else
            return "redirect:/";
    }

    //CẬP NHẬT THÔNG TIN
    @PostMapping("/user/profile")
    public String UpdateProfile (@RequestParam Map<String,String> requestParam,Model model, @Valid Users users,  BindingResult result)
    {
        if(session.getAttribute("inforlogin")!=null)
        {
            String ho = requestParam.get("ho");
            String ten = requestParam.get("ten");
            String sdt = requestParam.get("phone");
            String gender = requestParam.get("gender");
            String password = requestParam.get("password");
            String iduser = (String) session.getAttribute("inforlogin");
            System.out.println("id---"+iduser);


            if(password==null)
                userRepository.updateKHNotPass(ho,ten,gender,sdt,iduser);
            if(password!=null)
                userRepository.updateKHWithPass(ho,ten,gender,sdt,password,iduser);
            model.addAttribute("updatetxt","Cập nhật thông tin thành công");
            return "redirect:/user/profile";
        }
        else
            return "redirect:/";
    }

    public Long dff(String d1, String d2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date dateBefore = sdf.parse(d1);
        Date dateAfter = sdf.parse(d2);

        long timeDiff = Math.abs(dateAfter.getTime() - dateBefore.getTime());
        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        return daysDiff;
    }

    //THANH TOÁN
    @GetMapping("/user/{location}/{idhotel}/{idroom}/checkin={checkin}/checkout={checkout}")
    public String PayPage(Model model,@PathVariable(value="location") String location,
    @PathVariable(value="idhotel") String idhotel, @PathVariable(value="idroom") String idroom,
    @PathVariable(value="checkin") String checkin, @PathVariable(value="checkout") String checkout) throws JSONException, ParseException {
        if(session.getAttribute("inforlogin")!=null)
        {
            model.addAttribute("listnoti",listNoti());

            RestAPI restAPI = new RestAPI();
            model.addAttribute("location",location);
            model.addAttribute("idhotel",idhotel);
            model.addAttribute("idroom",idroom);
            model.addAttribute("checkin",checkin);
            model.addAttribute("checkout",checkout);

            long day = dff(checkin.replaceAll("-","/"),checkout.replaceAll("-","/"));
            model.addAttribute("dff",day);

            String iduser = (String) session.getAttribute("inforlogin");
            model.addAttribute("user",userService.getUserByID(iduser));
            model.addAttribute("namehotel",restAPI.restAPIString(0,location,idhotel,"name_hotel"));
            model.addAttribute("nameroom",restAPI.findInfoRoom(0,location,idhotel,idroom,"nameroom"));
            model.addAttribute("priceroom",Integer.parseInt(restAPI.findInfoRoom(0,location,idhotel,idroom,"priceroom"))*day);
            model.addAttribute("imgroom",restAPI.findInfoRoom(0,location,idhotel,idroom,"imgroom"));
            model.addAttribute("adult",restAPI.findInfoRoom(0,location,idhotel,idroom,"adult"));
            model.addAttribute("child",restAPI.findInfoRoom(0,location,idhotel,idroom,"child"));

            //SEND VOUCHER
            model.addAttribute("listvoucher",voucherService.listVoucher());
            return "pay";
        }
        else
            return "redirect:/log";
    }

    //XEM LICH SU BOOKING
    @GetMapping("/user/profile/history")
    public String HistoryBookingPage(Model model)
    {
        if(session.getAttribute("inforlogin")!=null)
        {
            String iduser = (String) session.getAttribute("inforlogin");
            model.addAttribute("user",userService.getUserByID(iduser));
            model.addAttribute("choxacnhan",bookingService.listHotelByStatus("Chờ xác nhận",iduser));
            model.addAttribute("daxacnhan",bookingService.listHotelByStatus("Đã xác nhận",iduser));
            model.addAttribute("thanhcong",bookingService.listHotelByStatus("Thành công",iduser));
            model.addAttribute("datraphong",bookingService.listHotelByStatus("Đã trả phòng",iduser));
//            model.addAttribute("resqpi",new RestAPI());
            List<Bookinghotel> arrMoney = bookingService.listHotelByStatus("Đã trả phòng",iduser);
            int sumMoney = 0;
            DecimalFormat twoPlaces = new DecimalFormat("");
            for(Bookinghotel b:arrMoney)
            {
                sumMoney += Integer.parseInt(b.getTotalprice());
            }
            model.addAttribute("sumMoney",twoPlaces.format(sumMoney));

            model.addAttribute("listnoti",listNoti());

            return "history";
        }
        else
            return "redirect:/";
    }


    //XEM CÂU HỎI
    @GetMapping("/user/profile/yourquestion")
    public String YourQuestionPage(Model model)
    {
        System.out.println(session.getAttribute("inforlogin"));
        if(session.getAttribute("inforlogin")!=null)
        {
            String iduser = (String) session.getAttribute("inforlogin");
            model.addAttribute("user",userService.getUserByID(iduser));
            model.addAttribute("listnoti",listNoti());
            List<Bookinghotel> arrMoney = bookingService.listHotelByStatus("Đã trả phòng",iduser);
            int sumMoney = 0;
            DecimalFormat twoPlaces = new DecimalFormat("");
            for(Bookinghotel b:arrMoney)
            {
                sumMoney += Integer.parseInt(b.getTotalprice());
            }
            model.addAttribute("sumMoney",twoPlaces.format(sumMoney));
            model.addAttribute("listyourquestion",messageRepository.listMessageByIDUser(iduser));



            return "yourquestion";
        }
        else
            return "redirect:/";
    }

    //TRANG QUÀ TẶNG
    @GetMapping("/user/profile/yourgift")
    public String YourGiftPage(Model model)
    {
        System.out.println(session.getAttribute("inforlogin"));
        if(session.getAttribute("inforlogin")!=null)
        {
            String iduser = (String) session.getAttribute("inforlogin");
            model.addAttribute("user",userService.getUserByID(iduser));
            model.addAttribute("listnoti",listNoti());
            model.addAttribute("listgift",giftRepository.getListGiftByIDNotUsed(iduser));

            List<Bookinghotel> arrMoney = bookingService.listHotelByStatus("Đã trả phòng",iduser);
            int sumMoney = 0;
            DecimalFormat twoPlaces = new DecimalFormat("");
            for(Bookinghotel b:arrMoney)
            {
                sumMoney += Integer.parseInt(b.getTotalprice());
            }
            model.addAttribute("sumMoney",twoPlaces.format(sumMoney));


            return "yourgift";
        }
        else
            return "redirect:/";
    }

    //LOGOUT
    @GetMapping("/logout")
    public String LogOut()
    {
        session.invalidate();
        return "redirect:/";
    }

}
