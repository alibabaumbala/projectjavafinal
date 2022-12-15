package com.example.demo.controllers.admin;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.API.API;
import com.example.demo.cloudinary.CloudinaryConfig;
import com.example.demo.controllers.api.APIController;
import com.example.demo.model.Bookinghotel;
import com.example.demo.model.Employee;
import com.example.demo.model.Service;
import com.example.demo.model.Users;
import com.example.demo.responsitory.*;
import com.example.demo.services.BookingService;
import com.example.demo.services.EmployeeService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin/quanly")
public class ManagerController {
    @Autowired
    HttpSession session;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CloudinaryConfig cloudinaryConfig;

    @Autowired
    Cloudinary cloudinary;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    VoucherRepository voucherRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    UserService userService;

    @Autowired
    BookingService bookingService;

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BuyServiceRepository buyServiceRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    API api;

    @Autowired APIController apiController;


    @GetMapping("")
    public String QuanlyHome(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý")) {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));  //lấy ra thong tin quanly
            model.addAttribute("service",serviceRepository.top5Sevice());
            model.addAttribute("listmess",messageRepository.listMessByStatusRep(0));
            return "/admin/ql-home";
        } else
            return "redirect:/admin";
    }

    // ORDER BY


    //TRANG QUẢN LÝ NHÂN VIÊN
    @GetMapping("quanly-nhanvien")
    public String QuanLyNhanVien(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));

            model.addAttribute("dsnv",employeeRepository.getAllEmpDESCCreate());
            return "/admin/ql-nhanvien";
        } else
            return "redirect:/admin";
    }

    //THÊM NHÂN VIÊN
    @RequestMapping(value = "quanly-nhanvien/add",method = RequestMethod.POST)
    public String add(@RequestParam Map<String,String> requestParam, Model model, @Valid Employee e)
    {
        String tenemp = requestParam.get("tenemp");
        String sdtemp = requestParam.get("sdtemp");
        String genderemp = requestParam.get("genderemp");
        String emailemp = requestParam.get("emailemp");
        String positionemp = requestParam.get("positionemp");
        String passemp = requestParam.get("passemp");
        String file = requestParam.get("file");
        System.out.println(tenemp);
        System.out.println(file);

        try {
            Map r = this.cloudinary.uploader().upload(e.getFile().getBytes(), ObjectUtils.asMap("resource_type","auto"));
            String avatar= (String) r.get("secure_url");

            e.setAvatar(avatar);

        } catch (IOException z) {
            throw new RuntimeException(z);
        }


//        e.setAvatar(avatar);
        e.setTenemp(tenemp);
        e.setSdtemp(sdtemp);
        e.setEmailemp(emailemp);
        e.setGenderemp(genderemp);
        e.setPositionemp(positionemp);
        e.setPassemp(passemp);

        employeeService.addNewEmployee(e);
        return "redirect:/admin/quanly/quanly-nhanvien";
    }


    //QUẢN LÝ BOOKING
    @GetMapping("quanly-booking")
    public String QuanLyBooking(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dsvoucher",voucherRepository.findAll());
            return "/admin/ql-booking";
        } else
            return "redirect:/admin";
    }

    //XEM HISTORY BOOKING CỦA KHÁCH HÀNG THÔNG QUA ID
    @GetMapping(value = {"khachhang/historybooking/{iduser}"})
    public String GetScheduleByIDKH(@PathVariable String iduser,Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý")||session.getAttribute("roleEmp").equals("Lễ tân"))
        {
            model.addAttribute("user",userService.getUserByID(iduser));
            model.addAttribute("choxacnhan",bookingService.listHotelByStatus("Chờ xác nhận",iduser));
            model.addAttribute("daxacnhan",bookingService.listHotelByStatus("Đã xác nhận",iduser));
            model.addAttribute("thanhcong",bookingService.listHotelByStatus("Thành công",iduser));
            model.addAttribute("datraphong",bookingRepository.listHotelByStatus("Đã trả phòng",iduser));

            List<Bookinghotel> arrMoney = bookingService.listHotelByStatus("Thành công",iduser);
            int sumMoney = 0;
            DecimalFormat twoPlaces = new DecimalFormat("");
            for(Bookinghotel b:arrMoney)
            {
                sumMoney += Integer.parseInt(b.getTotalprice());
            }
            model.addAttribute("sumMoney",twoPlaces.format(sumMoney));
            return "history";
        }
        else
        {
            return "redirect:/login";
        }
    }

    //TRANG QUẢN LÝ KHÁCH HÀNG
    @GetMapping("quanly-khachhang")
    public String QuanLyKhachHang(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dskh",userRepository.getListUserByStatus("Active"));
            return "/admin/ql-khachhang";
        } else
            return "redirect:/admin";
    }

    //TRANG QUẢN LÝ DICH VU
    @GetMapping("quanly-dichvu")
    public String QuanLyService(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dsvoucher",voucherRepository.findAll());
            model.addAttribute("dsserviceactive",serviceRepository.getServiceActive());
            model.addAttribute("newservice",new Service());
            return "/admin/ql-dichvu";
        } else
            return "redirect:/admin";
    }

    //THÊM DỊCH VỤ
    @RequestMapping(value = "quanly-dichvu/add",method = RequestMethod.POST)
    public String addService(@RequestParam Map<String,String> requestParam, Model model, @Valid Service service)
    {
        String nameService = requestParam.get("nameService");
        String amount = requestParam.get("amount");
        String price = requestParam.get("price");
        String description = requestParam.get("description");

        try {
            Map r = this.cloudinary.uploader().upload(service.getFile().getBytes(), ObjectUtils.asMap("resource_type","auto"));
            String avatar= (String) r.get("secure_url");

            service.setImgService(avatar);

        } catch (IOException z) {
            throw new RuntimeException(z);
        }


        service.setNameService(nameService);
        service.setPrice(price);
        service.setDescription(description);
        service.setAmount(Integer.parseInt(amount));
        service.setStatus("Active");

        serviceRepository.save(service);
        return "redirect:/admin/quanly/quanly-dichvu";
    }

    //XEM BILL KHÁCH HÀNG
    @GetMapping("quanly-bill-khachhang/{iduser}/{idbooking}")
    public String QuanLyBillKhachHang(@PathVariable String iduser,@PathVariable String idbooking,Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý")||session.getAttribute("roleEmp").equals("Lễ tân"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("service",serviceRepository.findAll());
            model.addAttribute("ttkh",userRepository.findUsersByID(iduser)); //thông tin khách hàng
            model.addAttribute("ttdp",bookingService.getBookingById(idbooking)); //thông tin đặt phòng
            model.addAttribute("product",productRepository.findAll());
            model.addAttribute("buyservice",buyServiceRepository.getListBuyServiceByIdUserAndIdBooking(iduser,idbooking));
            return "/admin/ql-bill-user";
        }
        else
        {
            return "redirect:/login";
        }
    }

    //TRANG QUẢN LÝ VOUCHER
    @GetMapping("quanly-voucher")
    public String QuanLyVoucher(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dsvoucher",voucherRepository.findAll());
            model.addAttribute("dskh",userRepository.findAll());
            return "/admin/ql-voucher";
        } else
            return "redirect:/admin";
    }

    //TRANG QUẢN LÝ KHÁCH SẠN
    @GetMapping("quanly-khachsan")
    public String QuanLyHotel(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dsvoucher",voucherRepository.findAll());
            model.addAttribute("dsserviceactive",serviceRepository.getServiceActive());
            model.addAttribute("newservice",new Service());
            return "/admin/ql-khachsan";
        } else
            return "redirect:/admin";
    }

    //XEM DANH SÁCH KHÁCH SẠN TẠI ĐIỂM ĐẾN ĐÓ
    @GetMapping("quanly-khachsan/{location}")
    public String QuanLyBillKhachHang(@PathVariable String location,Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý")||session.getAttribute("roleEmp").equals("Lễ tân"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("location",location);
            model.addAttribute("listhotel",api.webclient2(location));
            return "/admin/ql-ds-hotel";
        }
        else
        {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String LogOut()
    {
        session.invalidate();
        return "redirect:/admin";
    }


}
