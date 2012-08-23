package cn.net.tongfang.framework.security.vo;

//imports
import java.lang.StringBuffer;
import java.lang.String;
import java.io.Serializable;

/**
* <p>Title:NccmIntCode </p>
* <p>Description: NccmIntCode,Hibernate Ó³ÉäVO </p>
* <p>Company: thtf yun nan Branch</p>
* @author PdmToVoGen1.0 
* @version 1.0
* @create datetime 2010-12-31 11:25:53.75
*/

public class NccmintcodeVO implements Serializable {
    //Fields
    //TableName
    private String TableName;
    //ItemValue
    private String ItemValue;
    
    private int muteFlag;
    //¸´ºÏÖ÷¼ü
    private NccmintcodePK nccmintcodePK;
    
	//contructors
    public NccmintcodeVO() {
        this.nccmintcodePK = new NccmintcodePK();
    }

    public NccmintcodeVO(NccmintcodePK nccmintcodePK) {
        this.nccmintcodePK = nccmintcodePK;
    }

	//methods
    public void setPrimaryKey(NccmintcodePK nccmintcodePK) {
        this.nccmintcodePK = nccmintcodePK;
    }

    public NccmintcodePK getPrimaryKey() {
        return nccmintcodePK;
    }

    public String getTableName() {
        return this.TableName;
    }

    public void setTableName(String TableName) {
        this.TableName = TableName;
    }

    public String getItemValue() {
        return this.ItemValue;
    }

    public void setItemValue(String ItemValue) {
        this.ItemValue = ItemValue;
    }

    public void setMuteFlag(int muteFlag) {
        this.muteFlag = muteFlag;
    }

    public int getMuteFlag() {
        return muteFlag;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[NccmintcodePK|").append(nccmintcodePK.toString()).append("]\n");
        sb.append("[TableName:").append(TableName).append("]");
        sb.append("[ItemValue:").append(ItemValue).append("]");
        return sb.toString();
    }

    public int hashCode(){
        int result = 0;
        result = nccmintcodePK.hashCode();
        return result;
    }

    public boolean equals(Object vo) {
        if(this == vo)
            return true;
        if(!(vo instanceof NccmintcodeVO))
            return false;
        NccmintcodeVO eq = (NccmintcodeVO)vo;
        return nccmintcodePK.equals(eq.getPrimaryKey());
    }
}