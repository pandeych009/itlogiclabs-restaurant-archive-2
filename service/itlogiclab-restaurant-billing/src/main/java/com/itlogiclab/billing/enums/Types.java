package com.itlogiclab.billing.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Types {
	public enum BILLING_TYPE {CC, DC, PAYPAL, UPI};
	public enum BILLING_STATUS {
		START("S", "Start"), PENDING("P", "Pending"), COMPLETE("C", "Complete");
		
		private String key;
		private String value; 
		
		private BILLING_STATUS(String key, String value) {
			this.key=key;
			this.value=value; 
		}
		
		private static Map<String, BILLING_STATUS> map = null;
		static {
			map = new HashMap<>();
			for(BILLING_STATUS status: values()) {
				map.put(status.getKey(), status);
			}
		}
		
		
		/**
		 * @return the key
		 */
		public String getKey() {
			return key;
		}
		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}
		
		public static BILLING_STATUS getValueByKey(String key) {
			if(Objects.nonNull(map.get(key)))
				return map.get(key);
			return null;
		}
		
		public static String getKeyByValue(BILLING_STATUS value) {
			if(Objects.nonNull(map.values()))
				for(BILLING_STATUS status: map.values()) {
					if(value.equals(status)) {
						return value.getKey();
					}
				}
				
			return null;
		}
	}
		
}
