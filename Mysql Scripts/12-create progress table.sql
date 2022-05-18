USE dbcoachapp;
DROP TABLE IF EXISTS progress;

CREATE TABLE progress
(
	id int not null auto_increment,
    coachform_id int not null,
    action_plan varchar(1000),
    progress_update varchar(1000) not null,
    
	`creation_date` datetime default current_timestamp,
    `modified_date` datetime default current_timestamp
					on update current_timestamp,

    PRIMARY KEY(id),
    FOREIGN KEY(coachform_id) references coachform(id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
    
)

