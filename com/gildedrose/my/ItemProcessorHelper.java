package com.gildedrose.my;

import com.gildedrose.Item;

public class ItemProcessorHelper {
	public static Item checkBoundaries(Item item) {
		if (item.quality > 50) {
			// throw new Exception("Item quality exceeds the limit");
			// we do the batch processing, there should be some log, right now
			// just set to 50
			item.quality = 50;
		}

		if (item.quality < 0) {
			// throw new Exception("Item quality below 0");
			// we do the batch processing, there should be some log, right now
			// just set it to 0
			item.quality = 0;
		}
		return item;
	}

	
}
