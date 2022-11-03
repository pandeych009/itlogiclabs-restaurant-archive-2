CREATE DATABASE IF NOT EXISTS deliverydb;
USE deliverydb;
CREATE TABLE delivery (delivery_id BIGINT NOT NULL, delivery_staus INTEGER, order_id BIGINT NOT NULL, PRIMARY KEY (delivery_id)) engine=InnoDB;
CREATE TABLE hibernate_sequence (next_val BIGINT) engine=InnoDB;
INSERT INTO hibernate_sequence VALUES ( 1 );
