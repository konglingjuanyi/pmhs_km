package cn.net.tongfang.web.service.bo;

import java.util.List;

import cn.net.tongfang.framework.security.SecurityManager;
import cn.net.tongfang.framework.security.demo.service.TaxempDetail;
import cn.net.tongfang.framework.security.vo.DocumentSave;
import cn.net.tongfang.framework.security.vo.HealthEducat;

public class HealthEducatBO extends HealthEducat {
	List<DocumentSave> documentSave;

	public HealthEducatBO() {
		// todo 和瑞菁确认
		TaxempDetail currentOperator = SecurityManager.currentOperator();
		if (currentOperator != null)
			this.setOrgId(currentOperator.getOrgId());
		else {
			this.setOrgId(0);
		}
	}

	public List<DocumentSave> getDocumentSave() {
		return documentSave;
	}

	public void setDocumentSave(List<DocumentSave> documentSave) {
		this.documentSave = documentSave;
	}

}
