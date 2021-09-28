package com.genieShop.servlet;

import javax.persistence.*;

@Entity

@Table
public class CatalogItem {
	
	@Id
	@ GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String name;
	private String manufacturer;
	private String sku;
	
	public CatalogItem(int id, String name, String manufacturer, String sku) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.sku = sku;
	}
	
	
	public CatalogItem(String name, String manufacturer, String sku) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.sku = sku;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getSku() {
		return sku;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}

	
	@Override
	public String toString() {
		return "CatalogItem [name=" + name + ", manufacturer=" + manufacturer + ", sku=" + sku + "]";
	}
	
	

}
