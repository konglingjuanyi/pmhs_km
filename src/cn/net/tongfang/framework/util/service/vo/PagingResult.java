package cn.net.tongfang.framework.util.service.vo;

import java.util.List;

public class PagingResult<T> {
	int totalSize;
	List<T> data;
	
	
	
	public PagingResult(int totalSize, List<T> data) {
		super();
		this.totalSize = totalSize;
		this.data = data;
	}



	public int getTotalSize() {
		return totalSize;
	}



	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}



	public List<T> getData() {
		return data;
	}



	public void setData(List<T> data) {
		this.data = data;
	}

	
}
