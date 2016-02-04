package com.gildedrose.my;

public class ConjuredProcessor  extends  GeneralItemProcessor{
//twice as the general item.
	int decrement =  2;
	@Override
	public int getDecrement() {
		return decrement;
	}
	@Override
	public void setDecrement(int decrement) {
		this.decrement = decrement;
	}


}
