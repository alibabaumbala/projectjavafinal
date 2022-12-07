package com.example.demo.controllers.admin;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.cloudinary.CloudinaryConfig;
import com.example.demo.model.Employee;
import com.example.demo.model.Users;
import com.example.demo.responsitory.EmployeeRepository;
import com.example.demo.responsitory.VoucherRepository;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
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


    @GetMapping("")
    public String QuanlyHome(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý")) {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));  //lấy ra thong tin quanly
            return "/admin/ql-home";
        } else
            return "redirect:/admin";
    }
    //TRANG QUẢN LÝ NHÂN VIÊN
    @GetMapping("quanly-nhanvien")
    public String QuanLyNhanVien(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dsnv",employeeRepository.findAll());
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

    @GetMapping("quanly-service")
    public String QuanLyService(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dsvoucher",voucherRepository.findAll());
            return "/admin/ql-service";
        } else
            return "redirect:/admin";
    }

    @GetMapping("quanly-booking")
    public String QuanLyBooking(Model model)
    {
        if (session.getAttribute("roleEmp").equals("Quản lý"))
        {
            String id = (String) session.getAttribute("idEmp");
            model.addAttribute("employee", employeeRepository.getEmployeeByID(id));
            model.addAttribute("dsvoucher",voucherRepository.findAll());
            return "/admin/ql-room";
        } else
            return "redirect:/admin";
    }
}
