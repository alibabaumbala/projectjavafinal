package com.example.demo.controllers;

import com.example.demo.model.Employee;
import com.example.demo.responsitory.EmployeeRepository;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@Controller

public class HomeController implements ErrorController
{
    @Autowired
    HttpSession session;

    @Autowired
    EmployeeRepository employeeRepository;


    //roleEmp = chưc vụ phân quyền


    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error";
            }
        }
        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }


    @GetMapping(value = {"/admin","admin","admin/"})
    public String LoginAdmin(Model model)
    {
        String role = "";
        if (session.getAttribute("roleEmp") == null)
            role = "";
        else
            role = (String) session.getAttribute("roleEmp");

        if (role.equals("Quản lý"))
            return "redirect:/admin/quanly";
        if (role.equals("Lễ tân"))
            return "redirect:/admin/letan";
        if (role.equals("")) {
            model.addAttribute("employee", new Employee());
            return "/admin/loginadmin";
        }
        return "/admin/loginadmin";
    }

    //ĐĂNG NHẬP VÀO TRANG QUẢN LÝ
    @PostMapping("/admin/login")
    public String EmploymentLogin(@RequestParam Map<String, String> requestParam, Model model, @Valid Employee emp) {
        String idemp = requestParam.get("idemp");
        String passemp = requestParam.get("passemp");

        if (employeeRepository.getEmployeeByIDAndPass(idemp, passemp) != null) {
            String role = employeeRepository.getEmployeeByIDAndPass(idemp, passemp).getPositionemp();
            session.setAttribute("roleEmp", role);
            session.setAttribute("idEmp", idemp);
            if (role.equals("Quản lý")) {
                return "redirect:/admin/quanly";
            }
            if (role.equals("Lễ tân")) {
                return "redirect:/amin/letan";
            }
        }
        return "/admin";
    }



}
