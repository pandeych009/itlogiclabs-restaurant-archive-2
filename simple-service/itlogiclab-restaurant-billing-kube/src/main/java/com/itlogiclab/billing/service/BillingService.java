package com.itlogiclab.billing.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itlogiclab.billing.modal.BillModal;
import com.itlogiclab.billing.utils.MapperUtils;

@Service
public class BillingService {
	private static Logger logger = LogManager.getLogger(BillingService.class);
	
	@Autowired
	private MapperUtils utils;
	
	
	public BillModal add(final BillModal modal) {
		logger.debug("billingL: add bill in service");
		if(modal.getBillId() == 0 ) {
			BillModal persistedModal = utils.populateModal();
			return persistedModal;
		}else {
			return update(modal);
		}
	}
	
	
	public BillModal update(final BillModal modal) {
		//BillEntity entity = utils.populateBillEntity(modal);
		return utils.populateModal();
	}
	
	
	public List<BillModal> getBills() {
		//List<BillModal> modals = StreamSupport.stream(repos.findAll().spliterator(), false).map(input -> utils.populateModal(input)).collect(Collectors.toList());
		List<BillModal> modals = new ArrayList<BillModal>();
		modals.add(utils.populateModal());
		return modals;
	}
	
	public BillModal get(long billId) {
		BillModal modals = utils.populateModal(); 
		return modals;
	}
	
}
