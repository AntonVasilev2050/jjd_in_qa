create user 'testuser'@'localhost' identified by 'testuser';
grant all privileges on * . * to testuser@testuser;

create database test_db;
use test_db;

CREATE TABLE test_db.users (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(25),
  user_password varchar(25),
  primary key (id));
  
  CREATE TABLE test_db.messages (
  id int NOT NULL AUTO_INCREMENT,
  message varchar (300),
  username_id int,
  primary key (id),
  foreign key(username_id) references test_db.users(id) on delete cascade
  );
	INSERT INTO test_db.users (username, user_password)
VALUES
	('Sergey', 'Sergey'),
    ('Tania', 'Tania'),
    ('John', 'John'),
    ('Kate', 'Kate');
    
	INSERT INTO test_db.messages (message, username_id)
VALUES
    ('This is the first test message', 2),
    ('This is the second test message', 1),
    ('This is the third test message', 1),
    ('This is the fourth test message', 1),
    ('This is the fifth test message', 3),
    ('This is the sixth test message', 4);