package com.sales.taxes.util;

import java.lang.reflect.InvocationTargetException;

import com.sales.taxes.enums.Origin;
import com.sales.taxes.item.AbstractItem;

public abstract class AbstractBuilder {

	public final static class ItemBuilder<T extends AbstractItem> {
		private Class<? extends AbstractItem> clazz;
		private Origin origin;
		private String name;
		private float unitPrice;
		private float netPrice;
		private float grossPrice;
		private int qty;

		public ItemBuilder(Class<? extends AbstractItem> clazz, Origin origin, String name, int qty, float unitPrice) {
			this.clazz = clazz;
			this.origin = origin;
			this.name = name;
			this.qty = qty;
			this.unitPrice = unitPrice;
			this.netPrice = this.unitPrice * this.qty;
			this.grossPrice = this.netPrice;
		}

		public Origin getOrigin() {
			return origin;
		}

		public String getName() {
			return name;
		}

		public float getUnitPrice() {
			return unitPrice;
		}

		public float getNetPrice() {
			return netPrice;
		}

		public float getGrossPrice() {
			return grossPrice;
		}

		public int getQty() {
			return qty;
		}

		public T build() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
				InvocationTargetException, NoSuchMethodException, SecurityException {
			return (T) clazz.getDeclaredConstructor(ItemBuilder.class).newInstance(this);
		}

	}

}
