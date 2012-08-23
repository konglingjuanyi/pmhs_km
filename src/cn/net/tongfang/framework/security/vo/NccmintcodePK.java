package cn.net.tongfang.framework.security.vo;

//imports
import java.lang.StringBuffer;
import java.lang.String;
import java.io.Serializable;

/**
* <p>Title:NccmIntCode </p>
* <p>Description: NccmIntCode,Hibernate ”≥…‰VO </p>
* <p>Company: thtf yun nan Branch</p>
* @author PdmToVoGen1.0 
* @version 1.0
* @create datetime 2010-12-31 11:25:53.75
*/

public class NccmintcodePK implements Serializable {
    //Fields
    private String TableNo;
    private String ItemNo;
    
	//contructors
    public NccmintcodePK() {}

    public NccmintcodePK(String TableNo, String ItemNo) {
        this.TableNo = TableNo;    
        this.ItemNo = ItemNo;    
    }

	//methods
    public String getTableNo() {
        return this.TableNo;
    }

    public void setTableNo(String TableNo) {
        this.TableNo = TableNo;
    }

    public String getItemNo() {
        return this.ItemNo;
    }

    public void setItemNo(String ItemNo) {
        this.ItemNo = ItemNo;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[TableNo:").append(TableNo).append("]\n");
        sb.append("[ItemNo:").append(ItemNo).append("]\n");
        return sb.toString();
    }

    public int hashCode(){
        int result = 0;
        result = 29*result +(TableNo==null ? 0 : TableNo.hashCode());
        result = 29*result +(ItemNo==null ? 0 : ItemNo.hashCode());
        return result;
    }

    public boolean equals(Object vo) {
        if(this == vo)
            return true;
        if(!(vo instanceof NccmintcodePK))
            return false;
        NccmintcodePK eq = (NccmintcodePK)vo;
        if(TableNo == null ? eq.getTableNo() != null : !TableNo.equals(eq.getTableNo()))
            return false;
        if(ItemNo == null ? eq.getItemNo() != null : !ItemNo.equals(eq.getItemNo()))
            return false;
        return true;
    }
}