-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.30 - MySQL Community Server (GPL)
-- 服务器OS:                        Win32
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_example
CREATE DATABASE IF NOT EXISTS `db_example` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_example`;

-- Dumping structure for table db_example.grade
CREATE TABLE IF NOT EXISTS `grade` (
  `_num` int(11) unsigned COMMENT '学号',
  `_math` int(11) DEFAULT NULL COMMENT '数学成绩',
  `_date` date DEFAULT NULL COMMENT '日期'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='成绩表';

-- Dumping data for table db_example.grade: ~5 rows (大约)
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` (`_num`, `_math`, `_date`) VALUES
	(1, 21, '2020-11-26'),
	(2, 21, '2020-11-26'),
	(3, 25, '2020-11-26'),
	(3, 25, '2020-11-26'),
	(3, 25, '2020-11-26');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;

-- Dumping structure for table db_example.student
CREATE TABLE IF NOT EXISTS `student` (
  `_num` int(11) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `_year` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`_num`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='学生表';

-- Dumping data for table db_example.student: ~10 rows (大约)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`_num`, `_name`, `_year`) VALUES
	(1, 'gy', 18),
	(2, 'gy2', 18),
	(3, 'gy3', 18),
	(4, 'gy3', 18),
	(5, 'gy4', 19),
	(6, 'gy', 18),
	(7, 'gy2', 18),
	(8, 'gy3', 18),
	(9, 'gy3', 18),
	(10, 'gy4', 19);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping structure for table db_example.student_copy
CREATE TABLE IF NOT EXISTS `student_copy` (
  `_num` int(11) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `_year` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`_num`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC COMMENT='学生表';

-- Dumping data for table db_example.student_copy: ~0 rows (大约)
/*!40000 ALTER TABLE `student_copy` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_copy` ENABLE KEYS */;

-- Dumping structure for table db_example.user
CREATE TABLE IF NOT EXISTS `user` (
  `userId` int(50) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `age` varchar(5) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table db_example.user: ~11 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userId`, `userName`, `age`, `birthday`) VALUES
	(1, '1', '1', '0000-00-00'),
	(2, '1', '1', '0000-00-00'),
	(3, '1', '1', '0000-00-00'),
	(4, '1', '1', '0000-00-00'),
	(5, '1', '1', '0000-00-00'),
	(6, '1', '1', '0000-00-00'),
	(7, '1', '1', '0000-00-00'),
	(8, 'gy', '18', '2020-12-01'),
	(9, 'gy', '18', '2020-12-01'),
	(10, 'gy', '18', '2020-12-01'),
	(11, 'gy', '18', '2020-12-01');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
