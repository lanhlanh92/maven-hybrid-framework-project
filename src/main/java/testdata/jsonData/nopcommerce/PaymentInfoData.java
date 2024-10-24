package testdata.jsonData.nopcommerce;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class PaymentInfoData {
	public static PaymentInfoData getUserInfo() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.DATA_FILE_PATH + "paymentData.json"), PaymentInfoData.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null; 
		}
	}
	@JsonProperty("card")
	private String card;

	@JsonProperty("date")
	private String date;
	
	@JsonProperty("cvc")
	private String cvc;

	public String getCard() {
		return card;
	}

	public String getDate() {
		return date;
	}

	public String getCvc() {
		return cvc;
	}
	
	@JsonProperty("Checkout")
	Checkout checkout;
	
	static class Checkout {
		String discount;
	}
	
	public String getDiscount() {
		return checkout.discount;
	}
}
