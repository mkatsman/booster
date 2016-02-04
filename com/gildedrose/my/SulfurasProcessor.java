package com.gildedrose.my;

import com.gildedrose.Item;

public class SulfurasProcessor  implements ItemProcessor{

	@Override
	public Item updateQuality(Item item) {
		//should we allow the quality to be greater than 50 or less than 0?
		ItemProcessorHelper.checkBoundaries(item);
		//Does not selin or change quantity
		return item;
	}

}
