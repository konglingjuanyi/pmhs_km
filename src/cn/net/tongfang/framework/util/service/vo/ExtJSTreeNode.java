package cn.net.tongfang.framework.util.service.vo;

import java.util.ArrayList;
import java.util.List;

public class ExtJSTreeNode {
	/*
	 * [ { "text" : "登记信息管理", "id": 'regMgr', "leaf" : false, "cls" : "folder",
	 * "children" : [ {"text" : "个人预登记信息审核", "id": '/js/app/ireg.js', "leaf" :
	 * true, "cls" : "file"}, {"text" : "个人预登记信息查询", "id": 'individualQry.js',
	 * "leaf" : true, "cls" : "file"} ] },
	 */

	private String text, id, cls;
	private boolean leaf;
	
	private List<ExtJSTreeNode> children = new ArrayList<ExtJSTreeNode>();

	private Object data;

	public ExtJSTreeNode(String text, String id, String cls, boolean leaf) {
		this.text = text;
		this.id = id;
		this.cls = cls;
		this.leaf = leaf;
	}
	public ExtJSTreeNode(String text, String id, String cls, boolean leaf, Object data) {
		this.text = text;
		this.id = id;
		this.cls = cls;
		this.leaf = leaf;
		this.data = data;
	}
	public ExtJSTreeNode(String text, String id, boolean leaf, Object data) {
		this.text = text;
		this.id = id;
		this.leaf = leaf;
		if ( leaf ) {
			this.cls = "file";
		} else {
			this.cls = "folder";
		}
		this.data = data;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public List<ExtJSTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<ExtJSTreeNode> children) {
		this.children = children;
	}

	public void addChild(ExtJSTreeNode node) {
		this.children.add(node);
	}

	public void addChildren(List<ExtJSTreeNode> children) {
		this.children.addAll(children);
	}

}
