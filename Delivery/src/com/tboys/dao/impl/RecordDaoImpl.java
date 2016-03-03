package com.tboys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tboys.dao.RecordDao;
import com.tboys.model.Record;
import com.tboys.model.User;

public class RecordDaoImpl implements RecordDao{

	private PreparedStatement state;
	private Connection conn;
	private ResultSet result;
	private String sql;
	
	public RecordDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean insertRecord(Record record,User user) throws SQLException {
		// TODO Auto-generated method stub
		sql = "insert into record(id,record_start,record_end,user_id) values(seq_record.NEXTVAL,?,?,?)";
		state = conn.prepareStatement(sql);
		state.setString(1, record.getRecord_start());
		state.setString(2, record.getRecord_end());
		UserManageDaoImpl u = new UserManageDaoImpl(conn);
		int x = u.QueryId(user);
		state.setInt(3, x);
		boolean isTrue = state.execute();
		conn.close();
		state.close();
		
		return isTrue;
	}

	@Override
	public int countRecord(User user) throws SQLException {
		sql = "select count(*) from record where users_id = ?";
		state = conn.prepareStatement(sql);
		UserManageDaoImpl u = new UserManageDaoImpl(conn);
		int x = u.QueryId(user);
		state.setInt(1, x);
		result = state.executeQuery();
		int n = 0;
		if(result.next()) {
			n = result.getInt(0);
		}
		conn.close();
		state.close();
		result.close();
		return n;
	}

	@Override
	public ArrayList<Record> findRecord(User user) throws SQLException{
		ArrayList recordList = new ArrayList();
		sql = "select * from record where users_id = ?";
		state = conn.prepareStatement(sql);
		UserManageDaoImpl u = new UserManageDaoImpl(conn);
		int x = u.QueryId(user);
		state.setInt(1, x);
		result = state.executeQuery();
		Record record;
		while(result.next()) {
			record = new Record();
			record.setRecord_end(result.getString("record_end"));
			record.setRecord_start(result.getString("record_start"));
			record.setRecord_time(result.getDate("record_time"));
			recordList.add(record);
		}
		conn.close();
		state.close();
		return recordList;
	}


}
