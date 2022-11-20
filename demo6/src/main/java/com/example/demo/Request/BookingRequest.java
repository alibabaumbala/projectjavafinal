package com.example.demo.Request;

public record BookingRequest(String iduser,String idhotel,String location,String idroom, String checkin, String checkout, int adult, int child, String totalprice, String datebooking, String representative, String phonecontact, String emailcontact) {
}
