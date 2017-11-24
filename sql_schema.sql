use ooad;

create table login(
	user_id varchar(50) not null,
    pass varchar(50) not null,
    primary key(user_id)
)ENGINE= InnoDB DEFAULT CHARSET=utf8;


create table babysitters(
	sitterID integer not null auto_increment,
    firstName VARCHAR(50) DEFAULT NULL,
    lastName VARCHAR(50) DEFAULT NULL,
    gender VARCHAR(20) DEFAULT NULL,
    dateofbirth date DEFAULT NULL,
    emailID varchar(50) NOT NULL,
    primary key(sitterID),
    constraint fk foreign key(emailID) references login(user_id) on delete cascade on update restrict
)ENGINE= InnoDB DEFAULT CHARSET=utf8;

create table parents(
	parentID integer not null auto_increment,
    firstName VARCHAR(50) DEFAULT NULL,
    lastName VARCHAR(50) DEFAULT NULL,
    gender VARCHAR(20) DEFAULT NULL,
    dateofbirth date DEFAULT NULL,
    emailID varchar(50) NOT NULL,
    primary key(parentID),
    constraint fk_parents foreign key(emailID) references login(user_id) on delete cascade on update restrict
)ENGINE= InnoDB DEFAULT CHARSET=utf8;

create table appointments(
	id integer not null auto_increment primary key,
    date DATE not null,
    status integer not null DEFAULT 0,
    sitterID integer REFERENCES babysitters(sitterID) on delete cascade on update cascade,
	parentID integer REFERENCES parents(parentID) on delete cascade on update cascade
)ENGINE= InnoDB DEFAULT CHARSET=utf8;
	