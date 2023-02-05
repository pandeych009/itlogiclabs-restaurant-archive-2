package com.itlogiclab.order.repos;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.itlogiclab.order.entity.OrderEntity;


@Repository
public interface OrderRepos extends CrudRepository<OrderEntity, Long>{

	
}
