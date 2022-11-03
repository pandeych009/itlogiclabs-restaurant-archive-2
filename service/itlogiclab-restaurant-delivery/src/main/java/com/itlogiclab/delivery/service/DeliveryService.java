package com.itlogiclab.delivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itlogiclab.delivery.entity.DeliveryEntity;
import com.itlogiclab.delivery.modal.DeliveryModal;
import com.itlogiclab.delivery.repos.DeliveryRepos;

@Service
public class DeliveryService {

	private static Logger logger = LogManager.getLogger(DeliveryService.class);


	@Autowired
	private DeliveryRepos repos; 

	public DeliveryModal createDelivery(DeliveryModal modal) {
		logger.debug("Start execution of new delivery Creation: ");

		DeliveryEntity persistedEntity = null;

		if(Objects.isNull(modal.getDeliveryId()) || modal.getDeliveryId() == 0) {
			DeliveryEntity entity = new DeliveryEntity();
			entity.setDeliveryStaus(modal.getDeliveryStaus());
			entity.setOrderId(modal.getOrderId());
			persistedEntity = repos.save(entity);

			if(Objects.nonNull(persistedEntity)) {
				DeliveryModal persistedModel = new DeliveryModal(); 

				persistedModel.setDeliveryId(persistedEntity.getDeliveryId());
				persistedModel.setOrderId(persistedEntity.getOrderId());
				persistedModel.setDeliveryStaus(persistedEntity.getDeliveryStaus());
				return persistedModel;
			}
		}
		logger.debug("No persisted data found: returning null");
		return null;
	}

	public DeliveryModal updateDelivery(DeliveryModal modal) {
		logger.debug("Start execution of update delivery Creation: ");
		DeliveryEntity persistedEntity = repos.findById(modal.getDeliveryId()).orElseThrow(RuntimeException::new);
		persistedEntity.setDeliveryStaus(modal.getDeliveryStaus());
		if(persistedEntity.getOrderId() != modal.getOrderId()) {
			throw new RuntimeException("Order id does not match: Please correct the data");
		}
		persistedEntity.setOrderId(modal.getOrderId());
		persistedEntity = repos.save(persistedEntity);
		//Update modal and return to caller:
		modal.setDeliveryStaus(persistedEntity.getDeliveryStaus());
		modal.setOrderId(persistedEntity.getOrderId());
		return modal;
	}



	public List<DeliveryModal> getAllDelivery(){
		List<DeliveryModal> modals = new ArrayList<DeliveryModal>();
		repos.findAll().forEach(input -> {
			DeliveryModal modal = new DeliveryModal();
			modal.setDeliveryId(input.getDeliveryId());
			modal.setDeliveryStaus(input.getDeliveryStaus());
			modal.setOrderId(input.getOrderId());
			modals.add(modal);
		});
		return modals; 
	}


	public DeliveryModal getDelivery(Long deliveryId){
		DeliveryEntity input = repos.findById(deliveryId).orElseThrow(RuntimeException::new);
		DeliveryModal modal = new DeliveryModal();
		modal.setDeliveryId(input.getDeliveryId());
		modal.setDeliveryStaus(input.getDeliveryStaus());
		modal.setOrderId(input.getOrderId());
		return modal;
	}
}
