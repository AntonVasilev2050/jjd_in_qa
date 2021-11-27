##### В БД создать пару sql табличек со связями (foreign keys)
````
Я использовал MySQL. Создаем testuser с паролем testuser. Создаем базу данных
test_db и в ней две таблицы. Заполняем таблицы начальными значениями:

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
Настройки подключения к БД прописываем в application.properties

Сделать HTTP POST эндпоинт который получает данные в json вида :
{
    name: "имя отправителя"
    password: "пароль" 
}
этот эндпоинт проверяет пароль по БД и создает jwt токен (срок действия токена и алгоритм подписи не принципиален, для генерации и работе с токеном можно использовать готовую библиотечку) в токен записывает данные: name: "имя отправителя" 
и отправляет токен в ответ, тоже json вида:
{
    token: "тут сгенерированный токен" 
}

Сервер слушает и отвечает в какой-нибудь эндпоинт в него на вход поступают данные в формате json:
Сообщения клиента-пользователя:
{
    name:       "имя отправителя",
    message:    "текст сообщение"
}
В заголовках указан Bearer токен (полученный из эндпоинта выше)
Проверить токен, в случае успешной проверки токена, полученное сообщение сохранить в БД.

Если пришло сообщение вида:
{
    name:       "имя отправителя",
    message:    "history 10"
}
проверить токен, в случае успешной проверки токена отправить отправителю 10 последних сообщений из БД

Добавить описание и инструкцию по запуску и комментарии в коде, если изменяете формат сообщений, то подробное описание ендпоинтов и их полей.


Это Spring Boot приложение, просто запускаете и все. 
Я использовал MySQL. В tables.sql скрипт для создания и начального заполнения таблиц.

Используем Postman чтобы получить токен
POST на:
http://localhost:8080/api/users/get-token
В body: 
{
    "userName": "Sergey",
    "password": "Sergey"   
}

Используем Postman чтобы записать сообщение в БД
POST на:
http://localhost:8080/api/users/message
В Authorization вставляем полученный ранее токен
В body:
{
  "userName": "Sergey",
  "message": "any message u wish to save in the database"
}

Завернуть все компоненты в докер
docker build -t jjd-19nov-2:latest ./
docker run -p 8080:8080 jjd-19nov-2:latest
