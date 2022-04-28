drop table if exists reimbursment;
drop table if exists ers_user;

create table if not exists ers_user (
	user_id SERIAL primary key,
	username VARCHAR(255),
	password VARCHAR(255),
	enabled boolean,
	role VARCHAR(100),
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	gender VARCHAR(50),
	email VARCHAR(255) ,
	phone_number VARCHAR(255),
	address VARCHAR(300),
	creation_date timestamp

);


create table if not exists reimbursement (
	reimb_id SERIAL primary key,
	reimb_amount decimal(8,2),
	reimb_type VARCHAR(50),
	reim_creation_date timestamp,
	reimb_description VARCHAR(255),
	reimb_status VARCHAR(255),
	reimb_approval_reason VARCHAR(255),
	reim_approval_date timestamp
	
);

