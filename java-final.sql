-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 17, 2022 lúc 10:12 AM
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
('LyrbUXfi', '02331792', 'phuquoc', 'pq-hotel-2', 'pq-hotel-2-room-1', '11-23-2022', '11-25-2022', 2, 1, 1, '2700000', 'Đã trả phòng', '2022-11-21 04:21:53', 'Mỹ  Tâm', '0120120123', 'vanhuy1619@gmail.com', 0),
('AC7wvkbb', '03883343', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-5', '11-23-2022', '11-26-2022', 3, 0, 1, '18000000', 'Đã trả phòng', '2022-11-20 09:20:38', 'Nguyễn Văn Huy', '0123456789', 'mvmanh@gmail.com', 1),
('Vyg5mSbD', '08974524', 'phuquoc', 'pq-hotel-3', 'pq-hotel-3-room-2', '11-22-2022', '11-24-2022', 4, 4, 2, '31644000', 'Đã trả phòng', '2022-11-21 04:27:57', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 0),
('LyrbUXfi', '09337502', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', '11-22-2022', '11-24-2022', 2, 0, 1, '5600000', 'Đã trả phòng', '2022-11-21 03:37:12', 'Mỹ  Tâm', '0169111021', 'vanhuy1619@gmail.com', 1),
('jGkBN5C7', '12333191', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-2', '12-22-2022', '12-24-2022', 2, 1, 1, '5400000', 'Hủy', '2022-12-17 08:24:01', 'Phạm Văn Huy', '0547898789', 'kwonjiyong2702@gmail.com', 0),
('AC7wvkbb', '12710344', 'dalat', 'dl-hotel-7', 'dl-hotel-7-room-1', '12-21-2022', '12-22-2022', 2, 0, 1, '1600000', 'Hủy', '2022-12-16 22:11:19', 'Nguyễn Bảo Anh', '0659787888', 'mvmanh@gmail.com', 0),
('Vyg5mSbD', '13143307', 'phuquoc', 'pq-hotel-3', 'pq-hotel-3-room-1', '11-23-2022', '11-26-2022', 8, 8, 1, '33000000', 'Đã trả phòng', '2022-11-21 04:25:36', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 0),
('Vyg5mSbD', '13473243', 'quynhon', 'qn-hotel-4', 'qn-hotel-4-room-1', '12-21-2022', '12-24-2022', 4, 2, 1, '8550000', 'Chờ xác nhận', '2022-12-17 09:04:27', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 0),
('AC7wvkbb', '15598052', 'dalat', 'dl-hotel-7', 'dl-hotel-7-room-1', '12-21-2022', '12-22-2022', 2, 0, 1, '1800000', 'Đã trả phòng', '2022-12-16 22:12:26', 'Nguyễn Bảo Anh', '0659787888', 'mvmanh@gmail.com', 0),
('jGkBN5C7', '17541051', 'phuquoc', 'pq-hotel-3', 'pq-hotel-3-room-1', '12-22-2022', '12-24-2022', 2, 0, 1, '9920000', 'Hủy', '2022-12-17 07:18:48', 'Phạm Văn Huy', '0547898789', 'kwonjiyong2702@gmail.com', 0),
('AC7wvkbb', '22441748', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', '12-16-2022', '12-17-2022', 2, 0, 1, '2800000', 'Hủy', '2022-12-15 08:53:42', 'Nguyễn Bảo Anh', '0659787888', 'mvmanh@gmail.com', 0),
('AC7wvkbb', '25122588', 'phuquoc', 'pq-hotel-2', 'pq-hotel-2-room-2', '12-11-2022', '12-13-2022', 2, 1, 1, '3000000', 'Thành công', '2022-12-11 04:03:17', 'Nguyễn Bảo Anh', '0659787888', 'mvmanh@gmail.com', 0),
('jGkBN5C7', '32588263', 'phuquoc', 'pq-hotel-2', 'pq-hotel-2-room-1', '12-22-2022', '12-24-2022', 3, 1, 1, '6300000', 'Hủy', '2022-12-17 07:13:04', 'Nguyễn Văn Huy', '0547898788', 'kwonjiyong2702@gmail.com', 0),
('AC7wvkbb', '34096274', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-4', '11-22-2022', '11-23-2022', 2, 0, 1, '4000000', 'Đã trả phòng', '2022-11-20 18:29:48', 'Anh Khoa', '0123456789', 'akhoa@gmail.com', 0),
('jGkBN5C7', '41200765', 'quynhon', 'qn-hotel-2', 'qn-hotel-2-room-1', '12-23-2022', '12-24-2022', 2, 0, 1, '1024000', 'Đã trả phòng', '2022-12-17 08:28:40', 'Nguyễn Văn Huy', '0547898789', 'kwonjiyong2702@gmail.com', 1),
('jGkBN5C7', '43927984', 'quynhon', 'qn-hotel-4', 'qn-hotel-4-room-2', '12-22-2022', '12-23-2022', 3, 2, 1, '4000000', 'Đã xác nhận', '2022-12-16 20:49:08', 'Nguyễn Văn Huy', '0547898788', 'kwonjiyong2702@gmail.com', 0),
('Vyg5mSbD', '47226249', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', '11-23-2022', '11-25-2022', 2, 0, 2, '11200000', 'Đã trả phòng', '2022-11-21 04:13:16', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 1),
('Vyg5mSbD', '49858221', 'phuquoc', 'pq-hotel-2', 'pq-hotel-2-room-1', '11-22-2022', '11-24-2022', 2, 1, 2, '6000000', 'Đã trả phòng', '2022-11-21 03:23:08', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 1),
('AC7wvkbb', '51124468', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-6', '11-22-2022', '11-26-2022', 4, 0, 1, '12900000', 'Đã xác nhận', '2022-11-20 04:53:38', 'Nguyễn Văn Huy', '0123456789', 'mvmanh@gmail.com', 0),
('LyrbUXfi', '52729983', 'phuquoc', 'pq-hotel-3', 'pq-hotel-3-room-2', '11-29-2022', '11-30-2022', 4, 4, 1, '8790000', 'Đã trả phòng', '2022-11-26 12:01:51', 'Mỹ  Tâm', '0120120123', 'vanhuy1619@gmail.com', 0),
('AC7wvkbb', '54462416', 'dalat', 'dl-hotel-6', 'dl-hotel-6-room-1', '12-21-2022', '12-22-2022', 2, 1, 2, '5600000', 'Thành công', '2022-12-16 17:52:54', 'Nguyễn Bảo Anh', '0659787888', 'baoanh@gmail.com', 0),
('AC7wvkbb', '58384150', 'dalat', 'dl-hotel-1', 'dl-hotel-1-room-2', '11-25-2022', '11-26-2022', 4, 0, 1, '700000', 'Đã trả phòng', '2022-11-24 10:06:17', 'Nguyễn Văn Huy', '0123456789', 'mvmanh@gmail.com', 1),
('Vyg5mSbD', '74358981', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-3', '11-23-2022', '11-26-2022', 2, 0, 2, '15000000', 'Đã trả phòng', '2022-11-21 03:23:57', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 1),
('Vyg5mSbD', '85798539', 'quynhon', 'qn-hotel-3', 'qn-hotel-3-room-2', '12-22-2022', '12-24-2022', 3, 1, 1, '30000000', 'Chờ xác nhận', '2022-12-17 09:00:44', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 0),
('Vyg5mSbD', '92498834', 'phuquoc', 'pq-hotel-2', 'pq-hotel-2-room-1', '12-21-2022', '12-22-2022', 3, 1, 1, '3500000', 'Chờ xác nhận', '2022-12-17 09:00:05', 'Hồ Quỳnh Hương', '0929046031', 'khoanguyen30lb@gmail.com', 0),
('AC7wvkbb', '93866325', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', '12-12-2022', '12-14-2022', 2, 0, 1, '5600000', 'Chờ xác nhận', '2022-12-14 11:09:44', 'Nguyễn Bảo Anh', '0659787888', 'mvmanh@gmail.com', 0),
('jGkBN5C7', '97085059', 'dalat', 'dl-hotel-2', 'dl-hotel-2-room-1', '12-20-2022', '12-22-2022', 2, 2, 1, '3280000', 'Đã trả phòng', '2022-12-16 18:03:56', 'Nguyễn Văn Huy', '0547898788', 'kwonjiyong2702@gmail.com', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `buyservice`
--

CREATE TABLE `buyservice` (
  `stt` int(255) NOT NULL,
  `iduser` varchar(255) NOT NULL,
  `idbooking` varchar(255) NOT NULL,
  `stt_service` varchar(255) NOT NULL,
  `dongia` varchar(255) NOT NULL,
  `soluong` int(255) NOT NULL,
  `thanhtien` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `buyservice`
--

INSERT INTO `buyservice` (`stt`, `iduser`, `idbooking`, `stt_service`, `dongia`, `soluong`, `thanhtien`, `name`, `img`) VALUES
(1, 'Vyg5mSbD', '49858221', 'pr-1', '50000', 1, '50000', 'Trà', 'https://phuclong.com.vn/uploads/dish/16fcacd357eb7c-tren500gphclong.png'),
(2, 'Vyg5mSbD', '49858221', '2', '1000000', 1, '1000000', 'Buffet', 'http://vinpearllandphuquoc.com/wp-content/uploads/2019/10/Salinda-Restaurant-8-Phu-Quoc.jpg'),
(10, 'Vyg5mSbD', '08974524', '4', '800000', 1, '800000', 'Vinwonder', 'https://btnmt.1cdn.vn/2020/06/01/a4_toan-canh.jpg'),
(11, 'Vyg5mSbD', '08974524', 'pr-2', '100000', 1, '100000', 'Coffee', 'https://salt.tikicdn.com/cache/w1200/ts/product/ee/fc/48/4f0279f8e024537b8be2bde55353dc77.jpg'),
(24, 'jGkBN5C7', '48422009', '5', '800000', 1, '800000', 'Thủy cung', 'https://static.vinwonders.com/2022/07/cung-dien-hai-vuong-07.jpg'),
(25, 'AC7wvkbb', '34096274', '2', '1000000', 1, '1000000', 'Buffet', 'http://vinpearllandphuquoc.com/wp-content/uploads/2019/10/Salinda-Restaurant-8-Phu-Quoc.jpg'),
(26, 'AC7wvkbb', '34096274', '3', '3000000', 1, '3000000', 'Golf', 'http://datphongresort.com/wp-content/uploads/2020/10/6-1.jpg'),
(29, 'Vyg5mSbD', '49858221', '7', '600000', 1, '600000', 'Công viên Vinpearl Safari', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670774191/ydudoqkcqvwlroe4newz.jpg'),
(30, 'LyrbUXfi', '52729983', '7', '600000', 1, '600000', 'Công viên Vinpearl Safari', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670774191/ydudoqkcqvwlroe4newz.jpg'),
(31, 'LyrbUXfi', '09337502', '8', '1100000', 1, '1100000', 'Lặn biển', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670778793/afg80q6bcmqrxbpdogn7.jpg'),
(33, 'AC7wvkbb', '03883343', 'pr-2', '100000', 1, '100000', 'Coffee', 'https://salt.tikicdn.com/cache/w1200/ts/product/ee/fc/48/4f0279f8e024537b8be2bde55353dc77.jpg'),
(35, 'Vyg5mSbD', '13143307', '4', '800000', 1, '800000', 'Vinwonder', 'https://btnmt.1cdn.vn/2020/06/01/a4_toan-canh.jpg'),
(39, 'Vyg5mSbD', '13143307', '2', '1000000', 1, '1000000', 'Buffet', 'http://vinpearllandphuquoc.com/wp-content/uploads/2019/10/Salinda-Restaurant-8-Phu-Quoc.jpg'),
(46, 'jGkBN5C7', '97085059', '8', '1100000', 1, '1100000', 'Lặn biển', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670778793/afg80q6bcmqrxbpdogn7.jpg'),
(47, 'LyrbUXfi', '02331792', '4', '800000', 1, '800000', 'Vinwonder', 'https://btnmt.1cdn.vn/2020/06/01/a4_toan-canh.jpg'),
(49, 'AC7wvkbb', '15598052', '1', '5000000', 1, '5000000', 'Nướng ngoài trời', 'http://vietnamtravelmarthcm.com/wp-content/uploads/2020/09/vinpearl-resort-spa-phu-quoc_vietnamtravelmarthcm_04.jpg'),
(50, 'jGkBN5C7', '41200765', '8', '1100000', 1, '1100000', 'Lặn biển', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670778793/afg80q6bcmqrxbpdogn7.jpg');

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
('kt000001', 'Noo Phước Thịnh', '0369874521', 'noophuocthinh@gmail.com', 'Male', 'Kế toán', '123456', '2022-12-09 01:20:49', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670523648/seyqh9xmddmjuhmwhnjo.jpg'),
('lt000001', 'Minh Hằng', '0965874238', 'vanhuy1619@gmail.com', 'Female', 'Lễ tân', '123456', '2022-12-07 23:29:37', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670430575/cpazfbbm1nzywd9byrua.jpg'),
('ql000003', 'Đông Nhi', '0965874231', 'toctien@gmail.com', 'Female', 'Quản lý', '123456', '2022-08-03 13:56:37', 'https://scontent.fsgn9-1.fna.fbcdn.net/v/t1.6435-9/198152502_502686704273682_104451209091447411_n.jpg?stp=c0.169.827.827a_dst-jpg_s851x315&_nc_cat=104&ccb=1-7&_nc_sid=da31f3&_nc_ohc=VJllLKZA-VEAX-hwsNz&tn=KWoGFGK0B3e-EmZW&_nc_ht=scontent.fsgn9-1.fna&oh=00_AfBTilLK4pHvrIn_U4Pg0mc89jlM9uStnSD-agJP_Vt1Ng&oe=63B27E06'),
('ql000004', 'Hồ Ngọc Hà', '0125478544', 'hongoccha@gmail.com', 'Female', 'Quản lý', '123456', '2022-12-10 10:21:24', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670642484/umymd9y0p72mmpxmgstp.jpg');

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
(1421501295, '74358981', 'Vyg5mSbD', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-3', 4, 'Vin Oasis là resort 5 sao cạnh Grand World & có Waterpark nội khu. Mọi thứ đều rất ổn, tụi nhỏ nhà mình rất thích. Phần xe chung chuyển giữa Vin Oasis và Grand thì không đc order có ngay mà phải căn giờ đi, về cách nhau cả tiếng đồng hồ mỗi chuyến nên hơi bất tiện.', '2022-11-21 03:28:17'),
(1421501296, '49858221', 'Vyg5mSbD', 'phuquoc', 'pq-hotel-2', 'pq-hotel-2-room-1', 5, 'Trải nghiệm tốt. Mua vé Klook rẻ và tiện. nhưng cần hỗ trợ gấp thì khó liên hệ Gần Vinoasis có nhiều điểm tham quan, phục vụ tận tình, sạch sẽ', '2022-11-21 03:28:47'),
(1421501297, '09337502', 'LyrbUXfi', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', 5, 'Dịch vụ đẳng cấp, đáng tiền nhất, nhân viên chăm sóc khách hàng của Klook hỗ trợ nhiệt tình khi xảy ra sự cố, sẽ ủng hộ Klook cho những đơn hàng kế tiếp', '2022-11-21 03:38:59'),
(1421501298, '47226249', 'Vyg5mSbD', 'phuquoc', 'pq-hotel-1', 'pq-hotel-1-room-1', 5, 'Khách sạn rất đẹp', '2022-11-21 04:28:23'),
(1421501299, '58384150', 'AC7wvkbb', 'dalat', 'dl-hotel-1', 'dl-hotel-1-room-2', 5, 'Nhân viên khách sạn rất nhiệt tình, khách sạn đẹp gần trung tâm dễ dàng di chuyển', '2022-11-24 10:08:39'),
(1421501301, '52729983', 'LyrbUXfi', 'phuquoc', 'pq-hotel-3', 'pq-hotel-3-room-2', 5, 'An amazing hotel in its beauty, looks like heaven. Beautiful and clean rooms in every private pool, excellent gym, huge pool that is softer on the beach. A private beach and stunning in its beauty, it is impossible to put into words how beautiful the beach is coconut trees and clear water the hotel staff very services. Protecting the environment Using paper requests. There is an electric vehicle service available to transport you anytime, anywhere. In addition, a free airport shuttle service to the city. A rich dining room and a variety of hotel staff will prepare you to eat anything you request. In conclusion if you are looking for heaven this is exactly the place !!!', '2022-11-26 12:16:21'),
(1421501307, '97085059', 'jGkBN5C7', 'dalat', 'dl-hotel-2', 'dl-hotel-2-room-1', 4, 'Một điểm trừ nho nhỏ là vì vị trí khách sạn ở chợ nhưng ban ngày hơi ồn do tiếng xe chạy. Tuy nhiên là khách sạn sử dụng kính chống ồn nên không ảnh hưởng gì nhiều đến sự nghỉ ngơi của khách hàng.', '2022-12-16 18:07:03'),
(1421501308, '41200765', 'jGkBN5C7', 'quynhon', 'qn-hotel-2', 'qn-hotel-2-room-1', 4, 'Khách sạn rất tốt', '2022-12-17 08:48:05');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giftforuser`
--

CREATE TABLE `giftforuser` (
  `stt` int(255) NOT NULL,
  `idgift` varchar(255) DEFAULT NULL,
  `noidunggift` varchar(255) DEFAULT NULL,
  `hansudung` date DEFAULT NULL,
  `foriduser` varchar(255) DEFAULT NULL,
  `sudung` int(11) DEFAULT 0,
  `giatri` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `giftforuser`
--

INSERT INTO `giftforuser` (`stt`, `idgift`, `noidunggift`, `hansudung`, `foriduser`, `sudung`, `giatri`) VALUES
(1, 'xmashappy', 'Giáng sinh vui vẻ', '2022-12-23', 'AC7wvkbb', 0, '20%'),
(3, 'happynewyear', 'Chúc mừng năm mới', '2022-12-18', 'AC7wvkbb', 1, '15%'),
(4, 'TCBTRAGOP', 'Tặng bạn bữa ăn sáng buffet', '2022-12-24', 'Vyg5mSbD', 0, '25%'),
(7, 'happybirthday', 'Chúc mừng sinh nhật bạn', '2022-12-25', 'jGkBN5C7', 1, '15%'),
(14, 'khmayman', 'Khách hàng may mắn', '2022-12-18', 'LyrbUXfi', 0, '20%'),
(25, 'happynewyear', 'Dành cho bạn', '2022-12-25', 'jGkBN5C7', 1, '20%'),
(26, 'happybirthday', 'Chúc mừng sinh nhật bạn', '2022-12-24', 'LyrbUXfi', 1, '10%');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `messagebycustomer`
--

CREATE TABLE `messagebycustomer` (
  `stt` int(255) NOT NULL,
  `iduser` varchar(255) NOT NULL,
  `message` varchar(1000) NOT NULL,
  `rep` int(255) DEFAULT 0,
  `datesend` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `messagebycustomer`
--

INSERT INTO `messagebycustomer` (`stt`, `iduser`, `message`, `rep`, `datesend`) VALUES
(1, 'jGkBN5C7', 'Phú Quốc đi thời gian nào là đẹp nhất? Tôi rất thích khách sạn Vinpearl nhưng hơi xa sân bay. Khách sạn có dịch vụ đưa đón khách tại sân bay không? 🥳', 0, '2022-12-11 00:28:15'),
(2, 'Vyg5mSbD', 'Tôi muốn hỏi chính sách phụ thu với trẻ em!', 1, '2022-12-11 00:29:21'),
(3, 'PwzpbJqx', 'Giá phòng gồm ăn sáng nhưng nếu mình không ăn thì có được giảm giá hay trả lại tiền không?', 0, '2022-12-11 00:42:43'),
(4, 'LyrbUXfi', 'Đặt vé máy bay, khách sạn, vé tham quan & giải trí trên trang web traveloka.com có gì khác so với ứng dụng Traveloka trên điện thoại?', 1, '2022-12-11 00:44:44'),
(5, 'LyrbUXfi', 'Sau khi đặt dịch vụ mất bao lâu tôi mới nhận voucher của mình? · Làm sao để tôi huỷ đơn hàng và nhận hoàn tiền?\n', 0, '2022-12-11 21:58:09'),
(6, 'jGkBN5C7', 'Tôi có thể đặt thay cho gia đình và bạn bè của mình được không?', 0, '2022-12-11 21:59:45'),
(7, 'AC7wvkbb', 'Làm sao để tôi thêm/xoá khách đi trong đơn hàng của tôi?', 1, '2022-12-11 22:00:35'),
(11, 'LyrbUXfi', 'Bên em có đặt phòng cho khách đoàn và có chính sách ưu đãi đặc biệt gì cho khách đoàn không?😉', 0, '2022-12-12 15:57:42'),
(12, 'Vyg5mSbD', 'Anh đặt phòng bên em rồi nhưng khi đến khách sạn không có phòng thì sao?', 1, '2022-12-12 16:04:30'),
(13, 'LyrbUXfi', 'Làm sao để biết tôi đặt phòng thành công?', 0, '2022-12-12 20:54:19'),
(14, 'LyrbUXfi', 'Tôi có thể tìm voucher ở đâu?', 1, '2022-12-13 22:31:36'),
(98, 'jGkBN5C7', 'Tôi muốn hỏi về quy đặt phòng?😅', 1, '2022-12-17 14:15:18'),
(99, 'jGkBN5C7', 'Tôi muốn hỏi quy trình đặt phòng😆', 1, '2022-12-17 15:20:50');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `sttproduct` varchar(255) NOT NULL,
  `nameproduct` varchar(255) NOT NULL,
  `priceduct` varchar(255) NOT NULL,
  `imgproduct` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`sttproduct`, `nameproduct`, `priceduct`, `imgproduct`) VALUES
('pr-1', 'Trà', '50000', 'https://phuclong.com.vn/uploads/dish/16fcacd357eb7c-tren500gphclong.png'),
('pr-2', 'Coffee', '100000', 'https://salt.tikicdn.com/cache/w1200/ts/product/ee/fc/48/4f0279f8e024537b8be2bde55353dc77.jpg'),
('pr-3', 'Bia', '50000', 'http://hanoimoi.com.vn/Uploads/anhthu/2019/6/8/Twitter.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `repmessage`
--

CREATE TABLE `repmessage` (
  `stt` int(255) NOT NULL,
  `sttmessagesend` int(255) NOT NULL,
  `repcontent` varchar(1000) DEFAULT NULL,
  `daterep` datetime DEFAULT current_timestamp(),
  `userread` int(255) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `repmessage`
--

INSERT INTO `repmessage` (`stt`, `sttmessagesend`, `repcontent`, `daterep`, `userread`) VALUES
(12, 4, 'Nếu sử dụng các dịch vụ của Traveloka trên ứng dụng thì tụi mình hay nói với nhau là cả hành trình nằm trong lòng bàn tay bạn nhờ vào tiện ích My Booking (Đặt chỗ của tôi) trong ứng dụng Traveloka. Từ đó, bạn có thể quản lý hành trình một cách dễ dàng.\n\nNgoài ra, trên màn hình chính của ứng dụng còn đưa ra các gợi ý thiết yếu theo từng thời điểm: các khách sạn, chuyến bay nhiều ưu đãi trong tháng, các hoạt động tham quan và giải trí hot nhất, các chương trình khuyến mãi hiện hành hoặc nếu để tìm cảm hứng du lịch thì các bài viết hoặc video của Traveloka trong mục Vi vu khắp chốn hoặc Cung đường cảm hứng sẽ cung cấp những gì bạn cần.\nNếu vẫn chưa cài đặt ứng dụng Traveloka thì bạn hãy tải ngay để qua vòng gửi xe nhé! ', '2022-12-11 04:55:50', 0),
(13, 2, 'Chào bạn!\n\nTùy thuộc vào mỗi khách sạn, thường thì trẻ dưới 6 tuổi sẽ không tính phụ thu.\n\nBạn nên kiểm tra kĩ điều này trước khi đặt phòng để tránh những trường hợp không hay nhé!\n\nBạn có thể gọi điện thoại trực tiếp đến Hotline 24/7: (08) 3930 8290 để được nhân viên của iVIVU.com tư vấn kỹ hơn các vấn đề về đặt phòng khách sạn trực tuyến.', '2022-12-11 04:57:08', 0),
(14, 7, '**Để thêm khách tham gia **\n\nRất tiếc, bạn không thể thêm khách tham gia sau khi đơn hàng đã được xác nhận.\n\nNếu dịch vụ có thể hoàn và vẫn trong giai đoạn có thể huỷ miễn phí, bạn có thể huỷ đơn hàng và đặt lại. Xin kiểm tra chính sách hoàn huỷ của dịch vụ trước bạn nhé!\n\nĐể xoá khách tham gia\n\nNếu dịch vụ có thể hoàn và vẫn trong giai đoạn có thể huỷ miễn phí, bạn có thể thay đổi đơn hàng của mình và yêu cầu huỷ một phần cho khách không muốn tiếp tham gia và cần được xoá. Xin kiểm tra chính sách hoàn huỷ của dịch vụ trước bạn nhé!\n\nNếu dịch vụ có thể hoàn và vẫn trong giai đoạn có thể huỷ miễn phí, nhưng bạn không thể huỷ, xin liên hệ với nhóm chăm sóc khách hàng của Klook.', '2022-12-11 22:02:39', 0),
(15, 12, 'Chào anh!\n\nThật đáng tiếc nếu điều này xảy ra! Bộ phận Chăm sóc Khách hàng của iVIVU.com sẽ luôn hỗ trợ anh trong mọi trường hợp, anh có thể gọi điện thoại trực tiếp đến Hotline 24/7: (08) 3930 8290 để được nhân viên của iVIVU.com giúp đỡ. Chúng tôi sẽ yêu cầu khách sạn cung cấp phòng ngay. Nếu cần thiết, chúng tôi sẽ đặt phòng chất lượng tương đương ở chính khách sạn đó hoặc một khách sạn khác, đảm bảo chuyến đi của anh không bị gián đoạn.\n\nCảm ơn anh!', '2022-12-12 16:06:53', 0),
(18, 14, 'Hệ thống sẽ tự động gửi mã voucher cho quý khách hàng.', '2022-12-13 23:01:08', 0),
(22, 98, 'Chào bạn!', '2022-12-17 14:16:16', 0),
(23, 99, 'Bạn có thể xem tại link...', '2022-12-17 15:21:55', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `service`
--

CREATE TABLE `service` (
  `stt` int(11) NOT NULL,
  `name_service` varchar(255) DEFAULT NULL,
  `price` varchar(255) NOT NULL,
  `amount` int(255) NOT NULL,
  `img_service` varchar(1000) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `status` varchar(255) DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `service`
--

INSERT INTO `service` (`stt`, `name_service`, `price`, `amount`, `img_service`, `description`, `status`) VALUES
(1, 'Nướng ngoài trời', '5000000', 180, 'http://vietnamtravelmarthcm.com/wp-content/uploads/2020/09/vinpearl-resort-spa-phu-quoc_vietnamtravelmarthcm_04.jpg', 'Tại Vinpearl Hội An Resort & Villas mùa này, kỳ nghỉ sẽ trọn vẹn hơn với hương vị tuyệt hảo của tiệc nướng BBQ bên bãi biển hoặc ngay trong khu villa. \nGiữa không gian thoáng đãng mát lành, tiệc nướng với các món hải sản phong phú và đa dạng, thơm lừng dậy vị, được chế biến từ những công thức chọn lọc là trải nghiệm thú vị bạn không nên bỏ qua.', 'Active'),
(2, 'Buffet', '1000000', 200, 'http://vinpearllandphuquoc.com/wp-content/uploads/2019/10/Salinda-Restaurant-8-Phu-Quoc.jpg', 'Nhà hàng Taras thuộc khuôn viên của Vinpearl Discovery 1 Phú Quốc với diện tích rộng đến 1.375m2. Đến đây, bạn sẽ không ngừng trầm trồ bởi phong cách kiến trúc độc đáo và tinh tế đến từng chi tiết. Không chỉ cầu kỳ trong phong cách kiến trúc mà các món ăn ở đây cũng được đầu bếp bày biện trang trí vô cùng đẹp mắt. Mỗi món ăn bày lên như một tác phẩm nghệ thuật vừa đẹp mắt, vừa ngon miệng.', 'Active'),
(3, 'Golf', '3000000', 120, 'http://datphongresort.com/wp-content/uploads/2020/10/6-1.jpg', 'Được xây dựng trên đảo Hòn Tre – đảo lớn nhất nằm trong vịnh Nha Trang, Vinpearl Golf Nha Trang là hệ thống sân golf nghỉ dưỡng, đẳng cấp hàng đầu Việt Nam và trong khu vực Đông Nam Á. Tại đây, các du khách được phục vụ tận tình, trải nghiệm dịch vụ phong phú, đa dạng trong mô hình quần thể vui chơi, giải trí, nghỉ dưỡng “All-in-one” của Vinpearl.', 'Active'),
(4, 'Vinwonder', '800000', 150, 'https://btnmt.1cdn.vn/2020/06/01/a4_toan-canh.jpg', 'Công viên chủ đề là khái niệm chẳng còn mấy xa lạ đối với du khách Việt Nam; và Phú Quốc cũng không ngoại lệ. Đến với VinWonders Phú Quốc, bạn có thể tìm thấy những giây phút “vỡ oà cảm xúc” cùng vô số hoạt động vui chơi - giải trí - chinh phục cảm giác mạnh đến các trải nghiệm ăn uống đậm đà hương sắc bản địa. Chẳng còn nghi ngờ gì nữa! VinWonders Phú Quốc xứng danh là một trong những công viên chủ đề hàng đầu Việt Nam. Vậy có gì chơi ở VinWonders Phú Quốc? Làm thế nào để tận hưởng lịch trình một ngày tại khu du lịch đầy sức hút này? Hãy cùng Klook Vietnam khám phá cẩm nang du lịch VinWonders Phú Quốc trong bài viết này nhé.', 'Active'),
(5, 'Thủy cung', '800000', 110, 'https://static.vinwonders.com/2022/07/cung-dien-hai-vuong-07.jpg', 'Đến với thủy cung Vinpearl Phú Quốc, bạn sẽ được khám phá một thế giới lung linh sắc màu với show diễn nàng tiên cá độc đáo - nơi bạn được chiêm ngưỡng các nàng tiên cá xinh đẹp bước ra từ cổ tích. Đó là những cô gái xinh đẹp biết bơi lội biểu diễn dưới nước trong trang phục tiên cá nhiều màu sắc. Chắc chắn các bạn bé con sẽ đặc biệt thích tiết mục này. ', 'Active'),
(6, 'Spa', '1800000', 300, 'http://datphongvinpearl.vn/wp-content/uploads/2020/09/vp_spa-02.jpg\r\n', 'Là thương hiệu hàng đầu về spa và chăm sóc sức khỏe, sắc đẹp đẳng cấp 5 sao, Akoya Spa Nha Trang sở hữu phong cách và các liệu trình trị liệu độc đáo bắt nguồn từ Bali, Indonesia.', 'Active'),
(7, 'Công viên Vinpearl Safari', '600000', 150, 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670774191/ydudoqkcqvwlroe4newz.jpg', 'Vin Safari là khu vườn thú bán hoang dã. Với nhiều loại động vật: ngựa vằn, hươu cao cổ, cọp… Đến với Safari trẻ nhỏ và người lớn được xem các tiết mục biểu diễn của động vật, cho động vật ăn, ngồi trên 01 chiếc xe chuyên dụng lồng kính xuyên qua khu rừng nuôi động vật thả hoang chụp ảnh và tìm hiểu về từng loại động vật tại đây.', 'Active'),
(8, 'Lặn biển', '1100000', 100, 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670778793/afg80q6bcmqrxbpdogn7.jpg', 'Ở dưới độ cao gần chục mét ấn tượng đầu tiên khi tham gia trò chơi này chính là cảm giác được thỏa sức vũng vẫy dưới làn nước vô cùng trong xanh, mát mẻ. Càng lặn xuống sâu, du khách càng có cơ hội vén bức màn bí mật của đại dương bao la, tuyệt đẹp.  Lặn giữa làn nước trong xanh, mát rượi, xung quanh là những rặn san hô đủ màu sắc, du khách sẽ có cơ hội được chiêm ngưỡng hệ sinh thái vô cùng ấn tượng. Thêm vào đó, với sự hỗ trợ từ các dụng cụ lặn biển, bạn sẽ hoàn toàn yên tâm khám phá dưới đáy đại dương với khoảng thời gian cho phép', 'Active'),
(10, 'Thưởng thức âm nhạc ngoài trời', '400000', 300, 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670782004/jz5luqpa5h7f3v2n1om8.jpg', 'Lắng nghe những bản nhạc du dương tại Mây Lang Thang Đà Lạt là một trải nghiệm được nhiều bạn trẻ và các du khách yêu thích. Những đêm nhạc với các bản tình ca lãng mạn, sâu lắng kết hợp với sự bình yên của Đà Lạt đã làm xao xuyến biết bao con tim mang đến nhiều cảm xúc khó quên cho du khách. Đây là một trong những trải nghiệm, bạn nên một lần thử khi đến Đà Lạt. Hãy cùng Go2Joy, tìm hiểu điều này qua các thông tin sau.', 'Active'),
(11, 'Gói Wedding tại Vinpearl Resort & Spa Phú Quốc', '1100000', 80, 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670814835/zjkwdi5kuozdj9g3ezno.webp', 'Tiệc cưới thân mật ấm cúng, hay một kỳ nghỉ tân hôn “trọn gói” hoàn hảo từ hôn lễ cho đến trăng mật, trao lời thề ước giữa thiên nhiên khoáng đạt... chính là những xu hướng cưới thời thượng được các cô dâu, chú rể yêu thích, lựa chọn tại các resort biển đẳng cấp của Vinpearl.', 'Active'),
(12, 'Bãi biển vô cực', '500000', 100, 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1671261674/jtth4ttvxyozhbrej7oc.jpg', 'Bãi biển vô cực', 'Deleted'),
(13, 'Bãi biển vô cực', '500000', 50, 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1671265888/ilvzlgxoqc1h3pvfklj4.jpg', 'Bãi Biển', 'Deleted');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `totalbill`
--

CREATE TABLE `totalbill` (
  `stt` int(255) NOT NULL,
  `iduser` varchar(255) NOT NULL,
  `idbooking` varchar(255) NOT NULL,
  `totalpricebill` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `totalbill`
--

INSERT INTO `totalbill` (`stt`, `iduser`, `idbooking`, `totalpricebill`, `status`) VALUES
(1, 'Vyg5mSbD', '08974524', '32544000', 'Đã thanh toán'),
(2, 'AC7wvkbb', '34096274', '11000000', 'Đã thanh toán'),
(3, 'LyrbUXfi', '52729983', '9390000', 'Đã thanh toán'),
(4, 'AC7wvkbb', '03883343', '18000000', 'Đã thanh toán'),
(5, 'LyrbUXfi', '09337502', '6700000', 'Đã thanh toán'),
(6, 'Vyg5mSbD', '47226249', '11200000', 'Đã thanh toán'),
(7, 'Vyg5mSbD', '74358981', '15000000', 'Đã thanh toán'),
(8, 'AC7wvkbb', '58384150', '700000', 'Đã thanh toán'),
(9, 'Vyg5mSbD', '49858221', '7650000', 'Đã thanh toán'),
(10, 'Vyg5mSbD', '13143307', '34800000', 'Đã thanh toán'),
(15, 'jGkBN5C7', '97085059', '4380000', 'Đã thanh toán'),
(16, 'LyrbUXfi', '02331792', '3500000', 'Đã thanh toán'),
(17, 'AC7wvkbb', '15598052', '6800000', 'Đã thanh toán'),
(18, 'jGkBN5C7', '41200765', '2124000', 'Đã thanh toán');

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
  `creact_account` datetime DEFAULT current_timestamp(),
  `status` varchar(255) DEFAULT 'Active',
  `level` varchar(255) DEFAULT 'Khách hàng thường'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`iduser`, `ho`, `ten`, `email`, `password`, `avatar`, `role`, `gender`, `phone`, `point`, `creact_account`, `status`, `level`) VALUES
('AC7wvkbb', 'Nguyễn', 'Bảo Anh', 'mvmanh@gmail.com', '123456', 'https://media.glamour.com/photos/6377a1e555f8e14c67143e19/master/pass/GettyImages-1406473123.jpg', 'USER_ROLE', 'Male', '0659787888', 56, '2022-11-14 20:38:00', 'Vô hiệu', 'Khách VIP'),
('jGkBN5C7', 'Nguyễn', 'Văn Huy', 'kwonjiyong2702@gmail.com', '1234567', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1670427575/cunuwerwx6xwvajlljk2.jpg', 'USER_ROLE', 'Female', '0547898789', 8, '2022-12-07 22:39:36', 'Vô hiệu', 'Khách hàng thường'),
('lIWdOY46', 'Mỹ Tâm', 'Băng Băng', 'kwonjiyongs2702@gmail.com', '111111', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1671175750/s7c3wjibaoqps9osa12h.png', 'USER_ROLE', 'Female', '0929099063', 0, '2022-12-16 14:29:11', 'Active', 'Khách hàng thường'),
('LyrbUXfi', 'Phạm', 'Băng Băng', 'vanhuy1619@gmail.com', '123', 'https://i.scdn.co/image/ab67616d0000b273a97c8b7dcb20c796540ffed2', 'USER_ROLE', 'Female', '0123456789', 30, '2022-11-21 10:36:42', 'Active', 'Khách hàng thường'),
('m2DF2Kab', 'Phạm', 'Văn Huy', 'kwonjifyong2702@gmail.com', '123456', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1671261074/urojmqmqdtkvhy51jjcb.png', 'USER_ROLE', NULL, '0982117541', 0, '2022-12-17 14:11:13', 'Active', 'Khách hàng thường'),
('PwzpbJqx', 'Triệu', 'Lệ Dĩnh', 'vipbigbang5xxx@gmail.com', '123', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1669460434/hagwjuj2ckkyh0bm1qwz.jpg', 'USER_ROLE', 'Female', '0659787878', 0, '2022-11-26 18:00:35', 'Active', 'Khách VIP'),
('t06kWpoU', 'Phạm', 'Văn Huy', 'kwonjiyongr2702@gmail.com', '123456', 'https://res.cloudinary.com/dnqk5fjla/image/upload/v1671265189/qqbkvcb1vin5hsftasp7.jpg', 'USER_ROLE', 'Male', '0929099066', 0, '2022-12-17 15:19:48', 'Active', 'Khách hàng thường'),
('Vyg5mSbD', 'Hồ', 'Quỳnh Hương', 'khoanguyen30lb@gmail.com', '123', 'https://kenh14cdn.com/thumb_w/660/203336854389633024/2022/9/29/5-16644449670421462690434.jpeg', 'USER_ROLE', 'Female', '0929046031', 121, '2022-11-21 10:14:59', 'Active', 'Khách VIP');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `voucher`
--

CREATE TABLE `voucher` (
  `idvoucher` varchar(255) NOT NULL,
  `discount` varchar(255) NOT NULL,
  `soluong` int(255) NOT NULL,
  `sudung` int(255) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `voucher`
--

INSERT INTO `voucher` (`idvoucher`, `discount`, `soluong`, `sudung`) VALUES
('aqaqaq', '20%', 80, 0),
('vc123', '20%', 30, 19),
('vc3', '10%', 15, 10),
('vc4', '50%', 15, 7);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bookinghotel`
--
ALTER TABLE `bookinghotel`
  ADD PRIMARY KEY (`idbooking`);

--
-- Chỉ mục cho bảng `buyservice`
--
ALTER TABLE `buyservice`
  ADD PRIMARY KEY (`stt`);

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
-- Chỉ mục cho bảng `giftforuser`
--
ALTER TABLE `giftforuser`
  ADD PRIMARY KEY (`stt`);

--
-- Chỉ mục cho bảng `messagebycustomer`
--
ALTER TABLE `messagebycustomer`
  ADD PRIMARY KEY (`stt`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`sttproduct`);

--
-- Chỉ mục cho bảng `repmessage`
--
ALTER TABLE `repmessage`
  ADD PRIMARY KEY (`stt`);

--
-- Chỉ mục cho bảng `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`stt`);

--
-- Chỉ mục cho bảng `totalbill`
--
ALTER TABLE `totalbill`
  ADD PRIMARY KEY (`stt`);

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
-- AUTO_INCREMENT cho bảng `buyservice`
--
ALTER TABLE `buyservice`
  MODIFY `stt` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT cho bảng `feedback`
--
ALTER TABLE `feedback`
  MODIFY `idfeedback` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1421501309;

--
-- AUTO_INCREMENT cho bảng `giftforuser`
--
ALTER TABLE `giftforuser`
  MODIFY `stt` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT cho bảng `messagebycustomer`
--
ALTER TABLE `messagebycustomer`
  MODIFY `stt` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

--
-- AUTO_INCREMENT cho bảng `repmessage`
--
ALTER TABLE `repmessage`
  MODIFY `stt` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `service`
--
ALTER TABLE `service`
  MODIFY `stt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `totalbill`
--
ALTER TABLE `totalbill`
  MODIFY `stt` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
