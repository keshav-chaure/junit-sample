CREATE DATABASE mydb;
USE mydb;
-- CREATE TABLE EMPLOYEE (name VARCHAR(20), id VARCHAR(20));
CREATE  TABLE `mydb`.`EMPLOYEE` (
  `name` VARCHAR(20) NOT NULL ,
  `id` INT NOT NULL ,
  PRIMARY KEY (`id`) );
INSERT INTO `mydb`.`employee` (`name`, `id`) VALUES ('kc', 2);