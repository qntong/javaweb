/*
 Navicat Premium Data Transfer

 Source Server         : qntong
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : student_system

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 11/06/2020 12:12:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for choose_course
-- ----------------------------
DROP TABLE IF EXISTS `choose_course`;
CREATE TABLE `choose_course`  (
  `s_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `course_id` int(11) NULL DEFAULT NULL,
  `course_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `teacher` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `course_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of choose_course
-- ----------------------------
INSERT INTO `choose_course` VALUES ('201812170113', 101, '高等数学上', '赵依依', '专业课');
INSERT INTO `choose_course` VALUES ('201812170113', 102, '形式与政策', '王明', '公共课');
INSERT INTO `choose_course` VALUES ('201812170113', 103, '数据结构', '李丽', '专业课');
INSERT INTO `choose_course` VALUES ('201812170113', 104, '计算机组成原理', '孙浩', '专业课');
INSERT INTO `choose_course` VALUES ('201812170113', 105, '大学英语', '李苗', '公共课');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int(11) NOT NULL COMMENT '课程号',
  `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `course_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (101, '高等数学上', '赵依依', '专业课');
INSERT INTO `course` VALUES (102, '形势与政策', '王明', '公共课');
INSERT INTO `course` VALUES (103, '数据结构', '李丽', '专业课');
INSERT INTO `course` VALUES (104, '计算机组成原理', '孙浩', '专业课');
INSERT INTO `course` VALUES (105, '大学英语', '李苗', '公共课');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `s_class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `s_number` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学号',
  `s_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `score` int(5) NULL DEFAULT NULL,
  `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('大数据一班', '201812170101', '张倩', '高等数学上', 91, '赵依依');
INSERT INTO `grade` VALUES ('大数据一班', '201812170101', '张倩', '高等数学上', 91, '赵依依');
INSERT INTO `grade` VALUES ('云计算一班', '201812170124', '谢大海', '形式与政策', 86, '王明');
INSERT INTO `grade` VALUES ('云计算二班', '201812170235', '孙子涵', '数据结构', 87, '李丽');
INSERT INTO `grade` VALUES ('移动互联一班', '201812170102', '孙杰', '计算机组成原理', 93, '孙浩');
INSERT INTO `grade` VALUES ('大数据一班', '201812170135', '王子久', '大学英语', 79, '李苗');
INSERT INTO `grade` VALUES ('大数据一班', '201812170101', '张倩', '数据结构', 82, '李丽');
INSERT INTO `grade` VALUES ('大数据一班', '201812170101', '张倩', '大学英语', 85, '李苗');
INSERT INTO `grade` VALUES ('云计算二班', '201812170235', '孙子涵', '计算机组成原理', 76, '孙浩');
INSERT INTO `grade` VALUES ('大数据一班', '201812170126', '李亮', '高等数学上', 95, '赵依依');
INSERT INTO `grade` VALUES ('18大数据', '201812170113', '秦念彤', '高等数学上', 90, '赵依依');
INSERT INTO `grade` VALUES ('18大数据', '201812170113', '秦念彤', '计算机组成原理', 95, '孙浩');
INSERT INTO `grade` VALUES ('18大数据', '201812170113', '秦念彤', '形式与政策', 86, '王明');
INSERT INTO `grade` VALUES ('18大数据', '201812170113', '秦念彤', '数据结构', 87, '李丽');
INSERT INTO `grade` VALUES ('18大数据', '201812170113', '秦念彤', '大学英语', 79, '李苗');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user`  (
  `s_number` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学号',
  `s_password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `s_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pwd_safe` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密保',
  `age` int(11) NULL DEFAULT NULL,
  `s_class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '班级',
  `s_sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `s_birthday` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `s_enrol_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '入学时间',
  `s_telephone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `s_home_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `s_ranking` int(11) NULL DEFAULT NULL COMMENT '本学期排名',
  `s_competition` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参加的竞赛',
  `s_honor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所得奖项',
  `s_family_situation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '家庭情况',
  `head_teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '班主任',
  `instructor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '辅导员',
  `tutor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '指导老师',
  `internship` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实习情况',
  PRIMARY KEY (`s_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('201812170107', '123456', '孔德泓', '111111', NULL, '18大数据', '女', '2000-05-27', '2018-09-07', '13663755928', '山东省济宁市曲阜市', 20, '无', '无', '普通家庭', '徐丽', '张志强', '马兴晓', NULL);
INSERT INTO `s_user` VALUES ('201812170113', '1', '秦念彤', '111111', 12, '18大数据', '男', '2020-06-11', '2018-09-07', '13563755582', '山东省济宁市金乡县', 22, '发现杯', 'xxxx', 'xxx', '徐丽', '张志强', '马兴晓', 'vvvvvvvvv');
INSERT INTO `s_user` VALUES ('201812170124', '123456', ' 谢大海', '111111', NULL, '云计算一班', '男', '2000-10-11', '2018-09-07', '15963755782', '山东省枣庄市市中区', 11, '达内杯', '三等奖', '普通家庭', '谢菲', '王明', '马兴晓', NULL);
INSERT INTO `s_user` VALUES ('201812170135', '123456', ' 赵宁', '111111', NULL, '18大数据', '女', '2001-02-28', '2018-09-07', '19861371140', '山东省聊城市东阿县', 5, '无', '无', '单亲家庭', '徐丽', '张志强', '马兴晓', NULL);
INSERT INTO `s_user` VALUES ('201812170235', '123456', ' 孙子涵', '111111', NULL, '云计算二班', '女', '2000-06-08', '2018-09-07', '13563755782', '山东省济南市市中区', 2, '无', '无', '普通家庭', '王海', '李丽', '马兴晓', NULL);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `t_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '职工号',
  `t_password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `t_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `t_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师职称',
  `t_duty` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教师职务',
  `pwd_safe` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密保',
  PRIMARY KEY (`t_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('201812170113', '123', '小明', NULL, NULL, '111111');
INSERT INTO `t_user` VALUES ('221', '123456', '赵依依', '讲师', '班主任', '111111');
INSERT INTO `t_user` VALUES ('223', '123456', '王明', '助教', '处级干部', '111111');
INSERT INTO `t_user` VALUES ('224', '123456', '马兴晓', '讲师', '指导老师', '111111');
INSERT INTO `t_user` VALUES ('225', '123456', '张志强', '讲师', '辅导员', '111111');
INSERT INTO `t_user` VALUES ('226', '123456', '李丽', '教授', '辅导员', '111111');

SET FOREIGN_KEY_CHECKS = 1;
