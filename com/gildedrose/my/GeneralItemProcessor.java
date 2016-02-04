package com.gildedrose.my;

import com.gildedrose.Item;

public class GeneralItemProcessor  implements ItemProcessor{
	private int decrement =  1;
	@Override
	public Item updateQuality(Item item) {
	
			ItemProcessorHelper.checkBoundaries(item);
		
			item.sellIn = item.sellIn - 1;

			item.quality = item.quality > 0 ? item.quality - getDecrement()
					: item.quality;
			// decrease quality for negative sellin
			item.quality = (item.sellIn < 0 & item.quality > 0) ? item.quality
					- getDecrement() : item.quality;
			return item;
		}
	public int getDecrement() {
		return decrement;
	}
	public void setDecrement(int decrement) {
		this.decrement = decrement;
	}

	
}
