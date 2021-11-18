CREATE TABLE my_db.users (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(25),
  password varchar(25),
  primary key (id));
  
  CREATE TABLE my_db.messages (
  id int NOT NULL AUTO_INCREMENT,
  message_text varchar (300),
  user_id int,
  primary key (id),
  foreign key(user_id) references my_db.users(id) on delete cascade
  );
	INSERT INTO my_db.users (username, password)
VALUES
	('Sergey', 'Sergey'),
    ('Tania', 'Tania'),
    ('John', 'John'),
    ('Kate', 'Kate');
    
	INSERT INTO my_db.messages (message_text, user_id)
VALUES
    ('This is the first test message', 2),
    ('This is the second test message', 1),
    ('This is the third test message', 1),
    ('This is the fourth test message', 1),
    ('This is the fifth test message', 3),
    ('This is the sixth test message', 4);