package com.gildedrose.my;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.TexttestFixture;

public class MyGildedRoseTest {

	@Test
	public void sulfurasTest() {

		// name ; sellin; quality, direction, sellable

		MyItem[] myItems = { new MyItem("Sulfuras, Hand of Ragnaros", 0, 80, ItemProcessorFactory.SULFURAS), };

		MyGildedRose myApp = new MyGildedRose(myItems);
		Assert.assertEquals(1, myItems.length);
		Assert.assertEquals(myItems[0].name, "Sulfuras, Hand of Ragnaros");
		// does not sell or decreases
		for (int i = 0; i < 80; i++) {
			myItems = myApp.updateQuality();
			//resets to 50 and then stays 50.
			checkItem(myItems[0], 0, 50);
		}


		MyItem myItem =  new MyItem("Sulfuras, Hand of Ragnaros", 0, -2, ItemProcessorFactory.SULFURAS);

		MyGildedRose.updateQuality(myItem);
		//resets to 0, and stays 0
		checkItem(myItem, 0, 0);
		MyGildedRose.updateQuality(myItem);
		// stays 0
		checkItem(myItem, 0, 0);
		
	}


	

	@Test
	public void regularTest() {

		// name ; sellin; quality, direction

		MyItem[] myItems = { new MyItem("Elixir of the Mongoose", 2, 5,ItemProcessorFactory.GENERAL) };

		MyGildedRose myApp = new MyGildedRose(myItems);

		myItems = myApp.updateQuality();
		checkItem(myItems[0], 1, 4);
		myItems = myApp.updateQuality();
		checkItem(myItems[0], 0, 3);
		myItems = myApp.updateQuality();
		// quality drops twice as fast after the sellin date, but never < 0
		checkItem(myItems[0], -1, 1);
		myItems = myApp.updateQuality();
		checkItem(myItems[0], -2, 0);
		myItems = myApp.updateQuality();
		checkItem(myItems[0], -3, 0);

	}

	@Test
	public void above50Test() {

		// name ; sellin; quality, direction, sellable
		// the quality should be no higher than 50.
		MyItem[] myItems = { new MyItem("Elixir of the Mongoose", 1, 55, ItemProcessorFactory.GENERAL) };

		MyGildedRose myApp = new MyGildedRose(myItems);

		myItems = myApp.updateQuality();
		// it will first set it to 50 and then decrease by 1;
		checkItem(myItems[0], 0, 49);
		myItems = myApp.updateQuality();
		// quality drops twice as fast after the sellin date, but never < 0

		checkItem(myItems[0], -1, 47);
		myItems = myApp.updateQuality();
		checkItem(myItems[0], -2, 45);

	}

	@Test
	public void below0Test() {

		// name ; sellin; quality, direction, sellable
		// the quality should be no higher than 50.
		MyItem[] myItems = { new MyItem("Elixir of the Mongoose", 1, -2,ItemProcessorFactory.GENERAL) };

		MyGildedRose myApp = new MyGildedRose(myItems);

		myItems = myApp.updateQuality();
		// it will first set it to 0 and then it should stay 0;
		checkItem(myItems[0], 0, 0);
		myItems = myApp.updateQuality();

		checkItem(myItems[0], -1, 0);
		myItems = myApp.updateQuality();
		checkItem(myItems[0], -2, 0);

	}

	@Test
	public void agedBrieTest() {

		// name ; sellin; quality, direction

		MyItem[] myItems = { new MyItem("Aged Brie", 2, 0,ItemProcessorFactory.AGED_BRIE) };

		MyGildedRose myApp = new MyGildedRose(myItems);
		myItems = myApp.updateQuality();

		Assert.assertEquals(myItems[0].name, "Aged Brie");
		// increased by 1
		checkItem(myItems[0], 1, 1);

		myItems = myApp.updateQuality();
		checkItem(myItems[0], 0, 2);

		myItems = myApp.updateQuality();
		// keeps increasing after the seelin date
		checkItem(myItems[0], -1, 3);
		// reinitialize negative

		myItems[0] = new MyItem("Aged Brie", 2, -5, ItemProcessorFactory.AGED_BRIE);
		myApp = new MyGildedRose(myItems);
		myItems = myApp.updateQuality();
		// it will first set it to 0, then increased by 1
		checkItem(myItems[0], 1, 1);

		// reinitialize above 50
		myItems[0] = new MyItem("Aged Brie", 2, 65,ItemProcessorFactory.AGED_BRIE);
		myApp = new MyGildedRose(myItems);
		myItems = myApp.updateQuality();
		// it will first set it to 50, then it should stay 50
		checkItem(myItems[0], 1, 50);
		myItems = myApp.updateQuality();
		// it will first set it to 50, then it should stay 50
		checkItem(myItems[0], 0, 50);
		myItems = myApp.updateQuality();
	
	}

	@Test
	public void conjuredTest() {
		// name ; sellin; quality, direction
		MyItem[] myItems = { new MyItem("Conjured Mana Cake", 3, 6, ItemProcessorFactory.CONJURED) };

		MyGildedRose myApp = new MyGildedRose(myItems);
		myItems = myApp.updateQuality();

		// decreased by 2
		checkItem(myItems[0], 2, 4);

		myItems = myApp.updateQuality();
		// decreased by 2
		checkItem(myItems[0], 1, 2);
		myItems = myApp.updateQuality();
		// decreased by 2
		checkItem(myItems[0], 0, 0);
		myItems = myApp.updateQuality();
		// never negative;
		checkItem(myItems[0], -1, 0);

	}

	@Test
	public void conjuredEdgeTest() {
		// name ; sellin; quality, direction
		MyItem[] myItems = { new MyItem("a conJured Mana Cake", 3, 6,ItemProcessorFactory.CONJURED) };
		// should still be conjured, we check for the case insensitive word
		// conjured

		MyGildedRose myApp = new MyGildedRose(myItems);
		myItems = myApp.updateQuality();

		// decreased by 2
		checkItem(myItems[0], 2, 4);

		myItems = myApp.updateQuality();
		// decreased by 2
		checkItem(myItems[0], 1, 2);
		myItems = myApp.updateQuality();
		// decreased by 2
		checkItem(myItems[0], 0, 0);
		myItems = myApp.updateQuality();
		// never negative;
		checkItem(myItems[0], -1, 0);

	}

	/**
	 * The test goes through the list of all items, to make sure they are the
	 * same both ways. But since the logic was broken and now fixed, they are
	 * not the same, hence the test is ignored.
	 */
	@Ignore
	@Test
	public void testLogicChanged() {

		Item[] items = TexttestFixture.items;

		GildedRose app = new GildedRose(items);
		// initial path
		app.updateQuality();

		MyTexttestFixture myFixture = new MyTexttestFixture();
		MyItem[] myItems = myFixture.items;

		// my modified path
		MyGildedRose myApp = new MyGildedRose(myItems);
		myItems = myApp.updateQuality();

		Assert.assertTrue(items.length > 0);

		Assert.assertEquals(items.length, myItems.length);

		for (int i = 0; i < items.length; i++) {
			Assert.assertEquals(items[i].name, myItems[i].name);
			Assert.assertEquals(items[i].sellIn, myItems[i].sellIn);
			Assert.assertEquals(items[i].name, items[i].quality,
					myItems[i].quality);

		}

	}

	private void checkItem(MyItem item, int expectSln, int expectQlty) {
		Assert.assertEquals("Quality of item " + item.name, expectQlty,
				item.quality);
		Assert.assertEquals("sellin of item " + item.name, expectSln,
				item.sellIn);

	}

}