package com.gildedrose.my;

import com.gildedrose.Item;

public class BrieProcessor  implements ItemProcessor{

	@Override
	public Item updateQuality(Item item) {
		
			ItemProcessorHelper.checkBoundaries(item);

			item.sellIn = item.sellIn - 1;
			item.quality = item.quality < 50 ? item.quality + 1 : item.quality;
			return item;
		}
	}


