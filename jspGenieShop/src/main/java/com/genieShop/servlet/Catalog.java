package com.genieShop.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {
	
	private static Map<String, CatalogItem> catalogItems = new HashMap<>();
	
	/**
	 * add item to CatalogItem map
	 * @param item
	 */
	public static void addItem(CatalogItem item) {
		catalogItems.put(item.getSku(), item);
	}
	
	/**
	 * return an CatalogItem bssed on sku name
	 * @param sku
	 * @return
	 */
	public static CatalogItem getItem(String sku) {
		return catalogItems.get("sku");
		
	}
	
	/**
	 * return list of CatalogItem extract from Hashmap
	 * @return
	 */
	public static List<CatalogItem> getItems(){
		return new ArrayList<CatalogItem>(catalogItems.values());
	}

}
