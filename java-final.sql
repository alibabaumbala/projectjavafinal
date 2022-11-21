-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 21, 2022 lúc 04:44 AM
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
  `datebooking` timestamp NOT NULL DEFAULT current_timestamp(),
  `representative` varchar(255) NOT NULL,
  `phonecontact` varchar(255) NOT NULL,
  `emailcontact` varchar(255) NOT NULL,
  `review` int(10) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `bookinghotel`
--

INSERT INTO `bookinghotel` (`iduser`, `idbooking`, `location`, `idhotel`, `idroom`, `checkin`, `checkout`, `adult`, `child`, `sophong`, `totalprice`, `statusbooking`, `datebooking`, `representative`, `phonecontact`, `emailcontact`, `review`) VALUES
('AC7wvkbb', '03883343', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-5', '11-23-2022', '11-26-2022', 3, 0, 1, '18000000', 'Thành công', '2022-11-20 09:20:38', 'Nguyễn Văn Huy', '0123456789', 'mvmanh@gmail.com', 1),
('LyrbUXfi', '09337502', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', '11-22-2022', '11-24-2022', 2, 0, 1, '5600000', 'Thành công', '2022-11-21 03:37:12', 'Mỹ  Tâm', '', 'vanhuy1619@gmail.com', 1),
('AC7wvkbb', '24548251', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-2', '11-21-2022', '11-23-2022', 2, 1, 1, '6000000', 'Chờ xác nhận', '2022-11-20 09:19:52', 'Nguyễn Văn Huy', '0123456789', 'mvmanh@gmail.com', 0),
('AC7wvkbb', '34096274', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-4', '11-22-2022', '11-23-2022', 2, 0, 1, '4000000', 'Chờ xác nhận', '2022-11-20 18:29:48', 'Anh Khoa', '0123456789', 'akhoa@gmail.com', 0),
('xjMyfFnr', '48422009', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', '11-26-2022', '11-28-2022', 2, 0, 1, '1200000', 'Thành công', '2022-11-19 18:34:36', 'Anh Khoa', '0123456789', 'mvam@gmail.com', 1),
('Vyg5mSbD', '49858221', 'phuquoc', 'pq-hotel-2', 'pq-hotel-2-room-1', '11-22-2022', '11-24-2022', 2, 1, 2, '6000000', 'Thành công', '2022-11-21 03:23:08', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 1),
('xjMyfFnr', '50889404', 'phuquoc', 'pq-hotel-2', 'pq-hotel-2-room-1', '11-24-2022', '11-25-2022', 2, 1, 1, '1500000', 'Chờ xác nhận', '2022-11-20 18:32:50', 'Nguyễn Thư', '0124574444', 'admin@gmail.com', 0),
('AC7wvkbb', '51124468', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-6', '11-22-2022', '11-26-2022', 4, 0, 1, '12900000', 'Hủy', '2022-11-20 04:53:38', 'Nguyễn Văn Huy', '0123456789', 'mvmanh@gmail.com', 0),
('Vyg5mSbD', '74358981', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-3', '11-23-2022', '11-26-2022', 2, 0, 2, '15000000', 'Thành công', '2022-11-21 03:23:57', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 1);

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
(1421501295, '74358981', 'Vyg5mSbD', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-3', 5, 'Vin Oasis là resort 5 sao cạnh Grand World & có Waterpark nội khu. Mọi thứ đều rất ổn, tụi nhỏ nhà mình rất thích. Phần xe chung chuyển giữa Vin Oasis và Grand thì không đc order có ngay mà phải căn giờ đi, về cách nhau cả tiếng đồng hồ mỗi chuyến nên hơi bất tiện.', '2022-11-21 03:28:17'),
(1421501296, '49858221', 'Vyg5mSbD', 'phuquoc', 'pq-hotel-2', 'pq-hotel-2-room-1', 5, 'Trải nghiệm tốt. Mua vé Klook rẻ và tiện. nhưng cần hỗ trợ gấp thì khó liên hệ Gần Vinoasis có nhiều điểm tham quan, phục vụ tận tình, sạch sẽ', '2022-11-21 03:28:47'),
(1421501297, '09337502', 'LyrbUXfi', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', 5, 'Dịch vụ đẳng cấp, đáng tiền nhất, nhân viên chăm sóc khách hàng của Klook hỗ trợ nhiệt tình khi xảy ra sự cố, sẽ ủng hộ Klook cho những đơn hàng kế tiếp', '2022-11-21 03:38:59');

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
  `gender` varchar(10) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `point` int(255) DEFAULT 0,
  `creact_account` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`iduser`, `ho`, `ten`, `email`, `password`, `avatar`, `role`, `gender`, `phone`, `point`, `creact_account`) VALUES
('AC7wvkbb', 'Nguyễn', 'Văn Huy', 'mvmanh@gmail.com', '123', 'https://media.glamour.com/photos/6377a1e555f8e14c67143e19/master/pass/GettyImages-1406473123.jpg', 'USER_ROLE', NULL, '0123456789', 10, '2022-11-14 20:38:00'),
('LyrbUXfi', 'Mỹ ', 'Tâm', 'vanhuy1619@gmail.com', '123', 'https://i.scdn.co/image/ab67616d0000b273a97c8b7dcb20c796540ffed2', 'USER_ROLE', NULL, NULL, 0, '2022-11-21 10:36:42'),
('Vyg5mSbD', 'Hồ', 'Quỳnh Hương', 'khoanguyen30lb@gmail.com', '123', 'https://kenh14cdn.com/thumb_w/660/203336854389633024/2022/9/29/5-16644449670421462690434.jpeg', 'USER_ROLE', NULL, '0929046031', 0, '2022-11-21 10:14:59'),
('xjMyfFnr', 'Nguyễn', 'Thư', 'admin@gmail.com', '123', 'https://r7k2t3x9.rocketcdn.me/wp-content/uploads/2021/12/taylor-swift-red-taylors-version-2021-featured-image.jpg', 'USER_ROLE', NULL, '0145010032', 0, '2022-11-18 14:50:19');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `voucher`
--

CREATE TABLE `voucher` (
  `idvoucher` varchar(255) NOT NULL,
  `discount` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `voucher`
--

INSERT INTO `voucher` (`idvoucher`, `discount`) VALUES
('vc1', '25%'),
('vc123', '10%'),
('vc2', '10%'),
('vc3', '10%'),
('vc4', '50%');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bookinghotel`
--
ALTER TABLE `bookinghotel`
  ADD PRIMARY KEY (`idbooking`);

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
  MODIFY `idfeedback` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1421501298;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
