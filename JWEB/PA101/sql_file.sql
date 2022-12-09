create database pa101;

use pa101;

create table `member`(
id int auto_increment primary key,
firstname varchar(25),
lastname varchar(25),
username varchar(25),
`password` varchar(25),
phone varchar(20),
email varchar(25),
`description` varchar(225),
create_date datetime,
update_time datetime
);

create table content(
id int auto_increment primary key,
title varchar(50),
brief varchar(50),
content varchar(225),
create_date datetime,
update_time datetime,
sort varchar(20),
author_id int
);