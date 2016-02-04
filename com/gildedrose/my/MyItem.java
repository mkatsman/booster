package com.gildedrose.my;

import com.gildedrose.Item;

public class MyItem extends Item {
	String type;

	public MyItem(String name, int sellIn, int quality, String type) {
		super(name, sellIn, quality);
		this.type = type;
	}

}
