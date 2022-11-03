package com.itlogiclab.billing.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itlogiclab.billing.entity.BillEntity;
import com.itlogiclab.billing.modal.BillModal;
import com.itlogiclab.billing.repos.BillingRepos;
import com.itlogiclab.billing.utils.MapperUtils;

@Service
public class BillingService {

	@Autowired
	private BillingRepos repos;
	
	@Autowired
	private MapperUtils utils;
	
	
	public BillModal add(final BillModal modal) {
		if(modal.getBillId() == 0 ) {
			BillEntity entity = utils.populateBillEntity(modal);
			BillEntity persistedEntity = repos.save(entity);
			BillModal persistedModal = utils.populateModal(persistedEntity);
			return persistedModal;
		}else {
			return update(modal);
		}
	}
	
	
	public BillModal update(final BillModal modal) {
		BillEntity persistedEntity = repos.findById(modal.getBillId()).orElseThrow(RuntimeException::new);
		utils.mapBillEntity(persistedEntity, modal);
		
		BillEntity persistedUpdatedEntity = repos.save(persistedEntity);
		return utils.populateModal(persistedUpdatedEntity);
	}
	
	
	public List<BillModal> get() {
		List<BillModal> modals = StreamSupport.stream(repos.findAll().spliterator(), false).map(input -> utils.populateModal(input)).collect(Collectors.toList());
		return modals;
	}
	
	public BillModal get(long id) {
		BillEntity entity = repos.findById(id).orElseThrow(RuntimeException::new);
		BillModal modals = utils.populateModal(entity); 
		return modals;
	}
	
}
