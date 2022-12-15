package com.example.demo.services;
import com.example.demo.connection.DBConnection;
import com.example.demo.model.Users;
import com.example.demo.responsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService
{
    @Autowired public UserRepository repository;
    @Autowired public static Connection conn = DBConnection.getConnection();


    public Users getUserByEmail(String email)
    {
        Users users = repository.findAllByEmail(email);
        if (users!=null)
            return users;
        else
            return null;
    }

    public List<String> getAPIEmail()
    {
        List<String> listEmail = new ArrayList<>();
        for(Users o:repository.findAll())
        {
            listEmail.add(o.getEmail());
        }
        return listEmail;
    }

    public String randomID()
    {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public int addUser(Users u)
    {
        try {
            PreparedStatement pr = conn.prepareStatement("insert into users(iduser,ho,ten,email,phone,password,avatar,gender) values (?,?,?,?,?,?,?,?)");
            String id = randomID();
            pr.setNString(1,id);
            pr.setNString(2,u.getHo());
            pr.setNString(3,u.getTen());
            pr.setNString(4,u.getEmail());
            pr.setNString(5,u.getPhone());
            pr.setNString(6,u.getPassword());
            pr.setNString(7,u.getAvatar());
            pr.setNString(8,u.getGender());
            return pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return 0; //insert thất bại
        }
    }

    public int addBooking(Users u)
    {
        try {
            PreparedStatement pr = conn.prepareStatement("insert into users(iduser,ho,ten,email,password) values (?,?,?,?,?)");
            String id = randomID();
            pr.setNString(1,id);
            pr.setNString(2,u.getHo());
            pr.setNString(3,u.getTen());
            pr.setNString(4,u.getEmail());
            pr.setNString(5,u.getPassword());
            return pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return 0; //insert thất bại
        }
    }

    public boolean checkAccount(String email, String password)
    {
        if(getUserByEmail(email)==null)
            return false;
        else if(getUserByEmail(email).getPassword().equals(password))
        {
            return true;
        }
        else
            return false;
    }

    public Users getUserByID(String id)
    {
        Users user = repository.findUsersByID(id);
        return user;
    }
}
