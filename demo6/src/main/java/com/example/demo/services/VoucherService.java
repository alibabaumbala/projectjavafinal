package com.example.demo.services;

import com.example.demo.model.Voucher;
import com.example.demo.responsitory.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherService {
    @Autowired
    VoucherRepository voucherRepository;

    public List<Voucher> listVoucher()
    {
        return voucherRepository.findAll();
    }

    public String valueDiscount(String idvoucher) {
        return voucherRepository.getDiscountByIdv(idvoucher);
    }
}
