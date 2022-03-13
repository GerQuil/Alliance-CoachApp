DROP USER IF exists 'fourth'@'localhost';
flush PRIVILEGES;

CREATE USER 'fourth'@'localhost' 
IDENTIFIED BY 'passFourth_04';
GRANT All Privileges ON *.* TO 'fourth'@'localhost';
flush PRIVILEGES;
#
# # This is just for the localhost, we can change the password and @'localhost' to 
# # @'ip_address'
#