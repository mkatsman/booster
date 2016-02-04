package com.gildedrose.my;


class MyGildedRose {
	MyItem[] items;

	public MyGildedRose(MyItem[] items2) {
		this.items = items2;
	}

	public static MyItem updateQuality(MyItem item) {
			ItemProcessor processor = ItemProcessorFactory.getProcessor(item.type);
		    processor.updateQuality(item);
		return item;
	}

	public MyItem[] updateQuality() {
		for (int i = 0; i < items.length; i++) {
			updateQuality(items[i]);
		}
		return items;
	}
	
}
