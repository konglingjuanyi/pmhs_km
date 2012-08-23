package cn.net.tongfang.framework.util.service.vo;

public class PagingParam {
	
	public static final int DEFAULT_LIMIT = 20;

	int start;
	int limit;

	public PagingParam() {
		start = 0;
		limit = DEFAULT_LIMIT;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
