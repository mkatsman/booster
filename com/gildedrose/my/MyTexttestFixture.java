package com.gildedrose.my;

import com.gildedrose.GildedRose;

public class MyTexttestFixture {
	// Added the type to the Item. Made the instance not static, so I could
	// reinitialize this for different tests.
	MyItem[] items = new MyItem[] {
			new MyItem("+5 Dexterity Vest", 10, 20,
					ItemProcessorFactory.GENERAL), //
			new MyItem("Aged Brie", 2, 0, ItemProcessorFactory.AGED_BRIE), //
			new MyItem("Elixir of the Mongoose", 5, 7,
					ItemProcessorFactory.GENERAL), //

			new MyItem("Sulfuras, Hand of Ragnaros", 0, 80,
					ItemProcessorFactory.SULFURAS), //
			new MyItem("Sulfuras, Hand of Ragnaros", -1, 80,
					ItemProcessorFactory.SULFURAS),
			new MyItem("Backstage passes to a TAFKAL80ETC concert", 15, 20,
					ItemProcessorFactory.CONCERT),
			new MyItem("Backstage passes to a TAFKAL80ETC concert", 10, 49,
					ItemProcessorFactory.CONCERT),
			new MyItem("Backstage passes to a TAFKAL80ETC concert", 5, 49,
					ItemProcessorFactory.CONCERT),
			new MyItem("Conjured Mana Cake", 3, 6,
					ItemProcessorFactory.CONJURED) };

	public static void main(String[] args) {
		MyTexttestFixture myFixture = new MyTexttestFixture();
		MyItem[] items = myFixture.items;
		System.out.println("OMGHAI!");

		GildedRose app = new GildedRose(items);

		int days = 2;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}

		for (int i = 0; i < days; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (MyItem item : items) {
				System.out.println(item);
			}
			System.out.println();
			app.updateQuality();
		}
	}

}
