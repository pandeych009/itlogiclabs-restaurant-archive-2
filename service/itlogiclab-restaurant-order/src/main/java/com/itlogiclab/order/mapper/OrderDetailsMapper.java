package com.itlogiclab.order.mapper;

import java.util.Calendar;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.itlogiclab.order.entity.AddressEntity;
import com.itlogiclab.order.entity.OrderEntity;
import com.itlogiclab.order.modal.Address;
import com.itlogiclab.order.modal.OrderModal;
import com.itlogiclab.order.utils.CommonUtils;

@Component
public class OrderDetailsMapper {
	private static Logger logger = LogManager.getLogger(OrderDetailsMapper.class); 
	
	
	public OrderEntity populateOrderEntity(OrderModal modal) {
		logger.debug("Populating Order Entity from modal");
		OrderEntity entity = new OrderEntity();
		populateOrderEntity(modal, entity);
		return entity; 
		
	}
	
	
	public void populateOrderEntity(OrderModal modal, OrderEntity entity) {
		logger.debug("Populating Order Entity from modal");
		
		AddressEntity address = entity.getDeliveryAddress();
		if(Objects.isNull(address)) {
			address = populateAddressEntity(modal.getDeliveryAddress());
			entity.setDeliveryAddress(address);
		}else {
			populateAddressEntity(modal.getDeliveryAddress(), address);
		}
		
		entity.setOrderDate(CommonUtils.getCurrentDate());
		entity.setOrderTime(CommonUtils.getCurrentTime());
		entity.setStatus(modal.getStatus());
		
	}
	
	
	public OrderModal populateOrderModal(OrderEntity orderEntity) {
		logger.debug("Populating Order Modal from Entity");
		
		OrderModal modal = new OrderModal();
		modal.setOrderId(orderEntity.getId());
		modal.setOrderDate(orderEntity.getOrderDate());
		modal.setOrderTime(orderEntity.getOrderTime());
		modal.setStatus(orderEntity.getStatus());
		modal.setDeliveryAddress(populateAddressModal(orderEntity.getDeliveryAddress()));
		
		return modal; 
		
	}
	
	
	public AddressEntity populateAddressEntity(Address modal) {
		logger.debug("Populating Address entity from modal");
		AddressEntity entity = new AddressEntity();
		return populateAddressEntity(modal, entity);
	}


	private AddressEntity populateAddressEntity(Address modal, AddressEntity entity) {
		entity.setCity(modal.getCity());
		entity.setCountry(modal.getCountry());
		entity.setLine1(modal.getLine1());
		entity.setLine2(modal.getLine2());
		entity.setState(modal.getState());
		
		return entity;
	}
	
	
	/**
	 * @param entityObj
	 * @param modalObj
	 */
	public Address populateAddressModal(AddressEntity entityObj) {
		Address modalObj = new Address();
		modalObj.setCity(entityObj.getCity());
		modalObj.setCountry(entityObj.getCountry());
		modalObj.setLine1(entityObj.getLine1());
		modalObj.setLine2(entityObj.getLine2());
		modalObj.setState(entityObj.getState());
		return modalObj;
	}
	
	public OrderModal populateOrderModal(long id) {
		logger.debug("Order details populator: populating Order details");
		OrderModal modal = new OrderModal();
		modal.setOrderId(id);
		modal.setOrderDate(Calendar.getInstance().getTime().toString());
		modal.setOrderTime(Calendar.getInstance().getTime().toInstant().toString());
		modal.setDeliveryAddress(new Address("Line-1"+id, "Line-2"+id, "city-"+id, "state"+id, "india"));
		return modal;
	}

}
