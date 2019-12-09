package com.kh.LatteWorld.item.model.vo;

import java.sql.Date;

public class ItemStore {
	private int itemNo;	// 아이템 번호(기본키)
	private int price;	// 가격
	private String itemCategory;	// 카테고리
	private int itemCount;			// 구매횟수
	private String itemLink;		// 아이템 경로(사실상 아이템 이름.확장자 들어감)
	private Date createDate;		// 생성 날짜
	private String itemStatus;		// 아이템 상태
	private String itemName;		// 아이템 이름(판매 시 보여줄 이름)
	
	public ItemStore() {}

	public ItemStore(int itemNo, int price, String itemCategory, int itemCount, String itemLink, Date createDate,
			String itemStatus, String itemName) {
		this.itemNo = itemNo;
		this.price = price;
		this.itemCategory = itemCategory;
		this.itemCount = itemCount;
		this.itemLink = itemLink;
		this.createDate = createDate;
		this.itemStatus = itemStatus;
		this.itemName = itemName;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public String getItemLink() {
		return itemLink;
	}

	public void setItemLink(String itemLink) {
		this.itemLink = itemLink;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemName() {
		return itemName;
	}

	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "ItemStore [itemNo=" + itemNo + ", price=" + price + ", itemCategory=" + itemCategory + ", itemCount="
				+ itemCount + ", itemLink=" + itemLink + ", createDate=" + createDate + ", itemStatus=" + itemStatus
				+ ", itemName=" + itemName + "]";
	}
}
