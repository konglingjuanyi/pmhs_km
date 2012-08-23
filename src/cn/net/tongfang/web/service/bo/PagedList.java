package cn.net.tongfang.web.service.bo;

import java.util.List;

public class PagedList {
	public int currentPage;
	public int pageSize;
	public long totalLines;
	public int totalPages;
	public List res;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalLines() {
		return totalLines;
	}
	public void setTotalLines(long totalLines) {
		this.totalLines = totalLines;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List getRes() {
		return res;
	}
	public void setRes(List res) {
		this.res = res;
	}
	
}
