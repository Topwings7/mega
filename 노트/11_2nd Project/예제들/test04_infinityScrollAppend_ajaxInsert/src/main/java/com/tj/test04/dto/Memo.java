package com.tj.test04.dto;
import java.sql.Timestamp;
public class Memo {
	private String id;
	private String content;
	private Timestamp rdate;
	private String ip;
	private int startRow;
	private int endRow;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRdate() {
		return rdate;
	}
	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	@Override
	public String toString() {
		return "Memo [id=" + id + ", content=" + content + ", rdate=" + rdate + ", ip=" + ip + ", startRow=" + startRow
				+ ", endRow=" + endRow + "]";
	}
}
