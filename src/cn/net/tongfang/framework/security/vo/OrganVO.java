package cn.net.tongfang.framework.security.vo;

//imports
import java.lang.StringBuffer;
import java.lang.String;
import java.io.Serializable;

/**
* <p>Title:Organ </p>
* <p>Description: Organ,Hibernate ”≥…‰VO </p>
* <p>Company: thtf yun nan Branch</p>
* @author PdmToVoGen1.0 
* @version 1.0
* @create datetime 2010-12-31 11:25:53.75
*/

public class OrganVO implements Serializable {
    //Fields
    //ID
    private String ID;
    //Name
    private String Name;
    
    private int muteFlag;
    
	//contructors
    public OrganVO() {}

    public OrganVO(String ID) {
        this.ID = ID;
    }

	//methods
    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setMuteFlag(int muteFlag) {
        this.muteFlag = muteFlag;
    }

    public int getMuteFlag() {
        return muteFlag;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[Name:").append(Name).append("]");
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
        if(!(vo instanceof OrganVO))
            return false;
        OrganVO eq = (OrganVO)vo;
        return ID == null ? eq.getID() == null : ID.equals(eq.getID());
    }
}