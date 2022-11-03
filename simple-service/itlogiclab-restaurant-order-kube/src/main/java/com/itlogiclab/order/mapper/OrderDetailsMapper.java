package com.itlogiclab.order.mapper;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.itlogiclab.order.modal.Address;
import com.itlogiclab.order.modal.OrderModal;

@Component
public class OrderDetailsMapper {
	private static Logger logger = LogManager.getLogger(OrderDetailsMapper.class); 
	
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
