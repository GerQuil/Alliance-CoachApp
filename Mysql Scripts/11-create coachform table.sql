USE dbcoachapp;
DROP TABLE IF EXISTS coachform;
CREATE TABLE coachform
(
	id int NOT NULL AUTO_INCREMENT,
    trainee int,
    trainee_position varchar(255),
    coach int,
    coaching_topic varchar(500),
    desired_outcome varchar(1000),
    benefits_of_change varchar(1000),
    action_plan varchar(1000),
    timeline varchar(1000),
    
    `creation_date` datetime default current_timestamp,
    `modified_date` datetime default current_timestamp
					on update current_timestamp,

    PRIMARY KEY(id),
    
    FOREIGN KEY (trainee) REFERENCES user(id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    
    FOREIGN KEY (coach) REFERENCES user(id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
    
    
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;