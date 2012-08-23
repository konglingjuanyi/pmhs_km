package cn.net.tongfang.framework.security.vo;

//imports
import java.lang.StringBuffer;
import java.lang.String;
import java.io.Serializable;

/**
* <p>Title:NccmSick </p>
* <p>Description: NccmSick,Hibernate Ó³ÉäVO </p>
* <p>Company: thtf yun nan Branch</p>
* @author PdmToVoGen1.0 
* @version 1.0
* @create datetime 2010-12-31 11:25:53.75
*/

public class NccmsickVO implements Serializable {
    //Fields
    //SickName
    private String SickName;
    //FeeCode
    private String FeeCode;
    //MemoCode
    private String MemoCode;
    //FeeType
    private String FeeType;
    //SpecialSick
    private String SpecialSick;
    
    private int muteFlag;
    //¸´ºÏÖ÷¼ü
    private NccmsickPK nccmsickPK;
    
	//contructors
    public NccmsickVO() {
        this.nccmsickPK = new NccmsickPK();
    }

    public NccmsickVO(NccmsickPK nccmsickPK) {
        this.nccmsickPK = nccmsickPK;
    }

	//methods
    public void setPrimaryKey(NccmsickPK nccmsickPK) {
        this.nccmsickPK = nccmsickPK;
    }

    public NccmsickPK getPrimaryKey() {
        return nccmsickPK;
    }

    public String getSickName() {
        return this.SickName;
    }

    public void setSickName(String SickName) {
        this.SickName = SickName;
    }

    public String getFeeCode() {
        return this.FeeCode;
    }

    public void setFeeCode(String FeeCode) {
        this.FeeCode = FeeCode;
    }

    public String getMemoCode() {
        return this.MemoCode;
    }

    public void setMemoCode(String MemoCode) {
        this.MemoCode = MemoCode;
    }

    public String getFeeType() {
        return this.FeeType;
    }

    public void setFeeType(String FeeType) {
        this.FeeType = FeeType;
    }

    public String getSpecialSick() {
        return this.SpecialSick;
    }

    public void setSpecialSick(String SpecialSick) {
        this.SpecialSick = SpecialSick;
    }

    public void setMuteFlag(int muteFlag) {
        this.muteFlag = muteFlag;
    }

    public int getMuteFlag() {
        return muteFlag;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[NccmsickPK|").append(nccmsickPK.toString()).append("]\n");
        sb.append("[SickName:").append(SickName).append("]");
        sb.append("[FeeCode:").append(FeeCode).append("]");
        sb.append("[MemoCode:").append(MemoCode).append("]");
        sb.append("[FeeType:").append(FeeType).append("]");
        sb.append("[SpecialSick:").append(SpecialSick).append("]");
        return sb.toString();
    }

    public int hashCode(){
        int result = 0;
        result = nccmsickPK.hashCode();
        return result;
    }

    public boolean equals(Object vo) {
        if(this == vo)
            return true;
        if(!(vo instanceof NccmsickVO))
            return false;
        NccmsickVO eq = (NccmsickVO)vo;
        return nccmsickPK.equals(eq.getPrimaryKey());
    }
}