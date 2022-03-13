USE dbcoachapp;
DROP TABLE IF EXISTS user;
CREATE TABLE user
(
	id int NOT NULL AUTO_INCREMENT,
    first_name varchar(77) DEFAULT NULL,
    last_name varchar(77) NOT NULL,
    username varchar(77) UNIQUE NOT NULL,
    `role` varchar(22) NOT NULL,
    email varchar(77) UNIQUE NOT NULL,
    phone_number varchar(13),
    `password` varchar(77) NOT NULL,
    
    
    `creation_date` datetime default current_timestamp,
    `modified_date` datetime default current_timestamp
					on update current_timestamp,

    PRIMARY KEY(id)
    
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;