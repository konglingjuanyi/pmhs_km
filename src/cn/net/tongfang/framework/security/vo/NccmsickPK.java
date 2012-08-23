package cn.net.tongfang.framework.security.vo;

//imports
import java.lang.StringBuffer;
import java.lang.Integer;
import java.lang.String;
import java.io.Serializable;

/**
* <p>Title:NccmSick </p>
* <p>Description: NccmSick,Hibernate ”≥…‰VO </p>
* <p>Company: thtf yun nan Branch</p>
* @author PdmToVoGen1.0 
* @version 1.0
* @create datetime 2010-12-31 11:25:53.75
*/

public class NccmsickPK implements Serializable {
    //Fields
    private String SickCode;
    private Integer MediType;
    
	//contructors
    public NccmsickPK() {}

    public NccmsickPK(String SickCode, Integer MediType) {
        this.SickCode = SickCode;    
        this.MediType = MediType;    
    }

	//methods
    public String getSickCode() {
        return this.SickCode;
    }

    public void setSickCode(String SickCode) {
        this.SickCode = SickCode;
    }

    public Integer getMediType() {
        return this.MediType;
    }

    public void setMediType(Integer MediType) {
        this.MediType = MediType;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[SickCode:").append(SickCode).append("]\n");
        sb.append("[MediType:").append(MediType).append("]\n");
        return sb.toString();
    }

    public int hashCode(){
        int result = 0;
        result = 29*result +(SickCode==null ? 0 : SickCode.hashCode());
        result = 29*result +(MediType==null ? 0 : MediType.hashCode());
        return result;
    }

    public boolean equals(Object vo) {
        if(this == vo)
            return true;
        if(!(vo instanceof NccmsickPK))
            return false;
        NccmsickPK eq = (NccmsickPK)vo;
        if(SickCode == null ? eq.getSickCode() != null : !SickCode.equals(eq.getSickCode()))
            return false;
        if(MediType == null ? eq.getMediType() != null : !MediType.equals(eq.getMediType()))
            return false;
        return true;
    }
}