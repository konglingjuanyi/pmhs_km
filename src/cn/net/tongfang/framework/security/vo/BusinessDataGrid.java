package cn.net.tongfang.framework.security.vo;

import java.sql.Timestamp;

/**
 * BusinessDataGrid entity. @author MyEclipse Persistence Tools
 */

public class BusinessDataGrid implements java.io.Serializable {

	// Fields

	private String id;
	private Long rowId;
	private String medicalExamId;
	private Timestamp medicalExamDate;
	private String babyVisitId;
	private Timestamp babyVisitDate;
	private String childrenMediExam01id;
	private Timestamp childrenMediExam01date;
	private String childrenMediExam02id;
	private Timestamp childrenMediExam02date;
	private String childrenMediExam36id;
	private Timestamp childrenMediExam36date;
	private String firstVistBeforeBornId;
	private Timestamp firstVistBeforeBornDate;
	private String visitBeforeBornId;
	private String visitBeforeBornItem;
	private Timestamp visitBeforeBornDate;
	private String visitAfterBornId;
	private String visitAfterBornItem;
	private Timestamp visitAfterBornDate;
	private String visitAfterBorn42id;
	private Timestamp visitAfterBorn42date;
	private String hypertensionVisitId;
	private Timestamp hypertensionVisitDate;
	private String diabetesVisitId;
	private Timestamp diabetesVisitDate;
	private String furiousVisitId;
	private Timestamp furiousVisitDate;
	private String inputPersonId;

	// Constructors

	/** default constructor */
	public BusinessDataGrid() {
	}

	/** minimal constructor */
	public BusinessDataGrid(Long rowId, String inputPersonId) {
		this.rowId = rowId;
		this.inputPersonId = inputPersonId;
	}

