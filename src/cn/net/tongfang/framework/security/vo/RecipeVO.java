package cn.net.tongfang.framework.security.vo;

//imports
import java.lang.StringBuffer;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.lang.Integer;
import java.lang.String;
import java.io.Serializable;

/**
* <p>Title:Recipe </p>
* <p>Description: Recipe,Hibernate ”≥…‰VO </p>
* <p>Company: thtf yun nan Branch</p>
* @author PdmToVoGen1.0 
* @version 1.0
* @create datetime 2010-12-31 11:25:53.75
*/

public class RecipeVO implements Serializable {
    //Fields
    //ID
    private String ID;
    //RecipeType
    private Integer RecipeType;
    //RecipeNo
    private String RecipeNo;
    //PayType
    private String PayType;
    //CardNo
    private String CardNo;
    //PersonalNo
    private String PersonalNo;
    //SickName
    private String SickName;
    //Sex
    private String Sex;
    //Birthday
    private Timestamp Birthday;
    //TreatmentType
    private String TreatmentType;
    //InDate
    private Timestamp InDate;
    //InIllnessCode
    private String InIllnessCode;
    //InIllnessName
    private String InIllnessName;
    //OutDate
    private Timestamp OutDate;
    //OutIllnessCode
    private String OutIllnessCode;
    //OutIllnessName
    private String OutIllnessName;
    //OutReason
    private String OutReason;
    //SectionName
    private String SectionName;
    //DoctorName
    private String DoctorName;
    //Operator
    private String Operator;
    //TicketNo
    private String TicketNo;
    //RegisterNo
    private String RegisterNo;
    //SettleDate
    private Timestamp SettleDate;
    //TotalFee
    private BigDecimal TotalFee;
    //XJZF
    private BigDecimal XJZF;
    //DEZF
    private BigDecimal DEZF;
    //TCZF
    private BigDecimal TCZF;
    //ZHZF
    private BigDecimal ZHZF;
    //CenterBillNo
    private String CenterBillNo;
    //RecipeState
    private Integer RecipeState;
    
    private int muteFlag;
    
	//contructors
    public RecipeVO() {}

    public RecipeVO(String ID) {
        this.ID = ID;
    }

	//methods
    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Integer getRecipeType() {
        return this.RecipeType;
    }

    public void setRecipeType(Integer RecipeType) {
        this.RecipeType = RecipeType;
    }

    public String getRecipeNo() {
        return this.RecipeNo;
    }

    public void setRecipeNo(String RecipeNo) {
        this.RecipeNo = RecipeNo;
    }

    public String getPayType() {
        return this.PayType;
    }

    public void setPayType(String PayType) {
        this.PayType = PayType;
    }

    public String getCardNo() {
        return this.CardNo;
    }

    public void setCardNo(String CardNo) {
        this.CardNo = CardNo;
    }

    public String getPersonalNo() {
        return this.PersonalNo;
    }

    public void setPersonalNo(String PersonalNo) {
        this.PersonalNo = PersonalNo;
    }

    public String getSickName() {
        return this.SickName;
    }

    public void setSickName(String SickName) {
        this.SickName = SickName;
    }

