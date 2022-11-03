package com.itlogiclab.delivery.api;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itlogiclab.delivery.modal.DeliveryModal;
import com.itlogiclab.delivery.service.DeliveryService;


@CrossOrigin("http:\\localhost:8081")
@RestController
@RequestMapping("/delivery/api/")
public class DeliveryApi {

	private static Logger logger = LogManager.getLogger(DeliveryApi.class);

	@Autowired
	private DeliveryService deliveryService;


	@PutMapping(value="/createNewDelivery", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeliveryModal> createNewDelivery(@RequestBody DeliveryModal modal){
		try {
			DeliveryModal persisted = deliveryService.createDelivery(modal);
			return ResponseEntity.ok(persisted);	
		} catch (RuntimeException e) {
			logger.error("Error occured while creating new delivery for order: {} : ", modal.getOrderId() +e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@PostMapping(value="/updateDelivery", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeliveryModal> updateDelivery(@RequestBody DeliveryModal modal){
		try {
			DeliveryModal persisted =   deliveryService.updateDelivery(modal);
			return ResponseEntity.ok(persisted);	
		} catch (RuntimeException e) {
			logger.error("Error occured while update of delivery for delivery id: {} and for order id {} : ", modal.getDeliveryId(), modal.getOrderId() +e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@GetMapping(value="/getAllDelivery", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DeliveryModal>> getAllDelivery(){
		try {
			List<DeliveryModal> persisted =   deliveryService.getAllDelivery();
			return ResponseEntity.ok(persisted);	
		} catch (RuntimeException e) {
			logger.error("Error occured while fetching all delivery details "+e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@GetMapping(value="/getDelivery/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeliveryModal> getDelivery(@PathVariable Long id){
		try {
			DeliveryModal persisted =   deliveryService.getDelivery(id);
			return ResponseEntity.ok(persisted);	
		} catch (RuntimeException e) {
			logger.error("Error occured while fetching delivery details from db: {} : ", id +e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
}
