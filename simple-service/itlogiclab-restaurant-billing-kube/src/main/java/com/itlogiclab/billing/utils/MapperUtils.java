package com.itlogiclab.billing.utils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.itlogiclab.billing.enums.Types.BILLING_STATUS;
import com.itlogiclab.billing.modal.BillInfoModal;
import com.itlogiclab.billing.modal.BillModal;

@Component
public class MapperUtils {


	private static Logger logger = LogManager.getLogger(MapperUtils.class);

	public BillModal populateModal() {
		long id = ThreadLocalRandom.current().nextLong();
		logger.debug("Id Generated as : "+id);
		return populateModal(id);
	}


	public BillModal populateModal(long id) {

		BillModal modal = new BillModal();
		modal.setBillId(id);
		modal.setOrderId(20001+id);
		modal.setAmount((long) 20002+id);
		modal.setCustomerId(20003);
		modal.setDate(Instant.now().toString());
		modal.setInvoiceNo("Invoice_"+id);
		modal.setStatus(BILLING_STATUS.PENDING.toString());
		modal.setBillAmount(10000+id);

		modal.setBillInfoList(populateBillInfoDetailModals());

		return modal;
	}

	public BillInfoModal populateBillInfoDetailModals(Long id) {
		BillInfoModal childModal = new BillInfoModal();
		childModal.setBillInfoId(id);
		childModal.setChargeName("My_Charge_"+id);
		childModal.setChargeCost(5000+id/2);
		return childModal;
	}

	public List<BillInfoModal> populateBillInfoDetailModals() {
		List<BillInfoModal> modals = new ArrayList<BillInfoModal>();
		for(int index=0;index<10;index++) {
			Long id = ThreadLocalRandom.current().nextLong();
			logger.debug("id Random: "+id);
			modals.add(populateBillInfoDetailModals(id));
		}
		return modals;
	}


}
