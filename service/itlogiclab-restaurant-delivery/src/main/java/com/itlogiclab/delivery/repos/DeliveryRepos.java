package com.itlogiclab.delivery.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itlogiclab.delivery.entity.DeliveryEntity;

@Repository
public interface DeliveryRepos extends CrudRepository<DeliveryEntity, Long>{

}
