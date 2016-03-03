package com.tboys.dao;

import java.util.ArrayList;

import com.tboys.model.DeliveryDan;
import com.tboys.model.User;

public interface DeliveryDanManageDao {
	
	boolean insertDelivery(DeliveryDan dan);
	
	boolean removeDelivery(DeliveryDan dan);
	
	ArrayList<DeliveryDan> findDelivery(User user);
	
}
