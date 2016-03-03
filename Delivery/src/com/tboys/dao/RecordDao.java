package com.tboys.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tboys.model.Record;
import com.tboys.model.User;

public interface RecordDao {
	

	/**
	 * 插入快递预约记录
	 * @return
	 */
	boolean insertRecord(Record record,User user)throws SQLException ;
	/**
	 * 获得预约记录总数
	 * @return
	 */
	int countRecord(User user)throws SQLException ;
	/**
	 * 查询单条预约记录
	 * @return
	 */
	ArrayList<Record> findRecord(User user)throws SQLException ;
	

	
}
