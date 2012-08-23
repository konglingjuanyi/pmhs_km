package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * OnlinePhoto entity. @author MyEclipse Persistence Tools
 */

public class OnlinePhoto implements java.io.Serializable {

	// Fields

	private String id;
	private String photoName;
	private Integer photoWidth;
	private Integer photoHeight;
	private String inputPersonId;
	private Timestamp inputDate;

	// Constructors

	/** default constructor */
	public OnlinePhoto() {
	}

	/** full constructor */
	public OnlinePhoto(String id, String photoName, Integer photoWidth,
			Integer photoHeight, String inputPersonId, Timestamp inputDate) {
		this.id = id;
		this.photoName = photoName;
		this.photoWidth = photoWidth;
		this.photoHeight = photoHeight;
		this.inputPersonId = inputPersonId;
		this.inputDate = inputDate;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhotoName() {
		return this.photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public Integer getPhotoWidth() {
		return this.photoWidth;
	}

	public void setPhotoWidth(Integer photoWidth) {
		this.photoWidth = photoWidth;
	}

	public Integer getPhotoHeight() {
		return this.photoHeight;
	}

	public void setPhotoHeight(Integer photoHeight) {
		this.photoHeight = photoHeight;
	}

	public String getInputPersonId() {
		return this.inputPersonId;
	}

	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}

	public Timestamp getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Timestamp inputDate) {
		this.inputDate = inputDate;
	}

}