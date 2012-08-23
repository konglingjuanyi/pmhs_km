package cn.net.tongfang.framework.security.vo;

//imports
import java.lang.StringBuffer;
import java.math.BigDecimal;
import java.lang.String;
import java.io.Serializable;

/**
* <p>Title:RecipeDetail </p>
* <p>Description: RecipeDetail,Hibernate ”≥…‰VO </p>
* <p>Company: thtf yun nan Branch</p>
* @author PdmToVoGen1.0 
* @version 1.0
* @create datetime 2010-12-31 11:25:53.75
*/

public class RecipedetailVO implements Serializable {
    //Fields
    //ID
    private String ID;
    //RecipeID
    private String RecipeID;
    //DrugID
    private String DrugID;
    //Amount
    private BigDecimal Amount;
    //RetailPrice
    private BigDecimal RetailPrice;
    //RetailMoney
    private BigDecimal RetailMoney;
    
    private int muteFlag;
    
	//contructors
    public RecipedetailVO() {}

    public RecipedetailVO(String ID) {
        this.ID = ID;
    }

	//methods
    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getRecipeID() {
        return this.RecipeID;
    }

    public void setRecipeID(String RecipeID) {
        this.RecipeID = RecipeID;
    }

    public String getDrugID() {
        return this.DrugID;
    }

    public void setDrugID(String DrugID) {
        this.DrugID = DrugID;
    }

    public BigDecimal getAmount() {
        return this.Amount;
    }

    public void setAmount(BigDecimal Amount) {
        this.Amount = Amount;
    }

    public BigDecimal getRetailPrice() {
        return this.RetailPrice;
    }

    public void setRetailPrice(BigDecimal RetailPrice) {
        this.RetailPrice = RetailPrice;
    }

    public BigDecimal getRetailMoney() {
        return this.RetailMoney;
    }

    public void setRetailMoney(BigDecimal RetailMoney) {
        this.RetailMoney = RetailMoney;
    }

    public void setMuteFlag(int muteFlag) {
        this.muteFlag = muteFlag;
    }

    public int getMuteFlag() {
        return muteFlag;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[RecipeID:").append(RecipeID).append("]");
        sb.append("[DrugID:").append(DrugID).append("]");
        sb.append("[Amount:").append(Amount).append("]");
        sb.append("[RetailPrice:").append(RetailPrice).append("]");
        sb.append("[RetailMoney:").append(RetailMoney).append("]");
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
        if(!(vo instanceof RecipedetailVO))
            return false;
        RecipedetailVO eq = (RecipedetailVO)vo;
        return ID == null ? eq.getID() == null : ID.equals(eq.getID());
    }
}