	/** full constructor */
	public BusinessDataGrid(Long rowId, String medicalExamId,
			Timestamp medicalExamDate, String babyVisitId,
			Timestamp babyVisitDate, String childrenMediExam01id,
			Timestamp childrenMediExam01date, String childrenMediExam02id,
			Timestamp childrenMediExam02date, String childrenMediExam36id,
			Timestamp childrenMediExam36date, String firstVistBeforeBornId,
			Timestamp firstVistBeforeBornDate, String visitBeforeBornId,
			String visitBeforeBornItem, Timestamp visitBeforeBornDate,
			String visitAfterBornId, String visitAfterBornItem,
			Timestamp visitAfterBornDate, String visitAfterBorn42id,
			Timestamp visitAfterBorn42date, String hypertensionVisitId,
			Timestamp hypertensionVisitDate, String diabetesVisitId,
			Timestamp diabetesVisitDate, String furiousVisitId,
			Timestamp furiousVisitDate, String inputPersonId) {
		this.rowId = rowId;
		this.medicalExamId = medicalExamId;
		this.medicalExamDate = medicalExamDate;
		this.babyVisitId = babyVisitId;
		this.babyVisitDate = babyVisitDate;
		this.childrenMediExam01id = childrenMediExam01id;
		this.childrenMediExam01date = childrenMediExam01date;
		this.childrenMediExam02id = childrenMediExam02id;
		this.childrenMediExam02date = childrenMediExam02date;
		this.childrenMediExam36id = childrenMediExam36id;
		this.childrenMediExam36date = childrenMediExam36date;
		this.firstVistBeforeBornId = firstVistBeforeBornId;
		this.firstVistBeforeBornDate = firstVistBeforeBornDate;
		this.visitBeforeBornId = visitBeforeBornId;
		this.visitBeforeBornItem = visitBeforeBornItem;
		this.visitBeforeBornDate = visitBeforeBornDate;
		this.visitAfterBornId = visitAfterBornId;
		this.visitAfterBornItem = visitAfterBornItem;
		this.visitAfterBornDate = visitAfterBornDate;
		this.visitAfterBorn42id = visitAfterBorn42id;
		this.visitAfterBorn42date = visitAfterBorn42date;
		this.hypertensionVisitId = hypertensionVisitId;
		this.hypertensionVisitDate = hypertensionVisitDate;
		this.diabetesVisitId = diabetesVisitId;
		this.diabetesVisitDate = diabetesVisitDate;
		this.furiousVisitId = furiousVisitId;
		this.furiousVisitDate = furiousVisitDate;
		this.inputPersonId = inputPersonId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getRowId() {
		return this.rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public String getMedicalExamId() {
		return this.medicalExamId;
	}

	public void setMedicalExamId(String medicalExamId) {
		this.medicalExamId = medicalExamId;
	}

	public Timestamp getMedicalExamDate() {
		return this.medicalExamDate;
	}

	public void setMedicalExamDate(Timestamp medicalExamDate) {
		this.medicalExamDate = medicalExamDate;
	}

	public String getBabyVisitId() {
		return this.babyVisitId;
	}

	public void setBabyVisitId(String babyVisitId) {
		this.babyVisitId = babyVisitId;
	}

	public Timestamp getBabyVisitDate() {
		return this.babyVisitDate;
	}

	public void setBabyVisitDate(Timestamp babyVisitDate) {
		this.babyVisitDate = babyVisitDate;
	}

	public String getChildrenMediExam01id() {
		return this.childrenMediExam01id;
	}

	public void setChildrenMediExam01id(String childrenMediExam01id) {
		this.childrenMediExam01id = childrenMediExam01id;
	}

	public Timestamp getChildrenMediExam01date() {
		return this.childrenMediExam01date;
	}

	public void setChildrenMediExam01date(Timestamp childrenMediExam01date) {
		this.childrenMediExam01date = childrenMediExam01date;
	}

	public String getChildrenMediExam02id() {
		return this.childrenMediExam02id;
	}

	public void setChildrenMediExam02id(String childrenMediExam02id) {
		this.childrenMediExam02id = childrenMediExam02id;
	}

	public Timestamp getChildrenMediExam02date() {
		return this.childrenMediExam02date;
	}

	public void setChildrenMediExam02date(Timestamp childrenMediExam02date) {
		this.childrenMediExam02date = childrenMediExam02date;
	}

	public String getChildrenMediExam36id() {
		return this.childrenMediExam36id;
	}

	public void setChildrenMediExam36id(String childrenMediExam36id) {
		this.childrenMediExam36id = childrenMediExam36id;
	}

	public Timestamp getChildrenMediExam36date() {
		return this.childrenMediExam36date;
	}

	public void setChildrenMediExam36date(Timestamp childrenMediExam36date) {
		this.childrenMediExam36date = childrenMediExam36date;
	}

	public String getFirstVistBeforeBornId() {
		return this.firstVistBeforeBornId;
	}

	public void setFirstVistBeforeBornId(String firstVistBeforeBornId) {
		this.firstVistBeforeBornId = firstVistBeforeBornId;
	}

	public Timestamp getFirstVistBeforeBornDate() {
		return this.firstVistBeforeBornDate;
	}

	public void setFirstVistBeforeBornDate(Timestamp firstVistBeforeBornDate) {
		this.firstVistBeforeBornDate = firstVistBeforeBornDate;
	}

	public String getVisitBeforeBornId() {
		return this.visitBeforeBornId;
	}

	public void setVisitBeforeBornId(String visitBeforeBornId) {
		this.visitBeforeBornId = visitBeforeBornId;
	}

	public String getVisitBeforeBornItem() {
		return this.visitBeforeBornItem;
	}

	public void setVisitBeforeBornItem(String visitBeforeBornItem) {
		this.visitBeforeBornItem = visitBeforeBornItem;
	}

	public Timestamp getVisitBeforeBornDate() {
		return this.visitBeforeBornDate;
	}

	public void setVisitBeforeBornDate(Timestamp visitBeforeBornDate) {
		this.visitBeforeBornDate = visitBeforeBornDate;
	}

	public String getVisitAfterBornId() {
		return this.visitAfterBornId;
	}

	public void setVisitAfterBornId(String visitAfterBornId) {
		this.visitAfterBornId = visitAfterBornId;
	}

	public String getVisitAfterBornItem() {
		return this.visitAfterBornItem;
	}

	public void setVisitAfterBornItem(String visitAfterBornItem) {
		this.visitAfterBornItem = visitAfterBornItem;
	}

	public Timestamp getVisitAfterBornDate() {
		return this.visitAfterBornDate;
	}

	public void setVisitAfterBornDate(Timestamp visitAfterBornDate) {
		this.visitAfterBornDate = visitAfterBornDate;
	}

	public String getVisitAfterBorn42id() {
		return this.visitAfterBorn42id;
	}

	public void setVisitAfterBorn42id(String visitAfterBorn42id) {
		this.visitAfterBorn42id = visitAfterBorn42id;
	}

	public Timestamp getVisitAfterBorn42date() {
		return this.visitAfterBorn42date;
	}

	public void setVisitAfterBorn42date(Timestamp visitAfterBorn42date) {
		this.visitAfterBorn42date = visitAfterBorn42date;
	}

	public String getHypertensionVisitId() {
		return this.hypertensionVisitId;
	}

	public void setHypertensionVisitId(String hypertensionVisitId) {
		this.hypertensionVisitId = hypertensionVisitId;
	}

	public Timestamp getHypertensionVisitDate() {
		return this.hypertensionVisitDate;
	}

	public void setHypertensionVisitDate(Timestamp hypertensionVisitDate) {
		this.hypertensionVisitDate = hypertensionVisitDate;
	}

	public String getDiabetesVisitId() {
		return this.diabetesVisitId;
	}

	public void setDiabetesVisitId(String diabetesVisitId) {
		this.diabetesVisitId = diabetesVisitId;
	}

	public Timestamp getDiabetesVisitDate() {
		return this.diabetesVisitDate;
	}

	public void setDiabetesVisitDate(Timestamp diabetesVisitDate) {
		this.diabetesVisitDate = diabetesVisitDate;
	}

	public String getFuriousVisitId() {
		return this.furiousVisitId;
	}

	public void setFuriousVisitId(String furiousVisitId) {
		this.furiousVisitId = furiousVisitId;
	}

	public Timestamp getFuriousVisitDate() {
		return this.furiousVisitDate;
	}

	public void setFuriousVisitDate(Timestamp furiousVisitDate) {
		this.furiousVisitDate = furiousVisitDate;
	}

	public String getInputPersonId() {
		return this.inputPersonId;
	}

	public void setInputPersonId(String inputPersonId) {
		this.inputPersonId = inputPersonId;
	}

}