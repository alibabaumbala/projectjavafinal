package com.example.demo.services;

import com.example.demo.connection.DBConnection;
import com.example.demo.model.Bookinghotel;
import com.example.demo.model.Users;
import com.example.demo.responsitory.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired public static Connection conn = DBConnection.getConnection();

    public String randomIdBooking()
    {
        String SALTCHARS = "0123456789012304785412478213987589658245212369528453205479341230";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
    public int addBooking(Bookinghotel u)
    {
        try {
            PreparedStatement pr = conn.prepareStatement("insert into bookinghotel(iduser,idbooking,location,idhotel,idroom,checkin,checkout,adult,child,sophong,totalprice,statusbooking,representative,phonecontact,emailcontact,review) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            String id = randomIdBooking();
            pr.setNString(1,u.getIduser());
            pr.setNString(2,id);
            pr.setNString(3,u.getLocation());
            pr.setNString(4,u.getIdhotel());
            pr.setNString(5,u.getIdroom());
            pr.setNString(6,u.getCheckin());
            pr.setNString(7,u.getCheckout());
            pr.setInt(8,u.getAdult());
            pr.setInt(9,u.getChild());
            pr.setInt(10,u.getSophong());
            pr.setString(11,u.getTotalprice());
            pr.setNString(12,"Chờ xác nhận");
            pr.setString(13,u.getRepresentative());
            pr.setString(14,u.getPhonecontact());
            pr.setString(15,u.getEmailcontact());
            pr.setInt(16,0);

            return pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return 0; //insert thất bại
        }
    }

    public List<Bookinghotel> listHotelByStatus(String status, String iduser)
    {
        return bookingRepository.listHotelByStatus(status,iduser);
    }

    public Bookinghotel getBookingById(String id)
    {
        return bookingRepository.getBookinghotelByID(id);
    }

    //update review status
    public boolean updateStatusReview(Bookinghotel item)
    {
        String sql = "update bookinghotel set review = 1 where idbooking = ?";
        PreparedStatement statement = null;
        ResultSet resultSet= null;
        try{

            conn.setAutoCommit(false);
            statement=conn.prepareStatement(sql);

            statement.setNString(1,item.getIdbooking());

            int row = statement.executeUpdate();
            conn.commit();
            if(row == 1)
            {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
