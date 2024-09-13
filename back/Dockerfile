# Use the official MySQL image
FROM mysql:latest

# Set the environment variables
ENV MYSQL_ROOT_PASSWORD=123456
ENV MYSQL_DATABASE=rifaonline
ENV MYSQL_USER=rifaonline
ENV MYSQL_PASSWORD=rifa

# Expose the MySQL port
EXPOSE 3306

# Run the MySQL service
CMD ["mysqld_safe"]