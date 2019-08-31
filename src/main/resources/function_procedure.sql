-- 0 建表

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `class_id` int(11) NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

INSERT INTO `t_user` VALUES (1, 'yang', 3, 2);
INSERT INTO `t_user` VALUES (2, 'yang2', 4, 7);

SET FOREIGN_KEY_CHECKS = 1;

-- ============================================================================

-- 1 函数定义
delimiter $$
DROP FUNCTION IF EXISTS `f_test`;
CREATE FUNCTION `f_test` ( id INT ) RETURNS INT
BEGIN
	DECLARE
		`result` INT;
	SELECT
		COUNT(*) INTO `result`
	FROM
		t_user AS t
	WHERE
		t.id > id;
	RETURN `result`;
END $$
delimiter;

-- 1.1 函数测试
SELECT f_test ( 0 ) AS `userCount`;

-- ============================================================================

-- 2 过程定义，当有多个返回值时，每个OUT变量的赋值需要一条独立的语句
DELIMITER $$
DROP PROCEDURE IF EXISTS `p_test`;
CREATE PROCEDURE `p_test` ( IN id INT, OUT classId INT, OUT age INT )
BEGIN
	SELECT
		t.class_id INTO classId
	FROM
		t_user AS t
	WHERE
		t.id = id;

	SELECT
		t.age INTO age
	FROM
		t_user AS t
	WHERE
		t.id = id;
END $$
DELIMITER;

-- 2.1过程调用
CALL p_test (1, @class, @age);
SELECT @class AS class, @age AS age FROM DUAL;


