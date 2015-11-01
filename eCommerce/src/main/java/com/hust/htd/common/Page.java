package com.hust.htd.common;

/**
 * @author HuyTaDuc
 */

public class Page<E> {

	private Integer currentPage;
	private Integer totalPage;
	private Integer sizeofPage;
	private Integer sizeofList;
	private E content;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getSizeofPage() {
		return sizeofPage;
	}

	public void setSizeofPage(Integer sizeofPage) {
		this.sizeofPage = sizeofPage;
	}

	public Integer getSizeofList() {
		return sizeofList;
	}

	public void setSizeofList(Integer sizeofList) {
		this.sizeofList = sizeofList;
	}

	public E getContent() {
		return content;
	}

	public void setContent(E content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Pages [currentPage=" + currentPage + ", totalPage=" + totalPage + ", sizeofPage=" + sizeofPage
				+ ", sizeofList=" + sizeofList + ", content=" + content + "]";
	}

}
