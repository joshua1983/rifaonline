# Run Docker mysql

docker run -d --name mysql_rifa \
  -v ./data:/var/lib/mysql \
  -e MYSQL_ROOT_PASSWORD=123456 \
  -e MYSQL_DATABASE=rifaonline \
  -e MYSQL_USER=rifaonline \
  -e MYSQL_PASSWORD=rifa \
  -p 3306:3306 \
  mysql:latest