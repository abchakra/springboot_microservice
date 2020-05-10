## Run MySQL Docker container

docker run --name=mysql --env="MYSQL_ROOT_PASSWORD=pwd" --publish 3306:3306 -v /home/chakraborty/web/spring/mysql_temp:/var/lib/mysql mysql:5.7

## Connect to Docker Container

docker exec -it mysql mysql -uuser -p

## Create mysql user with previlage

GRANT ALL PRIVILEGES ON _._ TO 'user'@'localhost' IDENTIFIED BY 'password';

OR

GRANT ALL PRIVILEGES ON _._ TO 'user'@'172.17.0.1' IDENTIFIED BY 'password';

### Create new Database

CREATE DATABASE `user_db`;

## database name should contain underscore '\_' instead of hyphen '-'

## Show current user

select user(), current_user();
