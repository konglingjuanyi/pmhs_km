package cn.net.tongfang.framework.util;

public class ExcelUtils {
	private Integer row;
	private Integer col;
	private String title;
	private String[] titleSub;
	public ExcelUtils() {
		super();
	}
	public ExcelUtils(Integer row, Integer col, String title,String[] titleSub) {
		super();
		this.row = row;
		this.col = col;
		this.title = title;
		this.titleSub = titleSub;
	}
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public Integer getCol() {
		return col;
	}
	public void setCol(Integer col) {
		this.col = col;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String[] getTitleSub() {
		return titleSub;
	}
	public void setTitleSub(String[] titleSub) {
		this.titleSub = titleSub;
	}
	
	
}
