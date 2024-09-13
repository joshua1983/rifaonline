# Run Docker mysql

docker run -d --name mysql \
  -v /path/to/data:/var/lib/mysql \
  -e MYSQL_ROOT_PASSWORD=my_root_password \
  -e MYSQL_DATABASE=my_database \
  -e MYSQL_USER=my_user \
  -e MYSQL_PASSWORD=my_password \
  -p 3306:3306 \
  mysql:latest