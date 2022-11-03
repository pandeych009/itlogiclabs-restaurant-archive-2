
create table bill_info (bill_info_id bigint not null, charge_cost float, charge_name varchar(255), invoice_no bigint not null, primary key (bill_info_id)) engine=InnoDB
create table billing (bill_id bigint not null, bill_amt float, cust_id bigint, date varchar(255), invoice_no varchar(255), order_id bigint, status varchar(255), primary key (bill_id)) engine=InnoDB
create table hibernate_sequence (next_val bigint) engine=InnoDB
insert into hibernate_sequence values ( 1 )
alter table bill_info add constraint FKcat5dqwpeiioko60jt5xq2hac foreign key (invoice_no) references billing (bill_id)