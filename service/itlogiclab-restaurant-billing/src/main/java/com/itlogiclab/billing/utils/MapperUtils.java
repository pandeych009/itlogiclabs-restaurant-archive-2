package com.itlogiclab.billing.utils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.itlogiclab.billing.entity.BillEntity;
import com.itlogiclab.billing.entity.BillInfoEntity;
import com.itlogiclab.billing.modal.BillInfoModal;
import com.itlogiclab.billing.modal.BillModal;

@Component
public class MapperUtils {
	
	

	@Bean
	@Lazy
	public BillInfoModal populateBillInfoDetailModals(BillInfoEntity childEntity) {
		BillInfoModal childModal = new BillInfoModal();
		childModal.setBillInfoId(childEntity.getBillInfoId());
		childModal.setChargeName(childEntity.getChargeName());
		childModal.setChargeCost(childEntity.getChargeCost());
		return childModal;
	}
	
	

	@Bean
	@Lazy
	public void mapEntity(BillModal modal, BillEntity entity) {
		entity.setBillAmount(modal.getBillAmount());
		entity.setCustomerId(modal.getCustomerId());
		entity.setDate(modal.getDate());
		entity.setInvoiceNo(modal.getInvoiceNo());
		entity.setOrderId(modal.getOrderId());
		
	}
	
	@Bean
	@Lazy
	public BillInfoEntity populateBillInfoEntity(BillInfoModal modal) {
		BillInfoEntity entity = new BillInfoEntity();
		mapBillInfoEntity(modal, entity);
		return entity;
	}
	
	@Bean
	@Lazy
	private void mapBillInfoEntity(BillInfoModal modal, BillInfoEntity entity) {
		entity.setChargeCost(modal.getChargeCost());
		entity.setChargeName(modal.getChargeName());
	}
	
	
	/**
	 * @param entity
	 * @param modal
	 */
	@Bean
	@Lazy
	public void mapBillEntity(BillEntity entity, BillModal modal) {
		mapEntity(modal, entity);
		
		Map<Long, BillInfoEntity> billInfoMap =  entity.getBillInfoList().stream().collect(Collectors.toMap(input -> input.getBillInfoId(), input -> input));
		List<BillInfoModal> childModals = modal.getBillInfoList();
		
		Set<BillInfoEntity> childEntityToPersist =  childModals.stream().map(inputModal -> {
			BillInfoEntity childEntity = billInfoMap.get(inputModal.getBillInfoId());
			if(Objects.isNull(childEntity)) {
				childEntity = populateBillInfoEntity(inputModal);
			}else if(Objects.nonNull(childEntity) && childEntity.getBillInfoId() == inputModal.getBillInfoId()) {
				mapBillInfoEntity(inputModal, childEntity);
			}
			return childEntity;	
		}).collect(Collectors.toSet());
		
		entity.setBillInfoList(childEntityToPersist);
	}
	 
	@Bean
	@Lazy
	public BillModal populateModal(BillEntity entity) {
		BillModal modal = new BillModal();
		modal.setBillId(entity.getBillId());
		modal.setOrderId(entity.getOrderId());
		modal.setAmount((long) entity.getBillAmount());
		modal.setCustomerId(entity.getCustomerId());
		modal.setDate(entity.getDate());
		modal.setInvoiceNo(entity.getInvoiceNo());
		modal.setStatus(entity.getStatus());
		modal.setBillAmount(entity.getBillAmount());
		
		List<BillInfoModal> billDetails = entity.getBillInfoList().stream().map(childEntity -> populateBillInfoDetailModals(childEntity)).collect(Collectors.toList());
		
		modal.setBillInfoList(billDetails);
		
		
		return modal;
	}
	
	@Bean
	@Lazy
	public BillEntity populateBillEntity(BillModal modal) {
		BillEntity entity = new BillEntity();
		mapEntity(modal, entity);
		Set<BillInfoEntity> infoEntitySet = modal.getBillInfoList().stream().map(input -> populateBillInfoEntity(input)).collect(Collectors.toSet());
		entity.setBillInfoList(infoEntitySet);
		
		infoEntitySet.forEach(input -> input.setBill(entity));
		
		return entity;
	}

}
