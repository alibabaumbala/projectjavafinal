package com.example.demo.services;

import com.example.demo.connection.DBConnection;
import com.example.demo.model.Users;
import com.example.demo.model.Voucher;
import com.example.demo.responsitory.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class VoucherService {
    @Autowired
    VoucherRepository voucherRepository;

    @Autowired public static Connection conn = DBConnection.getConnection();

    public List<Voucher> listVoucher()
    {
        return voucherRepository.findAll();
    }

    public String valueDiscount(String idvoucher) {
        return voucherRepository.getDiscountByIdv(idvoucher);
    }

    public int addNewVoucher(Voucher u)
    {
        try {
            PreparedStatement pr = conn.prepareStatement("insert into voucher(idvoucher,discount,soluong) values (?,?,?)");
            pr.setNString(1,u.getIdvoucher());
            pr.setNString(2,u.getDiscount());
            pr.setInt(3,u.getSoluong());
            return pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return 0; //insert thất bại
        }
    }
}
