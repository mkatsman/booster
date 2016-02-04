package com.gildedrose.my;

import com.gildedrose.Item;

public class ConcertProcessor  implements ItemProcessor{

	@Override
	public Item updateQuality(Item item) {
	
			ItemProcessorHelper.checkBoundaries(item);

			item.sellIn = item.sellIn - 1;
			item.quality = item.quality < 50 ? item.quality + 1 : item.quality;
			// add a quality if 10 days or less
			item.quality = (item.sellIn < 11 && item.quality < 50) ? item.quality + 1
					: item.quality;
			// add more quality if 5 days or less
			item.quality = (item.sellIn < 6 && item.quality < 50) ? item.quality + 1
					: item.quality;
			item.quality = item.sellIn < 0 ? item.quality = 0 : item.quality;
			return item;
		}
	

}
