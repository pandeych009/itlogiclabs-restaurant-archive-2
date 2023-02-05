package com.itlogiclab.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itlogiclab.order.mapper.OrderDetailsMapper;
import com.itlogiclab.order.modal.OrderModal;

@Service
public class OrderService {
	
private static Logger logger = LogManager.getLogger(OrderService.class);
	
	@Autowired
	private OrderDetailsMapper populator; 

	
	/**
	 * @param modal
	 * @return
	 */
	public OrderModal add(OrderModal modal) {
		logger.debug("Start Execution of New Order Creation:");
		OrderModal persistedRecord = null; 
		if(Objects.isNull(modal.getOrderId()) || modal.getOrderId() == 0){
			logger.debug("New Order Creation is process");
			long random = ThreadLocalRandom.current().nextLong(1, 100);
			modal.setOrderId(random);
			logger.debug("Dummy: Random id generated as : "+random);
			persistedRecord = modal;
		}
		
		return persistedRecord;
	}
	
	/**
	 * @param modal
	 * @return
	 */
	public OrderModal update(final OrderModal modal) {
		logger.debug("Start Execution of update Order:");
		logger.debug("Order update is in process");
		long random = ThreadLocalRandom.current().nextLong(1, 100);
		modal.setOrderId(random);
		OrderModal persistedRecord = modal; 
		return persistedRecord;
	}
	
	public List<OrderModal> get(){
		logger.debug("Start Execution of getAll Order:");
		List<OrderModal> modals = new ArrayList<OrderModal>();
		for(int index=0;index < 10;index++) {
			modals.add(populator.populateOrderModal(ThreadLocalRandom.current().nextLong(index+1)));
		}
		return modals; 
	}


	public OrderModal get(Long id){
		logger.debug("Start Execution of get Order by orderId: {} :", id);
		return populator.populateOrderModal(id);
	}
	

}