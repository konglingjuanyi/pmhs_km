package cn.net.tongfang.framework.util.service.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CascadeOptVO implements Serializable{
    String key;
    String parentKey;
    String label;

    public CascadeOptVO(){}

    public CascadeOptVO(String key, String parentKey, String label) {
        super();
        this.key = key;
        this.parentKey = parentKey;
        this.label = label;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getParentKey() {
        return parentKey;
    }
    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }


}
