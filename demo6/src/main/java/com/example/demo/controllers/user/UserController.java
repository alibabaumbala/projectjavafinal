package com.example.demo.controllers.user;

import com.example.demo.API.RestAPI;
import com.example.demo.model.Bookinghotel;
import com.example.demo.model.Users;
import com.example.demo.responsitory.BookingRepository;
import com.example.demo.responsitory.FeedBackRepository;
import com.example.demo.services.BookingService;
import com.example.demo.services.FeedBackService;
import com.example.demo.services.UserService;
import com.example.demo.services.VoucherService;
import com.example.demo.valid.RegisterFormValidator;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
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


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(registerFormValidator);
    }

    public RegisterFormValidator getRegisterFormValidator() {
        return registerFormValidator;
    }

    public void setCustomerValidator(RegisterFormValidator registerFormValidator)
    {
        this.registerFormValidator = registerFormValidator;
    }



    @GetMapping(value = {"/log"})
    public String showLog(Model model)
    {
        model.addAttribute("user", new Users());
        return "log-in-out";
    }

    @PostMapping("/log")
    public String Log (@RequestParam Map<String,String> requestParam, Model model, @Valid Users user,  BindingResult result)
    {

        String ho = requestParam.get("ho");
        String ten = requestParam.get("ten");
        String email = requestParam.get("email");
        String password = requestParam.get("password");

        user.setHo(ho);
        user.setTen(ten);
        user.setEmail(email);
        user.setPassword(password);

        model.addAttribute("user",user);

        if(result.hasErrors())
        {
            return "log-in-out";
        }
        else
        {
            userService.addUser(user);
            return "forward:/log";
        }
    }


    @PostMapping("/login")
    public String Login(@RequestParam Map<String,String> requestParam, Model model, @Valid Users user, BindingResult result)
    {
        String email = requestParam.get("email");
        String password = requestParam.get("password");

        user.setEmail(email);
        user.setPassword(password);

        model.addAttribute("user",user);
        if(userService.checkAccount(email,password)==true)
        {
            session.setAttribute("inforlogin",userService.getUserByEmail(email).getIduser());
            return "home";
        }
        return "log-in-out";
    }

    //LIST HOTEL
    @GetMapping("/list-hotel/{namePlace}")
    public String ListHotelPage(Model model,@PathVariable(value="namePlace") String id,@RequestParam(value = "keywordsearchbynamehotel",required = false,defaultValue = "") String KWSearchByNameHotel)
    {
        model.addAttribute("KWSearchByNameHotel",KWSearchByNameHotel);
        model.addAttribute("namePlace",id);
        return "list-hotel";
    }

    //ITEM HOTEL
    @GetMapping("/list-hotel/{namePlace}/{nameHotel}")
    public String DetailHotelPage(Model model,@PathVariable(value="nameHotel") String idhotel, @PathVariable(value="namePlace") String location)
    {
        model.addAttribute("idhotel",idhotel);
        model.addAttribute("location",location);
        model.addAttribute("listfeedback",feedBackService.listFeedBackByIDHotel(idhotel));
        return "detail";
    }

    //PROFILE
    @GetMapping("user/profile")
    public String ProfilePage(Model model)
    {
        if(session.getAttribute("inforLogin")!="")
        {
            String iduser = (String) session.getAttribute("inforlogin");
            model.addAttribute("user",userService.getUserByID(iduser));
            return "profile";
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
    @GetMapping("user/{location}/{idhotel}/{idroom}/checkin={checkin}/checkout={checkout}")
    public String PayPage(Model model,@PathVariable(value="location") String location,
    @PathVariable(value="idhotel") String idhotel, @PathVariable(value="idroom") String idroom,
    @PathVariable(value="checkin") String checkin, @PathVariable(value="checkout") String checkout) throws JSONException, ParseException {
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
        model.addAttribute("nameroom",restAPI.findInfoRoom(0,location,idhotel,idroom,"nameroom"));
        model.addAttribute("priceroom",Integer.parseInt(restAPI.findInfoRoom(0,location,idhotel,idroom,"priceroom"))*day);
        model.addAttribute("imgroom",restAPI.findInfoRoom(0,location,idhotel,idroom,"imgroom"));
        model.addAttribute("adult",restAPI.findInfoRoom(0,location,idhotel,idroom,"adult"));
        model.addAttribute("child",restAPI.findInfoRoom(0,location,idhotel,idroom,"child"));

        //SEND VOUCHER
        model.addAttribute("listvoucher",voucherService.listVoucher());

        return "pay";
    }

    //XEM LICH SU BOOKING
    @GetMapping("user/profile/history")
    public String HistoryBookingPage(Model model)
    {
        if(session.getAttribute("inforLogin")!="")
        {
            String iduser = (String) session.getAttribute("inforlogin");
            model.addAttribute("user",userService.getUserByID(iduser));
            model.addAttribute("choxacnhan",bookingService.listHotelByStatus("Chờ xác nhận",iduser));
            model.addAttribute("daxacnhan",bookingService.listHotelByStatus("Đã xác nhận",iduser));
            model.addAttribute("thanhcong",bookingService.listHotelByStatus("Thành công",iduser));
            model.addAttribute("huy",bookingService.listHotelByStatus("Hủy",iduser));
//            model.addAttribute("resqpi",new RestAPI());
            return "history";
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
