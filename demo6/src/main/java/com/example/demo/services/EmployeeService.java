package com.example.demo.services;

import com.example.demo.connection.DBConnection;
import com.example.demo.model.Employee;

import com.example.demo.responsitory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public String setIDForEmp(String position)
    {
        String ps ="";
        String numPosition = "";
        if(position.equals("Quản lý"))
            ps="ql";
        else if(position.equals("Lễ tân"))
            ps="lt";
        else if(position.equals("Kế toán"))
            ps="kt";

        if(employeeRepository.countPosition(position).size()==0)
            numPosition = "1";
        else
        {
            List<String> list = employeeRepository.countPosition(position);
            ArrayList<Integer> listcount = new ArrayList<>();
            for(int i=0;i<list.size();i++)
            {
                listcount.add(Integer.parseInt(list.get(i).substring(2)));
            }
            numPosition = String.valueOf(Collections.max(listcount)+1);
        }

        if(numPosition.length()==1)
            return ps+"00000"+numPosition;
        if(numPosition.length()==2)
            return ps+"0000"+numPosition;
        if(numPosition.length()==3)
            return ps+"000"+numPosition;
        if(numPosition.length()==4)
            return ps+"00"+numPosition;
        if(numPosition.length()==5)
            return ps+"0"+numPosition;
        else
            return ps+numPosition;
    }

    @Autowired public static Connection conn = DBConnection.getConnection();

    public int addNewEmployee(Employee u)
    {
        try {
            PreparedStatement pr = conn.prepareStatement("insert into employee(idemp,tenemp,sdtemp,emailemp,genderemp,positionemp,passemp,avatar) values (?,?,?,?,?,?,?,?)");
            pr.setNString(1,setIDForEmp(u.getPositionemp()));
            pr.setNString(2,u.getTenemp());
            pr.setNString(3,u.getSdtemp());
            pr.setNString(4,u.getEmailemp());
            pr.setNString(5,u.getGenderemp());
            pr.setNString(6,u.getPositionemp());
            pr.setNString(7,u.getPassemp());
            pr.setNString(8,u.getAvatar());
            return pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return 0; //insert thất bại
        }
    }

}
