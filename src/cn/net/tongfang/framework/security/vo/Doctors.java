package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * Doctors entity. @author MyEclipse Persistence Tools
 */

public class Doctors implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String sex;
	private Timestamp birthday;
	private String tel;
	private String address;
	private Integer hospId;

	// Constructors

	/** default constructor */
	public Doctors() {
	}

	/** minimal constructor */
	public Doctors(String name, Integer hospId) {
		this.name = name;
		this.hospId = hospId;
	}

	/** full constructor */
	public Doctors(String name, String sex, Timestamp birthday, String tel,
			String address, Integer hospId) {
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.tel = tel;
		this.address = address;
		this.hospId = hospId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getHospId() {
		return this.hospId;
	}

	public void setHospId(Integer hospId) {
		this.hospId = hospId;
	}

}