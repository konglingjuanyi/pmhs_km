package cn.net.tongfang.framework.security.vo;

//imports
import java.lang.StringBuffer;
import java.math.BigDecimal;
import java.lang.Integer;
import java.lang.String;
import java.io.Serializable;

/**
* <p>Title:Drug </p>
* <p>Description: Drug,Hibernate ”≥…‰VO </p>
* <p>Company: thtf yun nan Branch</p>
* @author PdmToVoGen1.0 
* @version 1.0
* @create datetime 2010-12-31 11:25:53.75
*/

public class DrugVO implements Serializable {
    //Fields
    //ID
    private String ID;
    //Code
    private String Code;
    //RecType
    private Integer RecType;
    //Name
    private String Name;
    //PinYin
    private String PinYin;
    //Spec
    private String Spec;
    //Unit
    private String Unit;
    //Producer
    private String Producer;
    //IsBase
    private Integer IsBase;
    //IsCHN
    private Integer IsCHN;
    //BuyPrice
    private BigDecimal BuyPrice;
    //RetailPrice
    private BigDecimal RetailPrice;
    //UploadClassID
    private String UploadClassID;
    //UploadItemCode
    private String UploadItemCode;
    //UploadFeeTypeID
    private String UploadFeeTypeID;
    
    private int muteFlag;
    
	//contructors
    public DrugVO() {}

    public DrugVO(String ID) {
        this.ID = ID;
    }

	//methods
    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCode() {
        return this.Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public Integer getRecType() {
        return this.RecType;
    }

    public void setRecType(Integer RecType) {
        this.RecType = RecType;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPinYin() {
        return this.PinYin;
    }

    public void setPinYin(String PinYin) {
        this.PinYin = PinYin;
    }

    public String getSpec() {
        return this.Spec;
    }

    public void setSpec(String Spec) {
        this.Spec = Spec;
    }

    public String getUnit() {
        return this.Unit;
    }

    public void setUnit(String Unit) {
        this.Unit = Unit;
    }

    public String getProducer() {
        return this.Producer;
    }

    public void setProducer(String Producer) {
        this.Producer = Producer;
    }

    public Integer getIsBase() {
        return this.IsBase;
    }

    public void setIsBase(Integer IsBase) {
        this.IsBase = IsBase;
    }

    public Integer getIsCHN() {
        return this.IsCHN;
    }

    public void setIsCHN(Integer IsCHN) {
        this.IsCHN = IsCHN;
    }

    public BigDecimal getBuyPrice() {
        return this.BuyPrice;
    }

    public void setBuyPrice(BigDecimal BuyPrice) {
        this.BuyPrice = BuyPrice;
    }

    public BigDecimal getRetailPrice() {
        return this.RetailPrice;
    }

    public void setRetailPrice(BigDecimal RetailPrice) {
        this.RetailPrice = RetailPrice;
    }

    public String getUploadClassID() {
        return this.UploadClassID;
    }

    public void setUploadClassID(String UploadClassID) {
        this.UploadClassID = UploadClassID;
    }

    public String getUploadItemCode() {
        return this.UploadItemCode;
    }

    public void setUploadItemCode(String UploadItemCode) {
        this.UploadItemCode = UploadItemCode;
    }

    public String getUploadFeeTypeID() {
        return this.UploadFeeTypeID;
    }

    public void setUploadFeeTypeID(String UploadFeeTypeID) {
        this.UploadFeeTypeID = UploadFeeTypeID;
    }

    public void setMuteFlag(int muteFlag) {
        this.muteFlag = muteFlag;
    }

    public int getMuteFlag() {
        return muteFlag;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[Code:").append(Code).append("]");
        sb.append("[RecType:").append(RecType).append("]");
        sb.append("[Name:").append(Name).append("]");
        sb.append("[PinYin:").append(PinYin).append("]");
        sb.append("[Spec:").append(Spec).append("]");
        sb.append("[Unit:").append(Unit).append("]");
        sb.append("[Producer:").append(Producer).append("]");
        sb.append("[IsBase:").append(IsBase).append("]");
        sb.append("[IsCHN:").append(IsCHN).append("]");
        sb.append("[BuyPrice:").append(BuyPrice).append("]");
        sb.append("[RetailPrice:").append(RetailPrice).append("]");
        sb.append("[UploadClassID:").append(UploadClassID).append("]");
        sb.append("[UploadItemCode:").append(UploadItemCode).append("]");
        sb.append("[UploadFeeTypeID:").append(UploadFeeTypeID).append("]");
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
        if(!(vo instanceof DrugVO))
            return false;
        DrugVO eq = (DrugVO)vo;
        return ID == null ? eq.getID() == null : ID.equals(eq.getID());
    }
}