    public String getSex() {
        return this.Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public Timestamp getBirthday() {
        return this.Birthday;
    }

    public void setBirthday(Timestamp Birthday) {
        this.Birthday = Birthday;
    }

    public String getTreatmentType() {
        return this.TreatmentType;
    }

    public void setTreatmentType(String TreatmentType) {
        this.TreatmentType = TreatmentType;
    }

    public Timestamp getInDate() {
        return this.InDate;
    }

    public void setInDate(Timestamp InDate) {
        this.InDate = InDate;
    }

    public String getInIllnessCode() {
        return this.InIllnessCode;
    }

    public void setInIllnessCode(String InIllnessCode) {
        this.InIllnessCode = InIllnessCode;
    }

    public String getInIllnessName() {
        return this.InIllnessName;
    }

    public void setInIllnessName(String InIllnessName) {
        this.InIllnessName = InIllnessName;
    }

    public Timestamp getOutDate() {
        return this.OutDate;
    }

    public void setOutDate(Timestamp OutDate) {
        this.OutDate = OutDate;
    }

    public String getOutIllnessCode() {
        return this.OutIllnessCode;
    }

    public void setOutIllnessCode(String OutIllnessCode) {
        this.OutIllnessCode = OutIllnessCode;
    }

    public String getOutIllnessName() {
        return this.OutIllnessName;
    }

    public void setOutIllnessName(String OutIllnessName) {
        this.OutIllnessName = OutIllnessName;
    }

    public String getOutReason() {
        return this.OutReason;
    }

    public void setOutReason(String OutReason) {
        this.OutReason = OutReason;
    }

    public String getSectionName() {
        return this.SectionName;
    }

    public void setSectionName(String SectionName) {
        this.SectionName = SectionName;
    }

    public String getDoctorName() {
        return this.DoctorName;
    }

    public void setDoctorName(String DoctorName) {
        this.DoctorName = DoctorName;
    }

    public String getOperator() {
        return this.Operator;
    }

    public void setOperator(String Operator) {
        this.Operator = Operator;
    }

    public String getTicketNo() {
        return this.TicketNo;
    }

    public void setTicketNo(String TicketNo) {
        this.TicketNo = TicketNo;
    }

    public String getRegisterNo() {
        return this.RegisterNo;
    }

    public void setRegisterNo(String RegisterNo) {
        this.RegisterNo = RegisterNo;
    }

    public Timestamp getSettleDate() {
        return this.SettleDate;
    }

    public void setSettleDate(Timestamp SettleDate) {
        this.SettleDate = SettleDate;
    }

    public BigDecimal getTotalFee() {
        return this.TotalFee;
    }

    public void setTotalFee(BigDecimal TotalFee) {
        this.TotalFee = TotalFee;
    }

    public BigDecimal getXJZF() {
        return this.XJZF;
    }

    public void setXJZF(BigDecimal XJZF) {
        this.XJZF = XJZF;
    }

    public BigDecimal getDEZF() {
        return this.DEZF;
    }

    public void setDEZF(BigDecimal DEZF) {
        this.DEZF = DEZF;
    }

    public BigDecimal getTCZF() {
        return this.TCZF;
    }

    public void setTCZF(BigDecimal TCZF) {
        this.TCZF = TCZF;
    }

    public BigDecimal getZHZF() {
        return this.ZHZF;
    }

    public void setZHZF(BigDecimal ZHZF) {
        this.ZHZF = ZHZF;
    }

    public String getCenterBillNo() {
        return this.CenterBillNo;
    }

    public void setCenterBillNo(String CenterBillNo) {
        this.CenterBillNo = CenterBillNo;
    }

    public Integer getRecipeState() {
        return this.RecipeState;
    }

    public void setRecipeState(Integer RecipeState) {
        this.RecipeState = RecipeState;
    }

    public void setMuteFlag(int muteFlag) {
        this.muteFlag = muteFlag;
    }

    public int getMuteFlag() {
        return muteFlag;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[RecipeType:").append(RecipeType).append("]");
        sb.append("[RecipeNo:").append(RecipeNo).append("]");
        sb.append("[PayType:").append(PayType).append("]");
        sb.append("[CardNo:").append(CardNo).append("]");
        sb.append("[PersonalNo:").append(PersonalNo).append("]");
        sb.append("[SickName:").append(SickName).append("]");
        sb.append("[Sex:").append(Sex).append("]");
        sb.append("[Birthday:").append(Birthday).append("]");
        sb.append("[TreatmentType:").append(TreatmentType).append("]");
        sb.append("[InDate:").append(InDate).append("]");
        sb.append("[InIllnessCode:").append(InIllnessCode).append("]");
        sb.append("[InIllnessName:").append(InIllnessName).append("]");
        sb.append("[OutDate:").append(OutDate).append("]");
        sb.append("[OutIllnessCode:").append(OutIllnessCode).append("]");
        sb.append("[OutIllnessName:").append(OutIllnessName).append("]");
        sb.append("[OutReason:").append(OutReason).append("]");
        sb.append("[SectionName:").append(SectionName).append("]");
        sb.append("[DoctorName:").append(DoctorName).append("]");
        sb.append("[Operator:").append(Operator).append("]");
        sb.append("[TicketNo:").append(TicketNo).append("]");
        sb.append("[RegisterNo:").append(RegisterNo).append("]");
        sb.append("[SettleDate:").append(SettleDate).append("]");
        sb.append("[TotalFee:").append(TotalFee).append("]");
        sb.append("[XJZF:").append(XJZF).append("]");
        sb.append("[DEZF:").append(DEZF).append("]");
        sb.append("[TCZF:").append(TCZF).append("]");
        sb.append("[ZHZF:").append(ZHZF).append("]");
        sb.append("[CenterBillNo:").append(CenterBillNo).append("]");
        sb.append("[RecipeState:").append(RecipeState).append("]");
        return sb.toString();
    }

    public int hashCode(){
        int result = 0;
        result = 29*result +(ID==null ? 0 : ID.hashCode());
        return result;
    }

    public boolean equals(Object vo) {
        if(this == vo)
            return true;
        if(!(vo instanceof RecipeVO))
            return false;
        RecipeVO eq = (RecipeVO)vo;
        return ID == null ? eq.getID() == null : ID.equals(eq.getID());
    }
}