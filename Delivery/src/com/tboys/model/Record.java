package com.tboys.model;

import java.util.Date;

public class Record {
	
	private String record_start;
	private String record_end;
	private Date record_time;
	private int user_id;
	
	public Record() {
		super();
	}

	public Record(String record_start, String record_end, Date record_time, int user_id) {
		super();
		this.record_start = record_start;
		this.record_end = record_end;
		this.record_time = record_time;
		this.user_id = user_id;
	}
	
	public String getRecord_start() {
		return record_start;
	}
	public void setRecord_start(String record_start) {
		this.record_start = record_start;
	}
	public String getRecord_end() {
		return record_end;
	}
	public void setRecord_end(String record_end) {
		this.record_end = record_end;
	}
	public Date getRecord_time() {
		return record_time;
	}
	public void setRecord_time(Date record_time) {
		this.record_time = record_time;
	}
	
	@Override
	public String toString() {
		return "Record [ " + ", record_start=" + record_start + ", record_end=" + record_end + ", record_time="
				+ record_time + ", user_id=" + user_id + "]";
	}

}
