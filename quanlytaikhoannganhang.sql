-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.28-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for qltknh
CREATE DATABASE IF NOT EXISTS `qltknh` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `qltknh`;

-- Dumping structure for table qltknh.giaodich
CREATE TABLE IF NOT EXISTS `giaodich` (
  `magiaodich` varchar(50) NOT NULL,
  `sotien` double DEFAULT 0,
  `thoigiangiaodich` datetime DEFAULT NULL,
  `taikhoangiaodich` varchar(50) DEFAULT NULL,
  `taikhoannhan` varchar(50) DEFAULT NULL,
  `loaigiaodich` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`magiaodich`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table qltknh.giaodich: ~16 rows (approximately)
INSERT INTO `giaodich` (`magiaodich`, `sotien`, `thoigiangiaodich`, `taikhoangiaodich`, `taikhoannhan`, `loaigiaodich`) VALUES
	('Chuyenkhoan025587', 200000, '2023-04-27 15:50:47', '211212181', '211213440', 'Chuyển khoản'),
	('Chuyenkhoan616717', 10000, '2023-04-27 12:59:29', '211212181', '211213440', 'Chuyển khoản'),
	('Chuyenkhoan863226', 40000, '2023-04-27 13:05:13', '21125635653', '211212181', 'Chuyển khoản'),
	('napien006156', 100000, '2023-04-27 15:45:08', '211213440', 'null', 'Nạp Tiền'),
	('napien606947', 200000, '2023-04-27 15:50:47', '211213440', 'null', 'Nạp Tiền'),
	('napien859658', 10000, '2023-04-27 12:59:29', '211213440', 'null', 'Nạp Tiền'),
	('napien937234', 40000, '2023-04-27 13:05:13', '211212181', 'null', 'Nạp Tiền'),
	('napien972505', 20000, '2023-04-27 13:04:35', '211212181', 'null', 'Nạp Tiền'),
	('napTien019719', 10000000, '2023-04-27 13:01:36', '2136754855', 'null', 'Nạp Tiền Vay Vốn'),
	('napTien411340', 100000, '2023-04-27 15:46:22', '091233613', 'null', 'Nạp Tiền Tiết Kiệm'),
	('napTien809808', 1000000, '2023-04-27 13:02:46', '2151532683', 'null', 'Nạp Tiền Tiết Kiệm'),
	('rutien613561', 10000, '2023-04-27 15:45:52', '21545545451', 'null', 'Rút tiền'),
	('rutien710987', 20300, '2023-04-27 13:04:46', '21545545451', 'null', 'Rút tiền'),
	('rutTien383581', 50000, '2023-04-27 13:02:59', '2151532683', 'null', 'Rút Tiền Tiết Kiệm'),
	('rutTien477556', 150000, '2023-04-27 13:01:49', '2136754855', 'null', 'Rút Tiền Vay Vốn'),
	('tinhtienlai487521', 27, '2023-04-27 13:02:14', '2136754855', 'null', 'Tính tiền lãi');

-- Dumping structure for table qltknh.nguoidung
CREATE TABLE IF NOT EXISTS `nguoidung` (
  `cccd` varchar(50) NOT NULL,
  `tennguoidung` varchar(50) DEFAULT NULL,
  `sdt` varchar(50) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `taikhoan` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`cccd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table qltknh.nguoidung: ~8 rows (approximately)
INSERT INTO `nguoidung` (`cccd`, `tennguoidung`, `sdt`, `ngaysinh`, `taikhoan`) VALUES
	('34534634634', 'Việt', '03353535345', '2009-04-09', '2112495356'),
	('3645254454', 'Tráng Tạ', '0645564564', '2002-09-06', '211213446'),
	('54564545648', 'Việt Tạ', '0385698595', '2003-11-11', '211213440'),
	('55566699988', 'Dũng Nguyễn', '0392171658', '2003-04-01', '211212181'),
	('56323254323', 'Hạnh Chi', '0685235325', '1993-11-17', '211212183'),
	('585464546', 'Dũng Phạm', '015688987', '2002-04-06', '211218563'),
	('854456458563', 'Hạo Lam', '095626256', '1975-04-30', '211212185'),
	('85646546531', 'Mạnh Nam', '0123544562', '1994-04-14', '211212184');

-- Dumping structure for table qltknh.taikhoanthanhtoan
CREATE TABLE IF NOT EXISTS `taikhoanthanhtoan` (
  `sotaikhoan` varchar(50) NOT NULL,
  `tentaikhoan` varchar(50) NOT NULL,
  `sodutaikhoan` double DEFAULT NULL,
  PRIMARY KEY (`sotaikhoan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table qltknh.taikhoanthanhtoan: ~5 rows (approximately)
INSERT INTO `taikhoanthanhtoan` (`sotaikhoan`, `tentaikhoan`, `sodutaikhoan`) VALUES
	('0842101103', 'vietta', 100000),
	('211212181', 'Dung0501', 77000),
	('211213440', 'viet1011', 461045),
	('21125635653', 'Dung1', 59000),
	('21545545451', 'Dung2', 167700);

-- Dumping structure for table qltknh.taikhoantietkiem
CREATE TABLE IF NOT EXISTS `taikhoantietkiem` (
  `sotaikhoan` varchar(50) NOT NULL,
  `tentaikhoan` varchar(50) NOT NULL,
  `sodutaikhoan` double DEFAULT NULL,
  `ngaygui` date DEFAULT NULL,
  `laisuattietkiem` double DEFAULT NULL,
  PRIMARY KEY (`sotaikhoan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table qltknh.taikhoantietkiem: ~2 rows (approximately)
INSERT INTO `taikhoantietkiem` (`sotaikhoan`, `tentaikhoan`, `sodutaikhoan`, `ngaygui`, `laisuattietkiem`) VALUES
	('091233613', 'vietta', 200000, '2023-04-05', 6),
	('2151532683', 'Viet4', 1949000, '2021-04-03', 6);

-- Dumping structure for table qltknh.taikhoanvayvon
CREATE TABLE IF NOT EXISTS `taikhoanvayvon` (
  `sotaikhoan` varchar(50) NOT NULL,
  `tentaikhoan` varchar(50) NOT NULL,
  `sodutaikhoan` double DEFAULT 0,
  `sotienvay` double DEFAULT 0,
  `sotienlai` double DEFAULT 0,
  `ngayvay` date DEFAULT NULL,
  PRIMARY KEY (`sotaikhoan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table qltknh.taikhoanvayvon: ~2 rows (approximately)
INSERT INTO `taikhoanvayvon` (`sotaikhoan`, `tentaikhoan`, `sodutaikhoan`, `sotienvay`, `sotienlai`, `ngayvay`) VALUES
	('0927236234', 'viettt', 100000, 1000000, 0, '2023-04-01'),
	('2136754855', 'TrangDo1', 9858973, 100000, 27, '2023-04-14');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
