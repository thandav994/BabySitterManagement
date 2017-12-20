DROP DATABASE if exists ooad;

CREATE DATABASE ooad;

use ooad;

create table if not exists login(
    user_id varchar(50) not null,
    pass varchar(50) not null,
    primary key(user_id)
)ENGINE= InnoDB DEFAULT CHARSET=utf8;

create table if not exists babysitters(
    sitterID integer not null auto_increment,
    firstName VARCHAR(50) DEFAULT NULL,
    lastName VARCHAR(50) DEFAULT NULL,
    emailID varchar(50) NOT NULL,
    gender VARCHAR(20) DEFAULT NULL,
    dateofbirth date DEFAULT NULL,
    ssn text not null,
    hourlypay integer not null,
    address text not null,
    zipcode int not null,
    phone bigint not null,
    experience float not null,
    bio text not null,
    rating int not null,
    primary key(sitterID),
    constraint fk_sitters foreign key(emailID) references login(user_id) on delete cascade on update restrict
)ENGINE= InnoDB DEFAULT CHARSET=utf8 ;


create table if not exists parents(
    parentID integer not null auto_increment,
    firstName VARCHAR(50) DEFAULT NULL,
    lastName VARCHAR(50) DEFAULT NULL,
    emailID varchar(50) NOT NULL,
    gender VARCHAR(20) DEFAULT NULL,
    dateofbirth date DEFAULT NULL,
    address text not null,
    phone bigint not null,
    zipcode int not null,
    special_requests text,
    primary key(parentID),
    constraint fk_parents foreign key(emailID) references login(user_id) on delete cascade on update restrict
)ENGINE= InnoDB DEFAULT CHARSET=utf8 ;



create table if not exists appointments(
    appointmentID integer not null auto_increment PRIMARY KEY,
    appointmentdate date DEFAULT NULL,
    appointmentstatus integer not null default 0,
paymentstatus integer not null default 0,
    sitterID integer references babysitters(sitterID) on delete cascade on update cascade,
    parentID integer references parents(parentID) on delete cascade on update cascade
)ENGINE= InnoDB DEFAULT CHARSET=utf8 ;

create table if not exists reviews(
	reviewID integer not null auto_increment PRIMARY KEY,
	sitterID integer references babysitters(sitterID) on delete cascade on update cascade,
	parentID integer references parents(parentID) on delete cascade on update cascade,
	rating integer
)ENGINE= InnoDB DEFAULT CHARSET=utf8 ;
