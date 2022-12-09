create database ass_2_03;

-- Q1-a:
create table movie(
`movie_name` nvarchar(50) primary key,
duration int check(duration >= 1),
genre enum('Action', 'Adventure', 'Comedy', 'Crime', 'Dramas', 'Horror', 'Musical', 'War'),
director nvarchar(50),
amount_of_money int
);

-- Q1-b:
create table actor(
`actor_name` nvarchar(50) primary key,
age int,
average_movie_salary double,
nationality nvarchar(20)
);

-- Q1-c:
create table actedln(
`movie_name` nvarchar(50),
foreign key (`movie_name`) references movie(`movie_name`),
`actor_name` nvarchar(50),
foreign key (`actor_name`) references actor(`actor_name`),
primary key(`movie_name`, `actor_name`)
);

-- Q2-a:
alter table movie
add image_link varchar(20) unique;

-- Q2-b:
insert into movie values
('Avengers', 3, 'Action', 'Kevin', 1000,'4'),
('Iron Man', 2, 'Action', 'Kevin', 2000, '5'),
('Spiderman', 2, 'Action', 'John', 2000, '6'),
('Batman', 2, 'Action', 'John', 5000, '1'),
('She-Hulk', 10, 'Action', 'Kevin', 3000, '2'),
('MoonKnight', 12, 'Action', 'Kevin', 7000, '3');

update movie
set director = 'David' where `movie_name` = 'BatMan';

insert into actor values
('Tom Cuise', 57, 500000, 'New York'),
('Tom Holland', 27, 300000, 'Wasinton DC'),
('Gal Galdot', 30, 500000, 'Paris'),
('Elizabeth Olse', 32, 600000, 'New York'),
('Johasson', 40, 100000, 'New York');

insert into actedln values
('Avengers', 'Tom Holland'),
('Iron Man', 'Tom Cuise'),
('Iron Man', 'Gal Galdot'),
('Spiderman', 'Tom Holland'),
('Avengers', 'Elizabeth Olse'),
('Avengers', 'Johasson');

-- Q3-c:
select * from actor where age > 50;

-- Q3-d:
select actor.`actor_name`, actor.average_movie_salary from actor order by average_movie_salary desc;
select actor.`actor_name`, actor.average_movie_salary from actor order by average_movie_salary asc;

-- Q4-e:
select * from actedln where `actor_name` = 'Tom Holland';

-- Q5-f:
select movie.`movie_name` from movie inner join actedln on movie.movie_name = actedln.movie_name 
where movie.genre = 'Action' group by actedln.`movie_name` having count(actedln.`movie_name`) >= 3;


