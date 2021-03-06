package com.webstore.shop.domain;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import com.webstore.shop.utiil.ValueFormat;

@XmlRootElement	
public class Product implements Serializable{	//상품정보에 대한 Class
	/**
	 * 
	 */
	private static final long serialVersionUID = 433800240426629883L;
	private String productId;	//품번
	private String name;	//제품명
	private BigDecimal unitPrice;	
	private String unitPriceStr;	//단가정보
	private String description;		//상품
	private String manufacturer;	//제조사
	private String category;	//카테고리
	private long unitsInStock;	//재고관련
	private String unitsInStockStr;	//재고수량, 단위표시와 관련
	private long unitsInOrder;	//주문관련
	private boolean discontinued;
	private String condition;	//상태정보
	@JsonIgnore
	private MultipartFile productImage;	//이미지 파일 삽입 관련
	@JsonIgnore
	private MultipartFile productManual;//제품 메뉴얼 삽입 관련
	
	public Product() {
			//디폴트 생성자
	}

	public Product(String productId, String name, BigDecimal unitPrice) {
		//
		this.productId = productId;
		this.name = name;
		this.setUnitPrice(unitPrice);
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnitPriceStr() {
		return unitPriceStr;
	}

	public void setUnitPriceStr(String unitPriceStr) {
		this.unitPriceStr = unitPriceStr;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock; 
		this.unitsInStockStr =
				ValueFormat.format(unitsInStock, ValueFormat.COMMAS);
	}

	public String getUnitsInStockStr() {
		return unitsInStockStr;
	}

	public void setUnitsInStockStr(String unitsInStockStr) {
		this.unitsInStockStr = unitsInStockStr;
	}

	public long getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	@XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	@XmlTransient
	public MultipartFile getProductManual() {
		return productManual;
	}

	public void setProductManual(MultipartFile productManual) {
		this.productManual = productManual;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null) return false;
		if(getClass() != obj.getClass()) return false;
		Product other =(Product) obj;
		if(productId == null) {
			if(other.productId!=null)
				return false;
		}else if(!productId.equals(other.productId))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime=31;
		int result=1;
		result=prime*result+((productId==null)?0:productId.hashCode());
		return result;
	}
	
}
