package com.tboys.model;

public class DeliveryDan {

	private String delivery_company_name;
	private String delivery_num;
	private String delivery_time;
	private String delivery_company_image;
	private int user_id;
	private String delivery_message;
	
	public DeliveryDan() {
		super();
	}

	public DeliveryDan(String delivery_company_name, String delivery_num, String delivery_time,
			String delivery_company_image, int user_id, String delivery_message) {
		super();
		this.delivery_company_name = delivery_company_name;
		this.delivery_num = delivery_num;
		this.delivery_time = delivery_time;
		this.delivery_company_image = delivery_company_image;
		this.user_id = user_id;
		this.delivery_message = delivery_message;
	}
	
	public String getDelivery_company_name() {
		return delivery_company_name;
	}

	public void setDelivery_company_name(String delivery_company_name) {
		this.delivery_company_name = delivery_company_name;
	}

	public String getDelivery_num() {
		return delivery_num;
	}

	public void setDelivery_num(String delivery_num) {
		this.delivery_num = delivery_num;
	}

	public String getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}

	public String getDelivery_company_image() {
		return delivery_company_image;
	}

	public void setDelivery_company_image(String delivery_company_image) {
		this.delivery_company_image = delivery_company_image;
	}

	public String getDelivery_message() {
		return delivery_message;
	}

	public void setDelivery_message(String delivery_message) {
		this.delivery_message = delivery_message;
	}

	@Override
	public String toString() {
		return "DeliveryDan [" +", delivery_company_name=" + delivery_company_name + ", delivery_num="
				+ delivery_num + ", delivery_time=" + delivery_time + ", delivery_company_image="
				+ delivery_company_image + ", user_id=" + user_id + ", delivery_message=" + delivery_message + "]";
	}
	
	
	
}
