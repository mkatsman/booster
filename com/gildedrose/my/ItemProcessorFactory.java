package com.gildedrose.my;


public class ItemProcessorFactory {
	public static final String AGED_BRIE = "AgedBrie";
	public static final String CONCERT = "Concert";
	public static final String CONJURED = "Conjured";
	public static final String GENERAL = "General";
	public static final String SULFURAS = "Sulfuras";

	public static ItemProcessor getProcessor(String criteria)  {
		if (criteria.equals(AGED_BRIE))
			return new BrieProcessor();
		else if (criteria.equals(CONCERT))
			return new ConcertProcessor();
		else if (criteria.equals(CONJURED))
			return new ConjuredProcessor();
		else if (criteria.equals(GENERAL))
			return new GeneralItemProcessor();
		else if (criteria.equals(SULFURAS))
			return new SulfurasProcessor();
		
		else{
			//unknown type
			return new GeneralItemProcessor();
		}
	}

}
