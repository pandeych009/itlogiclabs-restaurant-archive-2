package com.itlogiclab.billing.api;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itlogiclab.billing.modal.BillModal;
import com.itlogiclab.billing.service.BillingService;

@RestController
@RequestMapping("/bill/api/")
public class BillingApi {
	
	private static Logger logger = LogManager.getLogger(BillingApi.class);
	
	@Autowired
	private BillingService service;
	
	
	@PutMapping(value="/create", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BillModal> createNewBill(@RequestBody BillModal modal){
		try {
			BillModal persisted = service.add(modal);
			return ResponseEntity.ok(persisted);	
		} catch (RuntimeException e) {
			logger.error("Error while creating new Bill using BillModal: "+e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@PostMapping(value="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateBill(@RequestBody BillModal modal){
	
		try {
			BillModal persistedModal = service.update(modal);
			return ResponseEntity.ok(persistedModal);	
		} catch (RuntimeException e) {
			logger.error("Error occured while update bill with id : "+modal.getBillId()+ " error description: " +e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	@GetMapping(value="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BillModal>> getAll(){
		logger.debug("invoking getBills API : ");
		try {
			List<BillModal> persisted = service.getBills();
			return ResponseEntity.ok(persisted);	
		} catch (RuntimeException e) {
			logger.error("Error occured while fetching bills: with error description: " +e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping(value="/get/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BillModal> get(@PathVariable Long id){
		logger.debug("invoking get API with id : "+id);
		try {
			BillModal persisted = service.get(id);
			return ResponseEntity.ok(persisted);	
		} catch (RuntimeException e) {
			logger.error("Error occured while fetching bill with id : "+id+ " error description: " +e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
