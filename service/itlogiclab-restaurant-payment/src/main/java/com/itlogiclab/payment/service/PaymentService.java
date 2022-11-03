package com.itlogiclab.payment.service;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.itlogiclab.payment.enums.Types;
import com.itlogiclab.payment.modal.PaymentModal;
import com.itlogiclab.payment.utils.PaymentUtils;

@Service
public class PaymentService {

	private static Logger logger = LogManager.getLogger(PaymentService.class);
	
	
	public PaymentModal createPayment(PaymentModal modal) {
		logger.debug("New Payment Creation stared:  ");
		long paymentId =  ThreadLocalRandom.current().nextLong(1, 100);
		modal.setPaymentId(paymentId);
		return modal;
	}
	
	public PaymentModal updatePaymentStatus(long paymentId) {
		logger.debug("Payment Update status");
		PaymentModal modal = new PaymentModal(paymentId, UUID.randomUUID().toString(), PaymentUtils.getCurrentDate(), Types.PAYMENT_STATUS.PENDING, Types.PAYMENT_TYPE.CC);
		return modal;
	}
	
}
