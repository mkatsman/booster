package com.gildedrose.my;

import java.util.HashMap;
import java.util.Map;

class MyGildedRose {

	public static final String AGED_BRIE = "AgedBrie";
	public static final String CONCERT = "Concert";
	public static final String CONJURED = "Conjured";
	public static final String GENERAL = "General";
	public static final String SULFURAS = "Sulfuras";

	MyItem[] items;
	static Map<String, ItemProcessor> processorMap = new HashMap<String, ItemProcessor>();

	static {
		processorMap.put(AGED_BRIE, new BrieProcessor());
		processorMap.put(CONCERT, new ConcertProcessor());
		processorMap.put(CONJURED, new ConjuredProcessor());
		processorMap.put(GENERAL, new GeneralItemProcessor());
		processorMap.put(SULFURAS, new SulfurasProcessor());
	}

	public MyGildedRose(MyItem[] items2) {
		this.items = items2;
	}

	public static MyItem updateQuality(MyItem item) {
		ItemProcessor processor = getProcessor(item.type);
		processor.updateQuality(item);
		return item;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			updateQuality(items[i]);
		}
	}

	public static  ItemProcessor getProcessor(String criteria) {

		if (processorMap.get(criteria) != null) {
			return processorMap.get(criteria);
		} else {
			// unknown type
			return new GeneralItemProcessor();
		}
	}

}
