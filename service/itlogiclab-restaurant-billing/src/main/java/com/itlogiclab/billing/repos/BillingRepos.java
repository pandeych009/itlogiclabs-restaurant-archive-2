package com.itlogiclab.billing.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itlogiclab.billing.entity.BillEntity;

@Repository
public interface BillingRepos extends CrudRepository<BillEntity, Long> {

}
