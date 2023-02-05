package com.itlogiclab.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itlogiclab.order.entity.OrderEntity;
import com.itlogiclab.order.mapper.OrderDetailsMapper;
import com.itlogiclab.order.modal.OrderModal;
import com.itlogiclab.order.repos.OrderRepos;

@Service
public class OrderService {
	
	private static Logger logger = LogManager.getLogger(OrderService.class);
	
	@Autowired
	private OrderRepos repos; 
	
	@Autowired
	private OrderDetailsMapper populator; 
	
	/**
	 * @param modal
	 * @return
	 */
	public OrderModal add(OrderModal modal) {
		logger.debug("Start Execution of New Order Creation:");
		OrderModal persistedRecord; 
		if(Objects.isNull(modal.getOrderId()) || modal.getOrderId() == 0){
			logger.debug("New Order Creation is process");
			OrderEntity order = populator.populateOrderEntity(modal);
			OrderEntity persistedOrder = repos.save(order);
			persistedRecord = populator.populateOrderModal(persistedOrder);
		}else persistedRecord = update(modal);
		
		return persistedRecord;
	}
	
	/**
	 * @param modal
	 * @return
	 */
	public OrderModal update(final OrderModal modal) {
		logger.debug("Start Execution of update Order:");
		
		logger.debug("Order update is in process");
		OrderEntity entity = repos.findById(modal.getOrderId()).orElseThrow(RuntimeException::new);  
		populator.populateOrderEntity(modal, entity);
		
		OrderEntity persistedOrder = repos.save(entity);
		OrderModal persistedRecord = populator.populateOrderModal(persistedOrder);
		
		return persistedRecord;
	}
	
	/**
	 * @return
	 */
	public List<OrderModal> get(){
		logger.debug("Start Execution of getAll Order:");
		List<OrderModal> modals = new ArrayList<OrderModal>();
		repos.findAll().forEach(input -> {
			modals.add(populator.populateOrderModal(input));
		});
		return modals; 
	}


	/**
	 * @param id
	 * @return
	 */
	public OrderModal get(Long id){
		logger.debug("Start Execution of get Order by orderId: {} :", id);
		OrderEntity input = repos.findById(id).orElseThrow(RuntimeException::new);
		return populator.populateOrderModal(input);
	}
	

}

