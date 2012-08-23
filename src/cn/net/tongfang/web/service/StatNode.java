package cn.net.tongfang.web.service;

public class StatNode {
	private String id;
	private Long num;
	
	
	public StatNode() {
		super();
	}
	public StatNode(String id, Long num) {
		super();
		this.id = id;
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	
	
}
