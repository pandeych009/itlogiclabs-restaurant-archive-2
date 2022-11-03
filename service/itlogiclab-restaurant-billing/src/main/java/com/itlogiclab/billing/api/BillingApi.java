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
@RequestMapping("/billing/api/")
public class BillingApi {
	
	private static Logger logger = LogManager.getLogger(BillingApi.class);
	
	@Autowired
	private BillingService service;
	
	
	@PutMapping(value="/add", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BillModal> createNewBill(@RequestBody BillModal modal){
		try {
			BillModal persisted = service.add(modal);
			return ResponseEntity.ok(persisted);	
		} catch (RuntimeException e) {
			logger.error("Error while add new bill : "+e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@PostMapping(value="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateBill(@RequestBody BillModal modal){
	
		try {
			BillModal persistedModal = service.update(modal);
			return ResponseEntity.ok(persistedModal);	
		} catch (RuntimeException e) {
			logger.error("Error while update new bill : "+e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
	@GetMapping(value="/get", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BillModal>> getAll(){
		try {
			List<BillModal> persisted = service.get();
			return ResponseEntity.ok(persisted);	
		} catch (RuntimeException e) {
			logger.error("Error while fetch bills : "+e.getMessage());
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
			logger.error("Error while fetch bill : "+id+ " error description: " +e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
