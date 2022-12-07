-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 07, 2022 lúc 07:18 PM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `java-final`
--
CREATE DATABASE IF NOT EXISTS `java-final` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `java-final`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bookinghotel`
--

CREATE TABLE `bookinghotel` (
  `iduser` varchar(255) NOT NULL,
  `idbooking` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `idhotel` varchar(255) NOT NULL,
  `idroom` varchar(255) NOT NULL,
  `checkin` varchar(255) NOT NULL,
  `checkout` varchar(255) NOT NULL,
  `adult` int(50) DEFAULT NULL,
  `child` int(50) DEFAULT NULL,
  `sophong` int(10) NOT NULL,
  `totalprice` varchar(255) NOT NULL,
  `statusbooking` varchar(255) DEFAULT 'Chờ xác nhận',
  `datebooking` timestamp NULL DEFAULT current_timestamp(),
  `representative` varchar(255) NOT NULL,
  `phonecontact` varchar(255) NOT NULL,
  `emailcontact` varchar(255) NOT NULL,
  `review` int(10) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `bookinghotel`
--

INSERT INTO `bookinghotel` (`iduser`, `idbooking`, `location`, `idhotel`, `idroom`, `checkin`, `checkout`, `adult`, `child`, `sophong`, `totalprice`, `statusbooking`, `datebooking`, `representative`, `phonecontact`, `emailcontact`, `review`) VALUES
('LyrbUXfi', '02331792', 'phuquoc', 'pq-hotel-2', 'pq-hotel-2-room-1', '11-23-2022', '11-25-2022', 2, 1, 1, '2700000', 'Chờ xác nhận', '2022-11-21 04:21:53', 'Mỹ  Tâm', '0120120123', 'vanhuy1619@gmail.com', 0),
('AC7wvkbb', '03883343', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-5', '11-23-2022', '11-26-2022', 3, 0, 1, '18000000', 'Thành công', '2022-11-20 09:20:38', 'Nguyễn Văn Huy', '0123456789', 'mvmanh@gmail.com', 1),
('Vyg5mSbD', '08974524', 'phuquoc', 'pq-hotel-3', 'pq-hotel-3-room-2', '11-22-2022', '11-24-2022', 4, 4, 2, '31644000', 'Chờ xác nhận', '2022-11-21 04:27:57', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 0),
('LyrbUXfi', '09337502', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', '11-22-2022', '11-24-2022', 2, 0, 1, '5600000', 'Thành công', '2022-11-21 03:37:12', 'Mỹ  Tâm', '0169111021', 'vanhuy1619@gmail.com', 1),
('Vyg5mSbD', '13143307', 'phuquoc', 'pq-hotel-3', 'pq-hotel-3-room-1', '11-23-2022', '11-26-2022', 8, 8, 1, '33000000', 'Chờ xác nhận', '2022-11-21 04:25:36', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 0),
('AC7wvkbb', '34096274', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-4', '11-22-2022', '11-23-2022', 2, 0, 1, '4000000', 'Chờ xác nhận', '2022-11-20 18:29:48', 'Anh Khoa', '0123456789', 'akhoa@gmail.com', 0),
('Vyg5mSbD', '47226249', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', '11-23-2022', '11-25-2022', 2, 0, 2, '11200000', 'Thành công', '2022-11-21 04:13:16', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 1),
('xjMyfFnr', '48422009', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', '11-26-2022', '11-28-2022', 2, 0, 1, '1200000', 'Thành công', '2022-11-19 18:34:36', 'Anh Khoa', '0123456789', 'mvam@gmail.com', 1),
('Vyg5mSbD', '49858221', 'phuquoc', 'pq-hotel-2', 'pq-hotel-2-room-1', '11-22-2022', '11-24-2022', 2, 1, 2, '6000000', 'Thành công', '2022-11-21 03:23:08', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 1),
('AC7wvkbb', '51124468', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-6', '11-22-2022', '11-26-2022', 4, 0, 1, '12900000', 'Hủy', '2022-11-20 04:53:38', 'Nguyễn Văn Huy', '0123456789', 'mvmanh@gmail.com', 0),
('LyrbUXfi', '52729983', 'phuquoc', 'pq-hotel-3', 'pq-hotel-3-room-2', '11-29-2022', '11-30-2022', 4, 4, 1, '8790000', 'Thành công', '2022-11-26 12:01:51', 'Mỹ  Tâm', '0120120123', 'vanhuy1619@gmail.com', 1),
('AC7wvkbb', '58384150', 'dalat', 'dl-hotel-1', 'dl-hotel-1-room-2', '11-25-2022', '11-26-2022', 4, 0, 1, '700000', 'Thành công', '2022-11-24 10:06:17', 'Nguyễn Văn Huy', '0123456789', 'mvmanh@gmail.com', 1),
('Vyg5mSbD', '70919402', 'phuquoc', 'pq-hotel-3', 'pq-hotel-3-room-1', '11-23-2022', '11-25-2022', 8, 8, 1, '22000000', 'Đã xác nhận', '2022-11-21 04:12:10', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 0),
('Vyg5mSbD', '74358981', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-3', '11-23-2022', '11-26-2022', 2, 0, 2, '15000000', 'Thành công', '2022-11-21 03:23:57', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `idemp` varchar(255) NOT NULL,
  `tenemp` varchar(255) NOT NULL,
  `sdtemp` varchar(255) NOT NULL,
  `emailemp` varchar(255) NOT NULL,
  `genderemp` varchar(255) NOT NULL,
  `positionemp` varchar(255) NOT NULL,
  `passemp` varchar(255) NOT NULL,
  `createemp` datetime DEFAULT current_timestamp(),
  `avatar` varchar(1000) DEFAULT 'https://scontent.fsgn9-1.fna.fbcdn.net/v/t39.30808-6/316090422_829751481567201_6711936184425690336_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=174925&_nc_ohc=tAHTEJVO-3UAX_kaFCe&_nc_ht=scontent.fsgn9-1.fna&oh=00_AfCy2-6VLaES_gU8wVU2hj0uFJ3dfucljLwp4tel7PT_4w&oe=638F66CD'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`idemp`, `tenemp`, `sdtemp`, `emailemp`, `genderemp`, `positionemp`, `passemp`, `createemp`, `avatar`) VALUES
('lt000001', 'Minh Hằng', '0965874231', 'vanhuy1619@gmail.com', 'Female', 'Lễ tân', '123456', '2022-12-07 23:29:37', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670430575/cpazfbbm1nzywd9byrua.jpg'),
('ql000003', 'Đông Nhi', '0965874231', 'toctien@gmail.com', 'Female', 'Quản lý', '123456', '2022-08-03 13:56:37', 'https://scontent.fsgn9-1.fna.fbcdn.net/v/t1.6435-9/198152502_502686704273682_104451209091447411_n.jpg?stp=c0.169.827.827a_dst-jpg_s851x315&_nc_cat=104&ccb=1-7&_nc_sid=da31f3&_nc_ohc=VJllLKZA-VEAX-hwsNz&tn=KWoGFGK0B3e-EmZW&_nc_ht=scontent.fsgn9-1.fna&oh=00_AfBTilLK4pHvrIn_U4Pg0mc89jlM9uStnSD-agJP_Vt1Ng&oe=63B27E06');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `feedback`
--

CREATE TABLE `feedback` (
  `idfeedback` int(255) NOT NULL,
  `idbooking` varchar(255) NOT NULL,
  `iduser` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `idhotel` varchar(255) NOT NULL,
  `idroom` varchar(255) NOT NULL,
  `star` int(10) NOT NULL,
  `contentfeedback` varchar(1000) DEFAULT NULL,
  `datefeedback` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `feedback`
--

INSERT INTO `feedback` (`idfeedback`, `idbooking`, `iduser`, `location`, `idhotel`, `idroom`, `star`, `contentfeedback`, `datefeedback`) VALUES
(1421501290, '03883343', 'AC7wvkbb', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-5', 5, 'Rất hay, rất đẹp, tuy nhiên ko hiểu sao vé mình ko scan được, nhưng ban tổ chức vẫn chụp ảnh vé lại và cho vào. ❤️❤️❤️ nên thử khi đi nhé', '2022-11-20 10:15:04'),
(1421501294, '48422009', 'xjMyfFnr', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', 3, 'Dịch vụ chưa tốt lắm, nhưng view thì đẹp. Đồ ăn khá ngon', '2022-11-20 18:36:04'),
(1421501295, '74358981', 'Vyg5mSbD', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-3', 4, 'Vin Oasis là resort 5 sao cạnh Grand World & có Waterpark nội khu. Mọi thứ đều rất ổn, tụi nhỏ nhà mình rất thích. Phần xe chung chuyển giữa Vin Oasis và Grand thì không đc order có ngay mà phải căn giờ đi, về cách nhau cả tiếng đồng hồ mỗi chuyến nên hơi bất tiện.', '2022-11-21 03:28:17'),
(1421501296, '49858221', 'Vyg5mSbD', 'phuquoc', 'pq-hotel-2', 'pq-hotel-2-room-1', 5, 'Trải nghiệm tốt. Mua vé Klook rẻ và tiện. nhưng cần hỗ trợ gấp thì khó liên hệ Gần Vinoasis có nhiều điểm tham quan, phục vụ tận tình, sạch sẽ', '2022-11-21 03:28:47'),
(1421501297, '09337502', 'LyrbUXfi', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', 5, 'Dịch vụ đẳng cấp, đáng tiền nhất, nhân viên chăm sóc khách hàng của Klook hỗ trợ nhiệt tình khi xảy ra sự cố, sẽ ủng hộ Klook cho những đơn hàng kế tiếp', '2022-11-21 03:38:59'),
(1421501298, '47226249', 'Vyg5mSbD', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', 5, 'Khách sạn rất đẹp', '2022-11-21 04:28:23'),
(1421501299, '58384150', 'AC7wvkbb', 'dalat', 'dl-hotel-1', 'dl-hotel-1-room-2', 5, 'Nhân viên khách sạn rất nhiệt tình, khách sạn đẹp gần trung tâm dễ dàng di chuyển', '2022-11-24 10:08:39'),
(1421501301, '52729983', 'LyrbUXfi', 'phuquoc', 'pq-hotel-3', 'pq-hotel-3-room-2', 5, 'An amazing hotel in its beauty, looks like heaven. Beautiful and clean rooms in every private pool, excellent gym, huge pool that is softer on the beach. A private beach and stunning in its beauty, it is impossible to put into words how beautiful the beach is coconut trees and clear water the hotel staff very services. Protecting the environment Using paper requests. There is an electric vehicle service available to transport you anytime, anywhere. In addition, a free airport shuttle service to the city. A rich dining room and a variety of hotel staff will prepare you to eat anything you request. In conclusion if you are looking for heaven this is exactly the place !!!', '2022-11-26 12:16:21');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `iduser` varchar(255) NOT NULL,
  `ho` varchar(255) NOT NULL,
  `ten` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `avatar` varchar(1000) DEFAULT NULL,
  `role` varchar(255) DEFAULT 'USER_ROLE',
  `gender` varchar(10) DEFAULT 'Male',
  `phone` varchar(10) NOT NULL,
  `point` int(255) DEFAULT 0,
  `creact_account` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`iduser`, `ho`, `ten`, `email`, `password`, `avatar`, `role`, `gender`, `phone`, `point`, `creact_account`) VALUES
('AC7wvkbb', 'Nguyễn', 'Bảo Anh', 'mvmanh@gmail.com', '123456', 'https://media.glamour.com/photos/6377a1e555f8e14c67143e19/master/pass/GettyImages-1406473123.jpg', 'USER_ROLE', 'Female', '0659787888', 10, '2022-11-14 20:38:00'),
('jGkBN5C7', 'Nguyễn', 'Văn Huy', 'kwonjiyong2702@gmail.com', '123456', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670427575/cunuwerwx6xwvajlljk2.jpg', 'USER_ROLE', 'Male', '0547898788', 0, '2022-12-07 22:39:36'),
('LyrbUXfi', 'Nguyễn', 'Huy', 'vanhuy1619@gmail.com', '123', 'https://i.scdn.co/image/ab67616d0000b273a97c8b7dcb20c796540ffed2', 'USER_ROLE', 'Male', '0123456789', 15, '2022-11-21 10:36:42'),
('PwzpbJqx', 'Lý', 'Mạc Sầu', 'vipbigbang5xxx@gmail.com', '123', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1669460434/hagwjuj2ckkyh0bm1qwz.jpg', 'USER_ROLE', 'Female', '0659787878', 0, '2022-11-26 18:00:35'),
('Vyg5mSbD', 'Hồ', 'Quỳnh Hương', 'khoanguyen30lb@gmail.com', '123', 'https://kenh14cdn.com/thumb_w/660/203336854389633024/2022/9/29/5-16644449670421462690434.jpeg', 'USER_ROLE', 'Male', '0929046031', 25, '2022-11-21 10:14:59');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `voucher`
--

CREATE TABLE `voucher` (
  `idvoucher` varchar(255) NOT NULL,
  `discount` varchar(255) NOT NULL,
  `soluong` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `voucher`
--

INSERT INTO `voucher` (`idvoucher`, `discount`, `soluong`) VALUES
('vc1', '25%', 10),
('vc123', '10%', 10),
('vc2', '10%', 10),
('vc3', '10%', 10),
('vc4', '50%', 10);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bookinghotel`
--
ALTER TABLE `bookinghotel`
  ADD PRIMARY KEY (`idbooking`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`idemp`);

--
-- Chỉ mục cho bảng `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`idfeedback`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`iduser`,`email`),
  ADD UNIQUE KEY `iduser` (`iduser`,`email`);

--
-- Chỉ mục cho bảng `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`idvoucher`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `feedback`
--
ALTER TABLE `feedback`
  MODIFY `idfeedback` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1421501302;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
