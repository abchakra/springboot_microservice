## Run MySQL Docker container

docker run --name=mysql --env="MYSQL_ROOT_PASSWORD=pwd" --publish 3306:3306 --volume /home/chakraborty/web/spring/mysql_temp mysql:5.7

## Create mysql user with previlage

GRANT ALL PRIVILEGES ON _._ TO 'user'@'localhost' IDENTIFIED BY 'password';

OR

GRANT ALL PRIVILEGES ON _._ TO 'user'@'172.17.0.1' IDENTIFIED BY 'password';

### Create new Database

CREATE DATABASE `user-db`;
