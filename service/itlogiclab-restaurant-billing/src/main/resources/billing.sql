
CREATE DATABASE IF NOT EXISTS billdb;
USE billdb;
CREATE TABLE bill_info (
	bill_info_id BIGINT NOT NULL, 
	charge_cost FLOAT, 
	charge_name VARCHAR(255), 
	invoice_no BIGINT NOT NULL, PRIMARY KEY (bill_info_id)) engine=InnoDB;

	
CREATE TABLE billing (
	bill_id BIGINT NOT NULL, 
	bill_amt FLOAT, 
	cust_id BIGINT, 
	create_date VARCHAR(255), 
	invoice_no VARCHAR(255), 
	order_id BIGINT, 
	status VARCHAR(255), PRIMARY KEY (bill_id)) engine=InnoDB;

CREATE TABLE hibernate_sequence (next_val BIGINT) engine=InnoDB;

INSERT INTO hibernate_sequence values ( 1 );

ALTER TABLE bill_info ADD CONSTRAINT BILL_INFO_FK FOREIGN KEY (invoice_no) REFERENCES billing (bill_id);