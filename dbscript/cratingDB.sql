-- create database mydb
CREATE DATABASE mydb;
USE mydb;
-- create table  EMPLOYEE;
CREATE  TABLE `mydb`.`EMPLOYEE` (
  `name` VARCHAR(20) NOT NULL ,
  `id` INT NOT NULL ,
  PRIMARY KEY (`id`) );
-- inserted two records
INSERT INTO `mydb`.`employee` (`name`, `id`) VALUES ('kc', 2);
INSERT INTO `mydb`.`employee` (`name`, `id`) VALUES ('ram',3);
--
