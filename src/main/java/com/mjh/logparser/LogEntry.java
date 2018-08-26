package com.mjh.logparser;

import java.util.Date;

public class LogEntry {
	public LogEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LogEntry(int id, Date date, String ipAddress, String request, String status, String userAgent) {
		super();
		this.id = id;
		this.date = date;
		this.ipAddress = ipAddress;
		this.request = request;
		this.status = status;
		this.userAgent = userAgent;
	}


	private int id;
	private Date date;
	private String ipAddress;
	private String request;
	private String status;
	private String userAgent;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	
}
