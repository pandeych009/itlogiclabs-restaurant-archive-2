package com.itlogiclab.payment.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itlogiclab.payment.modal.PaymentModal;
import com.itlogiclab.payment.service.PaymentService;



@CrossOrigin("http:\\localhost:8081")
@RestController
@RequestMapping("/payment/api/")
public class PaymentApi {
	
	private static Logger logger = LogManager.getLogger(PaymentApi.class);
	
	@Autowired
	private PaymentService paymentService;
	
	@PutMapping(value="/createpayment", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentModal> createNewPayment(@RequestBody PaymentModal modal){
		try {
			PaymentModal persisted = paymentService.createPayment(modal);
			return ResponseEntity.ok(persisted);	
		} catch (RuntimeException e) {
			logger.error("Error occured while writing the incentive file: "+e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
	@GetMapping(value="/updateOrder/{paymentid}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentModal> updateOrderStatus(@PathVariable Long paymentid){
		try {
			PaymentModal persisted = paymentService.updatePaymentStatus(paymentid);
			return ResponseEntity.ok(persisted);	
		} catch (RuntimeException e) {
			logger.error("Error occured writing the incentive file: "+e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}
	
}
